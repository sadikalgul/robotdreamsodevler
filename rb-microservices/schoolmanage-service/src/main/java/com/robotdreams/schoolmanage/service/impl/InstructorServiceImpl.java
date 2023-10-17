package com.robotdreams.schoolmanage.service.impl;



import com.robotdreams.schoolmanage.exception.ErrorDetails;
import com.robotdreams.schoolmanage.models.Instructor;
import com.robotdreams.schoolmanage.repository.InstructorRepository;
import com.robotdreams.schoolmanage.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("Instructor")
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public Instructor findInstructorById(long id) {
        return instructorRepository.findById(id).orElseThrow(() -> new ErrorDetails("Instructor id not found in DB"));
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructor(long id) {
        instructorRepository.deleteById(id);
    }
}
