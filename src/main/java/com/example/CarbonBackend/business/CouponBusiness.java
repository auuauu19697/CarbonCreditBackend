package com.example.CarbonBackend.business;

import com.example.CarbonBackend.model.CouponRequest;
import com.example.CarbonBackend.model.CouponResponse;
import com.example.CarbonBackend.service.CouponService;
import org.springframework.stereotype.Service;

@Service
public class CouponBusiness {

    private final CouponService couponService;

    public CouponBusiness(CouponService couponService) {
        this.couponService = couponService;
    }

    public void create(CouponRequest request) {
        couponService.create(request);
    }

    public CouponResponse getAllCoupon(){
        CouponResponse response = new CouponResponse();
        response.setCouponList(couponService.getAllCoupon());

        return response;
    }

}
