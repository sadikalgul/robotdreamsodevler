package com.robotdreams.service;

import com.robotdreams.models.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor findInstructorById(long id);
    List<Instructor> getAllInstructor();
    Instructor saveInstructor(Instructor instructor);
    void deleteInstructor(long id);
}
