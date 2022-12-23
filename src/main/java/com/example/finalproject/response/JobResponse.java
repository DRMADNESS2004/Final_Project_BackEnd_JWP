package com.example.finalproject.response;

import com.example.finalproject.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {
    private String name;
    private int salary;
    private int weeklyHours;

    public JobResponse(Job job){
        name= job.getName();
        salary= job.getSalary();
        weeklyHours= job.getWeeklyHours();
    }
}
