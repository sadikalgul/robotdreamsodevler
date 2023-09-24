package com.robotdreams.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phoneNumber;

    @OneToOne /*(mappedBy = "salaryInstructor")*/
    private SalaryType salaryType;

    @OneToMany(mappedBy = "courseInstructor")
    private List<Course> courseList = new ArrayList<>();

    public Instructor(String name, String phoneNumber, SalaryType salaryType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salaryType = salaryType;
    }
}
