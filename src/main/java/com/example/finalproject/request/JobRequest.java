package com.example.finalproject.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {
    @NotBlank
    private String name;
    @NotNull
    private Integer salary;
    @NotNull
    private Integer weeklyHours;
}
