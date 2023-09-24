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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String address;
    private String gender;
    private String birtDate;

    @ManyToMany
    private List<Course> courseList = new ArrayList<>();


    public Student(String name, String address, String gender, String birtDate) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birtDate = birtDate;
    }
}
