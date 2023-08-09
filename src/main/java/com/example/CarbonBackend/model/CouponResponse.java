package com.example.CarbonBackend.model;

import com.example.CarbonBackend.entity.Coupon;
import lombok.Data;

import java.util.List;

@Data
public class CouponResponse {

    List<Coupon> couponList;
}
