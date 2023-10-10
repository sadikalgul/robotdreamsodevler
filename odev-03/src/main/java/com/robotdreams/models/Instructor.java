package com.robotdreams.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
public abstract class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phoneNumber;

    @OneToOne /*(mappedBy = "salaryInstructor")*/
    private SalaryType salaryType;

    @JsonBackReference
    @OneToMany(mappedBy = "courseInstructor")
    private Set<Course> courseList = new HashSet<>(); // converted List to Set

    public Instructor(String name, String phoneNumber, SalaryType salaryType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salaryType = salaryType;
    }
}
