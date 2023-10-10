package com.robotdreams.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Student {

    @Id
    @NotNull(message = "id is required")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "address is required")
    private String address;
    @NotBlank(message = "gender is required")
    private String gender;
    @NotBlank(message = "birtDate is required")
    private String birtDate;

    //@JsonIgnore  // ignore cıurselist form web request
    @JsonManagedReference
   // @ManyToMany(fetch = FetchType.EAGER)

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "student_course_list",
            joinColumns = { @JoinColumn(name = "student_list_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_list_id") })
    private Set<Course> courseList = new HashSet<>(); // converted List to Set


    public Student(String name, String address, String gender, String birtDate) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birtDate = birtDate;
    }
}
