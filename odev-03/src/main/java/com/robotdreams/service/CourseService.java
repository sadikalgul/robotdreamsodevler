package com.robotdreams.service;

import com.robotdreams.models.Course;

import java.util.List;

public interface CourseService {
    public Course findCourseById(long id);
    List<Course> getAllCourse();
    Course saveCourse(Course course);
    void deleteCourse(long id);
}
