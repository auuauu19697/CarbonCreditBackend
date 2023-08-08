package com.example.CarbonBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "report")
public class Report extends BaseEntity{

    @Column
    private String name;

    @Column
    private String image;

    @Column
    private String description;

    @Column
    private Date date;

    @Column
    private int status;

    @Column
    private String reporter;


}
