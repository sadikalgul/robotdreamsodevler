package com.robotdreams.schoolmanage.models.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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