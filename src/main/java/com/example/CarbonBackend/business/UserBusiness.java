package com.example.CarbonBackend.business;

import com.example.CarbonBackend.exception.BaseException;
import com.example.CarbonBackend.model.DonateRequest;
import com.example.CarbonBackend.model.UserData;
import com.example.CarbonBackend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    private final UserService userService;

    public UserBusiness(UserService userService) {
        this.userService = userService;
    }

    public void create(UserData request) throws BaseException {
        userService.create(request);
    }

    public UserData getUserData(String email) throws BaseException {
        UserData response = userService.getUserData(email);
        return response;
    }

    public void donate(DonateRequest request) throws BaseException {
        userService.donate(request);
    }
}
