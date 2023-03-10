package com.example.finalproject.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryRequest {
    @NotBlank
    private String name;
    @NotNull
    private Boolean selected;
    @NotNull
    private Integer population;
}
