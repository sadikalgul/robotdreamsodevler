package com.robotdreams.models.dto;


import com.robotdreams.models.Course;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private long id;
    private String name;
    private String address;
    private String gender;
    @NotBlank(message = "birtDate is required")
    private String birtDate;
    private List<CourseDTO> courseList = new ArrayList<>();
}