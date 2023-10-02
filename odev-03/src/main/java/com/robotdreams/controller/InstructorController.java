package com.robotdreams.controller;


import com.robotdreams.models.Instructor;
import com.robotdreams.models.PermanentInstructor;
import com.robotdreams.models.SalaryType;
import com.robotdreams.models.VisitingInstructor;
import com.robotdreams.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping("/instructor/{id}")
    public Instructor getInstructorById(@PathVariable Long id){
        return instructorService.findInstructorById(id);

    }

    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors(){
        return instructorService.getAllInstructor();

    }

/*    @PostMapping(value = "/student",consumes = "application/json;charset=UTF-8")
    public Student saveStudent(@RequestBody Student student){
        System.out.println("name:"+student.getName());
        return studentService.saveStudent(student);
    }*/

    @PostMapping(value = "/instructor")
    public Instructor saveInstructor(
            @RequestParam("instructorName") @Valid String name,
            @RequestParam("instructorPhone") @Valid String phone,
            @RequestParam("salaryType") @Valid String salaryCode) {

        SalaryType  salaryType = new SalaryType(salaryCode);
        Instructor instructor = salaryCode.equals("H") ? new VisitingInstructor(name,phone,salaryType) : new PermanentInstructor(name,phone,salaryType);
        return instructorService.saveInstructor(instructor);
    }

    /*   @PutMapping("/student")
       public Student updateStudent(@RequestBody @Valid Student student){
           return studentService.saveStudent(student);
       }
   */
    @PutMapping("/instructor")
    public Instructor updateInstructor(
            @RequestParam("studentId") @Valid Long id,
            @RequestParam("instructorName") @Valid String name,
            @RequestParam("instructorPhone") @Valid String phone) {
        Instructor instructor = instructorService.findInstructorById(id);
        instructor.setName(name);
        instructor.setPhoneNumber(phone);
        return instructorService.saveInstructor(instructor);
    }

    @DeleteMapping("/instructor")
    public void deleteInstructor(@RequestParam("instructorId")  long id){
        instructorService.deleteInstructor(id);
    }

}
