package com.robotdreams.schoolmanage.service.impl;


import com.robotdreams.schoolmanage.exception.ErrorDetails;
import com.robotdreams.schoolmanage.models.Course;
import com.robotdreams.schoolmanage.repository.CourseRepository;
import com.robotdreams.schoolmanage.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Qualifier("Course")
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findCourseById(long id) {
        return courseRepository.findById(id).orElseThrow(() -> new ErrorDetails("Course id not found in DB"));
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }


}
