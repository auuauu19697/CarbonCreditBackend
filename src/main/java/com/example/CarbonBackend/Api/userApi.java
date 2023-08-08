package com.example.CarbonBackend.Api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userApi {

    @GetMapping("/test")
    public ResponseEntity<Object> test() {
        System.out.println("hello world");
        return ResponseEntity.ok().build();
    }
}
