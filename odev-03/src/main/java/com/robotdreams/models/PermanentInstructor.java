package com.robotdreams.models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PermanentInstructor extends Instructor{

    public PermanentInstructor(String name, String phoneNumber, SalaryType salaryType) {
        super(name, phoneNumber, salaryType);
    }
}
