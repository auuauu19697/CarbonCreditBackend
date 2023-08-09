package com.example.CarbonBackend.exception;

public class CouponException extends BaseException{
    public CouponException(String code) {
        super("coupon." + code);
    }

    public static CouponException notEnough(){
        return new CouponException("not.enough");
    }

    public static CouponException outOfStocks(){
        return new CouponException("out.of.stock");
    }

}
