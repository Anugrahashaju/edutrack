package com.example.enrollement_service.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "courseClient", url = "http://localhost:8081/courses")
public interface CourseService {

    @GetMapping("/{id}")
    Object getCourseById(@PathVariable Long id);
}
