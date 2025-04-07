package com.example.enrollement_service.service;

import com.example.enrollement_service.clients.CourseService;
import com.example.enrollement_service.clients.StudentService;
import com.example.enrollement_service.dto.ResponseDto;
import com.example.enrollement_service.model.Enrollment;
import com.example.enrollement_service.repository.EnrollementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{
    private final EnrollementRepository repository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentServiceImpl(EnrollementRepository repository, StudentService studentService, CourseService courseService) {
        this.repository = repository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return repository.save(enrollment);
    }

    @Override
    public List<Enrollment> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Object findStudentDetails(Long id) {
        ResponseDto response = studentService.getStudentById(id);
        return response.getResponse();
    }

    @Override
    public Object findCourseDetails(Long id) {
        Object response = courseService.getCourseById(id);
        System.err.println(response);
        return response;
    }
}
