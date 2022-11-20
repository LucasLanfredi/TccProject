package com.TCCProject.TCCPROJECT.Entities;

import com.TCCProject.TCCPROJECT.Models.EUserType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EUserType name;
}
