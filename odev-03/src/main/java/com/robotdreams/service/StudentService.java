package com.robotdreams.service;

import com.robotdreams.models.Student;

import java.util.List;

public interface StudentService {

    Student findStudentById(long id);
    List<Student> getAllStudent();
    Student saveStudent(Student student);
    void deleteStudent(long id);

}
