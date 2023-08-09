package com.example.CarbonBackend.api;

import com.example.CarbonBackend.business.CouponBusiness;
import com.example.CarbonBackend.model.CouponRequest;
import com.example.CarbonBackend.model.CouponResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponApi {

    private final CouponBusiness couponBusiness;

    public CouponApi(CouponBusiness couponBusiness) {
        this.couponBusiness = couponBusiness;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCoupon(@RequestBody CouponRequest request) {
        couponBusiness.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getallcoupon")
    public ResponseEntity<CouponResponse> getAllCoupon() {
        CouponResponse response = couponBusiness.getAllCoupon();

        return ResponseEntity.ok(response);
    }

}
