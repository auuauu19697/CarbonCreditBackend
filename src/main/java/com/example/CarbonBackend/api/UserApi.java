package com.example.CarbonBackend.api;

import com.example.CarbonBackend.business.UserBusiness;
import com.example.CarbonBackend.exception.BaseException;
import com.example.CarbonBackend.model.DonateRequest;
import com.example.CarbonBackend.model.UserData;
import com.example.CarbonBackend.model.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserApi {

    private final UserBusiness userBusiness;

    public UserApi(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody UserData request) throws BaseException {
        userBusiness.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<UserData> getUserData(@RequestBody UserRequest request) throws BaseException {
        UserData response = userBusiness.getUserData(request.getEmail());
        return ResponseEntity.ok(response);
    }

    @PostMapping("donate")
    public ResponseEntity<Object> donate(@RequestBody DonateRequest request) throws BaseException {
        userBusiness.donate(request);
        return ResponseEntity.ok().build();
    }
}
