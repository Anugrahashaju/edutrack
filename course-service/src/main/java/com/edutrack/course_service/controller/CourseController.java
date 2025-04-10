package com.edutrack.course_service.controller;

import com.edutrack.course_service.dto.RequestDto;
import com.edutrack.course_service.dto.ResponseDto;
import com.edutrack.course_service.model.Course;
import com.edutrack.course_service.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseRepository) {
        this.courseService = courseRepository;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createCourse(@Valid @RequestBody RequestDto dto) {
        var course = Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .trainerName(dto.getTrainerName())
                .build();
        course = courseService.save(course);
        dto.setId(course.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ResponseDto.builder()
                    .status(HttpStatus.CREATED)
                    .payload(dto).build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        var courses = courseService.findAll();
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses);
    }
}
