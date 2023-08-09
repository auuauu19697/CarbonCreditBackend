package com.example.CarbonBackend.service;

import com.example.CarbonBackend.entity.Coupon;
import com.example.CarbonBackend.model.CouponRequest;
import com.example.CarbonBackend.model.CouponResponse;
import com.example.CarbonBackend.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CouponService {

    private final CouponRepository repository;

    public CouponService(CouponRepository couponRepository, CouponRepository repository) {
        this.repository = repository;
    }

    public void create(CouponRequest request) {
        Coupon coupon = new Coupon();
        coupon.setName(request.getName());
        coupon.setDescription(request.getDescription());
        coupon.setPrice(request.getPrice());
        coupon.setAvailable(request.getAvailable());
        repository.save(coupon);
    }

    public List<Coupon> getAllCoupon() {
        List<Coupon> allCoupons = new ArrayList<Coupon>();
        int i = 1;
        while(true) {
            Optional<Coupon> opt = repository.findById(Integer.toString(i));
            if (opt.isEmpty()){
                break;
            }
            Coupon coupon = opt.get();
            allCoupons.add(coupon);
            i++;
        }
        return allCoupons;
    }

}
