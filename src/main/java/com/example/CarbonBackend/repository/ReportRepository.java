package com.example.CarbonBackend.repository;

import com.example.CarbonBackend.entity.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReportRepository extends CrudRepository<Report, String> {



}
