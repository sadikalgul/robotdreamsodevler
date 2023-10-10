package com.robotdreams.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

    private long id;
    @NotNull(message = "userId is required")
    private long userId;
    @NotBlank(message = "title is required")
    private String title;
    @NotNull(message = "completed is required")
    private boolean completed;
}
