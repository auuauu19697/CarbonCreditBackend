package com.example.CarbonBackend.service;

import com.example.CarbonBackend.entity.Coupon;
import com.example.CarbonBackend.entity.Report;
import com.example.CarbonBackend.entity.User;
import com.example.CarbonBackend.exception.BaseException;
import com.example.CarbonBackend.exception.CouponException;
import com.example.CarbonBackend.exception.UserException;
import com.example.CarbonBackend.model.BuyCouponReq;
import com.example.CarbonBackend.model.DonateRequest;
import com.example.CarbonBackend.model.ReportReq;
import com.example.CarbonBackend.model.UserData;
import com.example.CarbonBackend.repository.CouponRepository;
import com.example.CarbonBackend.repository.ReportRepository;
import com.example.CarbonBackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    private final CouponRepository couponRepository;

    private final ReportRepository reportRepository;

    public UserService(UserRepository repository, CouponRepository couponRepository, ReportRepository reportRepository) {
        this.repository = repository;
        this.couponRepository = couponRepository;
        this.reportRepository = reportRepository;
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User create(UserData request) throws BaseException {

        if(repository.existsByEmail(request.getEmail())){
            throw UserException.emailAlreadyExist();
        }

        User newUser = new User();
        newUser.setUser_type(request.getUser_type());
        newUser.setName(request.getName());
        newUser.setSurname(request.getSurname());
        newUser.setEmail(request.getEmail());
        newUser.setTel(request.getTel());
        newUser.setPoint(0);
        newUser.setHighscore(0);

        return repository.save(newUser);
    }

    public UserData getUserData(String email) throws BaseException {
        Optional<User> opt = findByEmail(email);

        if(opt.isEmpty()){
            throw UserException.emailNotFound();
        }
        User user = opt.get();
        UserData userData = new UserData();
        userData.setUser_type(user.getUser_type());
        userData.setName(user.getName());
        userData.setSurname(user.getSurname());
        userData.setTel(user.getTel());
        userData.setEmail(user.getEmail());
        return userData;
    }

    public void donate(DonateRequest request) throws BaseException {
        System.out.println(request.getEmail());
        Optional<User> donator_opt = findByEmail(request.getEmail());
        Optional<User> reciever_opt = findByEmail(request.getReceiver_email());

        if(donator_opt.isEmpty()){
            System.out.println("here1");
            throw UserException.emailNotFound();
        }
        if(reciever_opt.isEmpty()){
            System.out.println("here2");
            throw UserException.emailNotFound();
        }

        User donator = donator_opt.get();
        User receiver = reciever_opt.get();

        if(donator.getPoint() < request.getAmount()) {
            throw UserException.notEnoughPoint();
        }

        //update donator and receiver point
        donator.setPoint(donator.getPoint() - request.getAmount());
        receiver.setPoint(receiver.getPoint() + request.getAmount());

        repository.save(donator);
        repository.save(receiver);
    }

    public void buyCoupon(BuyCouponReq request) throws BaseException {

        Optional<User> buyer_opt = findByEmail(request.getEmail());
        if(buyer_opt.isEmpty()) throw UserException.emailNotFound();
        User buyer = buyer_opt.get();

        Optional<Coupon> coupon_opt = couponRepository.findByName(request.getCoupon_name());
        Coupon coupon = coupon_opt.get();

        int amount = request.getAmount();
        if(coupon.getAvailable() == 0){
            throw CouponException.outOfStocks();
        }
        if(coupon.getAvailable() < amount) {
            throw CouponException.notEnough();
        }

        int price = coupon.getPrice()*amount;
        if(buyer.getPoint() < price){
            throw UserException.notEnoughPoint();
        }

        List<Integer> allcoupons = buyer.getCoupon_id();
        if(allcoupons == null) allcoupons = new ArrayList<Integer>();
        for(int i=0;i < amount; i++){
            allcoupons.add(coupon.getId());
        }
        coupon.setAvailable(coupon.getAvailable() - amount);
        buyer.setPoint(buyer.getPoint() - price);
        buyer.setCoupon_id(allcoupons);
        repository.save(buyer);
        couponRepository.save(coupon);
    }

    public void report(ReportReq request) throws BaseException {

        Optional<User> opt = findByEmail(request.getReporter());
        if(opt.isEmpty()) {
            throw UserException.emailNotFound();
        }

        Report report = new Report();
        report.setName(request.getName());
        report.setDescription(request.getDescription());
        report.setImage(request.getImage());
        report.setDate(request.getDate());
        report.setStatus(2);
        report.setReporter(request.getReporter());

        System.out.println(request.getName());
        System.out.println(request.getDescription());
        System.out.println(request.getDate());
        System.out.println(request.getReporter());
        reportRepository.save(report);
    }
}
