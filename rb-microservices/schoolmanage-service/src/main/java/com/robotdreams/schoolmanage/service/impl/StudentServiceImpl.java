package com.robotdreams.schoolmanage.service.impl;


import com.robotdreams.client.notification.NotificationClient;
import com.robotdreams.client.notification.NotificationRequest;
import com.robotdreams.rabbitMQ.RabbitMQMessageProducer;
import com.robotdreams.schoolmanage.exception.ErrorDetails;
import com.robotdreams.schoolmanage.mapper.StudentDTOStudentEntityMapper;
import com.robotdreams.schoolmanage.mapper.StudentEntityStudentDTOMapper;
import com.robotdreams.schoolmanage.models.Student;
import com.robotdreams.schoolmanage.models.dto.StudentDTO;
import com.robotdreams.schoolmanage.repository.StudentRepository;
import com.robotdreams.schoolmanage.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Qualifier("Student")
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Value("${rabbitmq.exchanges.internal}")
    private String notificationExchange;

    @Value("${rabbitmq.queues.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String notificationRoutingKey;

    private final StudentRepository studentRepository;

    private final StudentEntityStudentDTOMapper studentEntityStudentDTOMapper;

    private final StudentDTOStudentEntityMapper studentDTOStudentEntityMapper;

    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    private final NotificationClient notificationClient;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentEntityStudentDTOMapper studentEntityStudentDTOMapper, StudentDTOStudentEntityMapper studentDTOStudentEntityMapper, RabbitMQMessageProducer rabbitMQMessageProducer, NotificationClient notificationClient) {
        this.studentRepository = studentRepository;
        this.studentEntityStudentDTOMapper = studentEntityStudentDTOMapper;
        this.studentDTOStudentEntityMapper = studentDTOStudentEntityMapper;
        this.rabbitMQMessageProducer = rabbitMQMessageProducer;
        this.notificationClient = notificationClient;
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDTO findStudentById(long id) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new ErrorDetails("Student id not found in DB"));
        return studentEntityStudentDTOMapper.map(student,null);
    }

    @Override
    @Transactional(readOnly = true) // readonly true daha performanslı okumayı sağlıyor
    public List<StudentDTO> getAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentList.stream().forEach(s -> studentDTOList.add(studentEntityStudentDTOMapper.map(s,null)));
        return studentDTOList;

    }

    @Override
    @Transactional
    public Student saveStudent(StudentDTO studentDTO) {
        Student student = studentDTOStudentEntityMapper.map(studentDTO);
        studentRepository.save(student);
        log.info("Student saved succesfully");
        NotificationRequest notificationRequest = NotificationRequest.builder()
                .toCustomerId(student.getId())
                .toCustomerPhone(student.getAddress())
                .message("Hello" + student.getName() + "Student saved...")
                .build();

       // notificationClient.sendNotification(notificationRequest);

        rabbitMQMessageProducer.publish(notificationRequest,notificationExchange,notificationRoutingKey);

        return student;

    }

    @Override
    @Transactional
    public void deleteStudent(long id) {

        studentRepository.deleteById(id);
    }
}
