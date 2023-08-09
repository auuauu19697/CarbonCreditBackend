package com.example.CarbonBackend.repository;

import com.example.CarbonBackend.entity.Coupon;
import com.example.CarbonBackend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CouponRepository extends CrudRepository<Coupon, String> {

    Optional<Coupon> findByName(String name);

}
