package com.robotdreams.schoolmanage.mapper;


import com.robotdreams.schoolmanage.models.Course;
import com.robotdreams.schoolmanage.models.dto.CourseDTO;
import org.springframework.stereotype.Component;


@Component
public class CourseEntityCourseDTOMapper implements BaseMapper<CourseDTO, Course> {
    @Override
    public CourseDTO map(Course course, Object... params) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setCode(course.getCode());
        courseDTO.setCreditScore(course.getCreditScore());

        return courseDTO;
    }
}
