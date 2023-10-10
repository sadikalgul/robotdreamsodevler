package com.robotdreams.models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VisitingInstructor extends Instructor{


    public VisitingInstructor(String name, String phoneNumber, SalaryType salaryType) {
        super(name, phoneNumber, salaryType);
    }
}
