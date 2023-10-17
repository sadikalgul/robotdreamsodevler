package com.robotdreams.schoolmanage.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PermanentInstructor extends Instructor{

    public PermanentInstructor(String name, String phoneNumber, SalaryType salaryType) {
        super(name, phoneNumber, salaryType);
    }
}
