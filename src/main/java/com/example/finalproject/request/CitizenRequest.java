package com.example.finalproject.request;

import com.example.finalproject.entity.Job;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitizenRequest {
    @NotBlank
    private String name;
    @NotNull
    private Boolean selected;
    @NotNull
    @Valid
    private JobRequest job;
}
