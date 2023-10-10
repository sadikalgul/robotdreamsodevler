package com.robotdreams.mapper;

import com.robotdreams.models.Course;
import com.robotdreams.models.Student;
import com.robotdreams.models.dto.CourseDTO;
import com.robotdreams.models.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentEntityStudentDTOMapper implements BaseMapper<StudentDTO,Student>{

    private final CourseEntityCourseDTOMapper courseEntityCourseDTOMapper;

    @Autowired
    public StudentEntityStudentDTOMapper(CourseEntityCourseDTOMapper courseEntityCourseDTOMapper) {
        this.courseEntityCourseDTOMapper = courseEntityCourseDTOMapper;
    }

    @Override
    public StudentDTO map(Student student, Object... params) {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setGender(student.getGender());
        studentDTO.setBirtDate(student.getBirtDate());

        List<CourseDTO> courseList = new ArrayList<>();
        if (Objects.nonNull(student.getCourseList()))
            student.getCourseList().forEach(v-> courseList.add(courseEntityCourseDTOMapper.map(v,null)));
        studentDTO.setCourseList(courseList);

        return studentDTO;
    }
}
