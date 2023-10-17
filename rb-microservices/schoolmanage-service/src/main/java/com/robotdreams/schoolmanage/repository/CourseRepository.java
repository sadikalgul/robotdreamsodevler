package com.robotdreams.schoolmanage.repository;


import com.robotdreams.schoolmanage.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
