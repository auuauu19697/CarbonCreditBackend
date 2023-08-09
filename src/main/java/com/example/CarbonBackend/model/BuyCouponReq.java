package com.example.CarbonBackend.model;

import lombok.Data;

@Data
public class BuyCouponReq {

    private String email;

    private String coupon_name;

    private int amount;

}
