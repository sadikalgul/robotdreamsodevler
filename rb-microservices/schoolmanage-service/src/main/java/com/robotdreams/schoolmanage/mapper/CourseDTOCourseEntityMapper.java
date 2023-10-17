package com.robotdreams.schoolmanage.mapper;


import com.robotdreams.schoolmanage.models.Course;
import com.robotdreams.schoolmanage.models.dto.CourseDTO;

public class CourseDTOCourseEntityMapper implements BaseMapper<Course, CourseDTO>{
    @Override
    public Course map(CourseDTO courseDTO, Object... params) {
        Course course = Course.builder()
                .name(courseDTO.getName())
                .code(courseDTO.getCode())
                .creditScore(courseDTO.getCreditScore())
                .build();
        if (courseDTO.getId() !=0) course.setId(courseDTO.getId());
        return course;
    }
}
