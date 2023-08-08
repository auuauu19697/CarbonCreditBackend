package com.example.CarbonBackend.model;

import lombok.Data;

@Data
public class DonateRequest {

    private String email;

    private String receiver_email;

    private int amount;
}
