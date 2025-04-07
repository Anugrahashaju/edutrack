package com.example.enrollement_service.repository;

import com.example.enrollement_service.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollementRepository extends JpaRepository<Enrollment,Long> {

}
