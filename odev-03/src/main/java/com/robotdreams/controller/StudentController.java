package com.robotdreams.controller;


import com.robotdreams.models.Course;
import com.robotdreams.models.Student;
import com.robotdreams.service.CourseService;
import com.robotdreams.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    @Autowired
    public StudentController(@Qualifier("Student") StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);

    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();

    }

/*    @PostMapping(value = "/student",consumes = "application/json;charset=UTF-8")
    public Student saveStudent(@RequestBody Student student){
        System.out.println("name:"+student.getName());
        return studentService.saveStudent(student);
    }*/

    @PostMapping(value = "/student")
    public Student saveStudent(
            @RequestParam("studentName") @Valid String name,
            @RequestParam("StudentAddress") @Valid String address,
            @RequestParam("studentGender") @Valid String gender,
            @RequestParam("studentBirth") @Valid String birth,
            @RequestParam(name = "courseId", required = false,defaultValue = "0") @Valid Long courseId) {
        Student student = new Student(name, address, gender, birth);
        Course course = courseId >0 ? courseService.findCourseById(courseId):null;
        if(course != null)
            student.getCourseList().add(course);
        return studentService.saveStudent(student);
    }


 /*   @PutMapping("/student")
    public Student updateStudent(@RequestBody @Valid Student student){
        return studentService.saveStudent(student);
    }
*/
     @PutMapping("/student")
     public Student updateStudent(
             @RequestParam("studentId") @Valid Long id,
             @RequestParam("studentName") @Valid String name,
             @RequestParam("StudentAddress") @Valid String address,
             @RequestParam("studentGender") @Valid String gender,
             @RequestParam("studentBirth") @Valid String birth,
             @RequestParam(name = "newCourseId", required = false,defaultValue = "0") @Valid Long newCourseId,
             @RequestParam(name = "removeCourseId", required = false,defaultValue = "0") @Valid Long removeCourseId) {
         Student student = studentService.findStudentById(id);
         student.setName(name);
         student.setAddress(address);
         student.setGender(gender);
         student.setBirtDate(birth);

         Course removeCourse = removeCourseId >0 ? courseService.findCourseById(removeCourseId):null;
         if(removeCourse != null)
             student.getCourseList().remove(removeCourse);

         Course addCourse = newCourseId >0 ? courseService.findCourseById(newCourseId):null;
         if(addCourse != null)
             student.getCourseList().add(addCourse);
         return studentService.saveStudent(student);
     }



    @DeleteMapping("/student")
    public void deleteStudent(@RequestParam("studentId")  long id){
        studentService.deleteStudent(id);
    }

}
