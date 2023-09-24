package com.robotdreams.initializer;

import com.robotdreams.models.*;
import com.robotdreams.repository.CourseRepository;
import com.robotdreams.repository.InstructorRepository;
import com.robotdreams.repository.SalaryTypeRepository;
import com.robotdreams.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestDataInitializer implements ApplicationRunner {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;
    private final SalaryTypeRepository salaryTypeRepository;


    @Autowired
    public TestDataInitializer(CourseRepository courseRepository, StudentRepository studentRepository, InstructorRepository instructorRepository, SalaryTypeRepository salaryTypeRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
        this.salaryTypeRepository = salaryTypeRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("Start Process");

        Student student1 = new Student("Sadik Algul","Istanbul","Male","1982");
        Course course1 = new Course("Math","M101",5);
        Course course2 = new Course("Bio","B101",4);


        SalaryType salaryType1 = new SalaryType("H");
        SalaryType salaryType2 = new SalaryType("F");

        Instructor instructor1 = new VisitingInstructor("Koray Guney","12345",salaryType1);

        Instructor instructor2 = new PermanentInstructor("Albert Einstein","1357777",salaryType2);


        // course1.getStudentList().add(student1);
        course1.setCourseInstructor(instructor1);

        // course2.getStudentList().add(student1);
        course2.setCourseInstructor(instructor2);

        student1.getCourseList().add(course1);
        student1.getCourseList().add(course2);

        studentRepository.save(student1);
        salaryTypeRepository.save(salaryType1);
        salaryTypeRepository.save(salaryType2);
        courseRepository.save(course1);
        courseRepository.save(course2);
        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);

        System.out.println("End Process");


    }
}
