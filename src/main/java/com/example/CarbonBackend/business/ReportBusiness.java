package com.example.CarbonBackend.business;

import com.example.CarbonBackend.model.ReportImg;
import com.example.CarbonBackend.service.ReportService;
import org.springframework.stereotype.Service;

@Service
public class ReportBusiness {

    private final ReportService reportService;

    public ReportBusiness(ReportService reportService) {
        this.reportService = reportService;
    }

    public ReportImg getImg() {
        ReportImg reportImg = new ReportImg();
        reportImg.setImage(reportService.getImg());
        return reportImg;
    }

}
