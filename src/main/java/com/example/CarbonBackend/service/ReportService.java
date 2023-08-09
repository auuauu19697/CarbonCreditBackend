package com.example.CarbonBackend.service;

import com.example.CarbonBackend.entity.Report;
import com.example.CarbonBackend.model.ReportImg;
import com.example.CarbonBackend.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportService {

    private final ReportRepository repository;

    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }


    public byte[] getImg() {
        Optional<Report> opt = repository.findById("1");
        Report report = opt.get();

        return report.getImage();
    }

}
