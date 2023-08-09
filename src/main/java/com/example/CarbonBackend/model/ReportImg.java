package com.example.CarbonBackend.model;

import jakarta.persistence.Lob;
import lombok.Data;

import java.util.Date;

@Data
public class ReportImg {

    @Lob
    private byte[] image;

}
