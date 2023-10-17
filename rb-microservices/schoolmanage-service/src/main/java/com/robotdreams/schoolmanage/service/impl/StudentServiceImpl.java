package com.robotdreams.schoolmanage.service.impl;


import com.robotdreams.schoolmanage.exception.ErrorDetails;
import com.robotdreams.schoolmanage.mapper.StudentDTOStudentEntityMapper;
import com.robotdreams.schoolmanage.mapper.StudentEntityStudentDTOMapper;
import com.robotdreams.schoolmanage.models.Student;
import com.robotdreams.schoolmanage.models.dto.StudentDTO;
import com.robotdreams.schoolmanage.repository.StudentRepository;
import com.robotdreams.schoolmanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Qualifier("Student")
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentEntityStudentDTOMapper studentEntityStudentDTOMapper;

    private final StudentDTOStudentEntityMapper studentDTOStudentEntityMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentEntityStudentDTOMapper studentEntityStudentDTOMapper, StudentDTOStudentEntityMapper studentDTOStudentEntityMapper) {
        this.studentRepository = studentRepository;
        this.studentEntityStudentDTOMapper = studentEntityStudentDTOMapper;
        this.studentDTOStudentEntityMapper = studentDTOStudentEntityMapper;
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
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(long id) {

        studentRepository.deleteById(id);
    }
}
