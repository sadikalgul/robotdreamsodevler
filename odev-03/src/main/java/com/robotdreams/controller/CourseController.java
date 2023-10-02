package com.robotdreams.controller;

import com.robotdreams.models.Course;
import com.robotdreams.models.Instructor;
import com.robotdreams.models.Student;
import com.robotdreams.service.CourseService;
import com.robotdreams.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;
    private final InstructorService instructorService;

    @Autowired
    public CourseController(CourseService courseService, InstructorService instructorService) {

        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.findCourseById(id);
    }


    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourse();

    }

/*    @PostMapping(value = "/student",consumes = "application/json;charset=UTF-8")
    public Student saveStudent(@RequestBody Student student){
        System.out.println("name:"+student.getName());
        return studentService.saveStudent(student);
    }*/

    @PostMapping(value = "/course")
    public Course saveCourse(
            @RequestParam("courseName") @Valid String name,
            @RequestParam("courseCode") @Valid String code,
            @RequestParam("courseCredit") @Valid Integer credit,
            @RequestParam(name = "instructorId",defaultValue = "0") Long id) {
        Instructor instructor = id >0 ? instructorService.findInstructorById(id):null;
        Course course = new Course(name,code,credit);
        if(instructor != null)
            course.setCourseInstructor(instructor);
        return courseService.saveCourse(course);
    }


    /*   @PutMapping("/student")
       public Student updateStudent(@RequestBody @Valid Student student){
           return studentService.saveStudent(student);
       }
   */
    @PutMapping("/course")
    public Course updateStudent(
            @RequestParam("courseId") @Valid Long id,
            @RequestParam("courseName") @Valid String name,
            @RequestParam("courseCode") @Valid String code,
            @RequestParam("courseCredit") @Valid Integer credit,
            @RequestParam(name = "courseInstructorId", required = false,defaultValue = "0") @Valid Long instructorId) {

        Course course = courseService.findCourseById(id);
        Instructor instructor = instructorId >0 ? instructorService.findInstructorById(instructorId):null;
        if(instructor != null)
            course.setCourseInstructor(instructor);
        course.setName(name);
        course.setCode(code);
        course.setCreditScore(credit);
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/course")
    public void deleteCourse(@RequestParam("courseId")  long id){
        courseService.deleteCourse(id);
    }

}
