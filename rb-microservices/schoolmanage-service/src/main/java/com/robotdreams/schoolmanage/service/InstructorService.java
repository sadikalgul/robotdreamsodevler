package com.robotdreams.schoolmanage.service;


import com.robotdreams.schoolmanage.models.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor findInstructorById(long id);
    List<Instructor> getAllInstructor();
    Instructor saveInstructor(Instructor instructor);
    void deleteInstructor(long id);
}
