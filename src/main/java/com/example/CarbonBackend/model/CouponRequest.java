package com.example.CarbonBackend.model;

import lombok.Data;

@Data
public class CouponRequest {

    private String name;

    private String description;

    private int price;

    private int available;

}
