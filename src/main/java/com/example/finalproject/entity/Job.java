package com.example.finalproject.entity;

import com.example.finalproject.request.JobRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="jobs")
@Getter
@Setter
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private int salary;

    @Column(name="weekly_hours", nullable=false)
    private int weeklyHours;

    public Job(JobRequest jobRequest){
        name= jobRequest.getName();
        salary= jobRequest.getSalary();
        weeklyHours= jobRequest.getWeeklyHours();
    }
}
