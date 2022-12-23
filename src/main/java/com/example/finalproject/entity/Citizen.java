package com.example.finalproject.entity;

import com.example.finalproject.request.CitizenRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="citizens")
@Getter
@Setter
@NoArgsConstructor
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String name;

    @ManyToOne(optional=false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="country_id")
    private Country country;

    public Citizen(CitizenRequest citizenRequest){
        name= citizenRequest.getName();
    }
}
