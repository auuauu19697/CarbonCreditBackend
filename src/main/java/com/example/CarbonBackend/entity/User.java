package com.example.CarbonBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "m_user")
public class User extends BaseEntity{

    @Column
    private int user_type;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column(length = 10)
    private String tel;

    @Column
    private int point;

    @Column
    private int highscore;


}
