package com.example.enrollement_service.clients;

import com.example.enrollement_service.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "studentClient", url = "http://localhost:8091/students")
public interface StudentService {
    @GetMapping("/{id}")
    ResponseDto getStudentById(@PathVariable Long id);
}
