package com.robotdreams.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String code;
    private int creditScore;

    //@JsonBackReference
    //@ManyToMany(mappedBy = "courseList")
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "courseList")
    @JsonBackReference
    private Set<Student> studentList = new HashSet<>(); // converted List to Set

    @JsonManagedReference
    @ManyToOne
    private Instructor courseInstructor;


    public Course(String name, String code, int creditScore) {
        this.name = name;
        this.code = code;
        this.creditScore = creditScore;
    }

}
