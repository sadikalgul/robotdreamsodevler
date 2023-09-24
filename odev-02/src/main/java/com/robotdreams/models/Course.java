package com.robotdreams.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String code;
    private int creditScore;

    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList = new ArrayList<>();

    @ManyToOne
    private Instructor courseInstructor;


    public Course(String name, String code, int creditScore) {
        this.name = name;
        this.code = code;
        this.creditScore = creditScore;
    }

}
