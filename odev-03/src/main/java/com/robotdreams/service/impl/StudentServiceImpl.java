package com.robotdreams.service.impl;

import com.robotdreams.exception.ErrorDetails;
import com.robotdreams.models.Student;
import com.robotdreams.repository.StudentRepository;
import com.robotdreams.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@Qualifier("Student")
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findStudentById(long id) {

        return studentRepository.findById(id).orElseThrow(() -> new ErrorDetails("Student id not found in DB"));
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {

        studentRepository.deleteById(id);
    }
}
