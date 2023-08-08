package com.example.CarbonBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "coupon")
public class Coupon extends BaseEntity{

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int price;

    @Column
    private int available;


}
