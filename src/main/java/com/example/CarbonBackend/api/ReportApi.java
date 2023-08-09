package com.example.CarbonBackend.api;

import com.example.CarbonBackend.business.ReportBusiness;
import com.example.CarbonBackend.model.ReportImg;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportApi {

    private final ReportBusiness reportBusiness;

    public ReportApi(ReportBusiness reportBusiness) {
        this.reportBusiness = reportBusiness;
    }

    @GetMapping("/getimg")
    public ResponseEntity<ReportImg> getImg() {
        ReportImg response = reportBusiness.getImg();
        return ResponseEntity.ok(response);
    }

}
