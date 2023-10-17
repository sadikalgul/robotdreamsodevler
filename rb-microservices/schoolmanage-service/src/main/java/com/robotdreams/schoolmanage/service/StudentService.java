package com.robotdreams.schoolmanage.service;


import com.robotdreams.schoolmanage.models.Student;
import com.robotdreams.schoolmanage.models.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO findStudentById(long id);
    List<StudentDTO> getAllStudent();
    Student saveStudent(StudentDTO student);
    void deleteStudent(long id);

}
