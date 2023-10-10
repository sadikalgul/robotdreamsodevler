package com.robotdreams.service;

import com.robotdreams.models.Student;
import com.robotdreams.models.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO findStudentById(long id);
    List<StudentDTO> getAllStudent();
    Student saveStudent(StudentDTO student);
    void deleteStudent(long id);

}
