package com.example.CarbonBackend.model;

import jakarta.persistence.Lob;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Date;

@Data
public class ReportReq {

    private String name;

    @Lob
    private byte[] image;

    private String description;

    private Date date;

    private String reporter;
}
