package com.robotdreams.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SalaryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String salaryCode;

    /*
    @OneToOne
    private Instructor salaryInstructor;
     */

    public SalaryType(String salaryCode) {
        this.salaryCode = salaryCode;
    }
}
