package com.robotdreams.schoolmanage.mapper;


import com.robotdreams.schoolmanage.models.Student;
import com.robotdreams.schoolmanage.models.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentDTOStudentEntityMapper implements BaseMapper<Student, StudentDTO> {
    @Override
    public Student map(StudentDTO studentDTO, Object... params) {

        Student student = Student.builder()
                .name(studentDTO.getName())
                .address(studentDTO.getAddress())
                .gender(studentDTO.getGender())
                .birtDate(studentDTO.getBirtDate())
                .build();
        if (studentDTO.getId() !=0) student.setId(studentDTO.getId());
        return student;
    }
}
