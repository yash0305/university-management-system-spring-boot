package com.yash.university_management_system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.university_management_system.dto.BatchDTO;
import com.yash.university_management_system.dto.CourseRequestDTO;
import com.yash.university_management_system.dto.CourseResponseDTO;
import com.yash.university_management_system.dto.ProfessorResponseDTO;
import com.yash.university_management_system.entity.Batch;
import com.yash.university_management_system.entity.Course;
import com.yash.university_management_system.entity.Professor;
import com.yash.university_management_system.repository.BatchRepository;
import com.yash.university_management_system.repository.CourseRepository;
import com.yash.university_management_system.repository.ProffessorRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProffessorRepository proffessorRepository;

    @Autowired
    private BatchRepository batchRepository;

   @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id) {
        Course course = courseRepository.findById(id).orElse(null);

        if (course == null)
            return ResponseEntity.badRequest().body("Course not found");

        return ResponseEntity.ok(new CourseResponseDTO(course));
    }

    // ✔ CREATE Course (DTO)
    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody CourseRequestDTO dto) {

        Course course = new Course();
        course.setCourse_name(dto.getCourse_name());
        course.setCourse_fee(dto.getCourse_fee());
        course.setDuration(dto.getDuration());
        course.setCredits(dto.getCredits());

        courseRepository.save(course);

        return ResponseEntity.ok("course created successfully");
    }

    // ✔ UPDATE Course (DTO)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody CourseRequestDTO dto) {

        Course course = courseRepository.findById(id).orElse(null);

        if (course == null)
            return ResponseEntity.badRequest().body("Course not found");

        course.setCourse_name(dto.getCourse_name());
        course.setCourse_fee(dto.getCourse_fee());
        course.setDuration(dto.getDuration());
        course.setCredits(dto.getCredits());

        courseRepository.save(course);

        return ResponseEntity.ok("course updated successfully");
        
    }

    // ✔ DELETE Course
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {

        if (!courseRepository.existsById(id))
            return ResponseEntity.badRequest().body("Course not found");

        courseRepository.deleteById(id);
        return ResponseEntity.ok("Course deleted successfully");
    }



    // ✔ GET Professors teaching this course (DTO)
    @GetMapping("/{id}/professors")
    public ResponseEntity<?> getProfessorsByCourse(@PathVariable Integer id) {

        Course course = courseRepository.findById(id).orElse(null);

        if (course == null)
            return ResponseEntity.badRequest().body("Course not found");

        List<ProfessorResponseDTO> response = course.getProfessors()
                .stream()
                .map(p -> new ProfessorResponseDTO(
                        p.getId(),
                        p.getName(),
                        p.getExpertise()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }

    // ✔ ASSIGN PROFESSOR (no DTO needed)
    @PostMapping("/{id}/assign-professor/{profId}")
    public ResponseEntity<?> assignProfessorToCourse(
            @PathVariable Integer id,
            @PathVariable Integer profId) {

        Course course = courseRepository.findById(id).orElse(null);
        Professor professor = proffessorRepository.findById(profId).orElse(null);

        if (course == null || professor == null)
            return ResponseEntity.badRequest().body("Course or Professor not found");

        if (course.getProfessors().contains(professor))
            return ResponseEntity.badRequest().body("Professor already assigned");

        course.getProfessors().add(professor);
        courseRepository.save(course);

        return ResponseEntity.ok("Professor assigned successfully");
    }

    // ✔ CREATE NEW BATCH under a COURSE (DTO out)
    @PostMapping("/{id}/create-batch")
    public ResponseEntity<?> createBatchForCourse(@PathVariable Integer id, @RequestBody Batch batchRequest) {

        Course course = courseRepository.findById(id).orElse(null);

        if (course == null)
            return ResponseEntity.badRequest().body("Course not found");

        batchRequest.setCourse(course);

        Batch saved = batchRepository.save(batchRequest);

        return ResponseEntity.ok("new batch created succesfully");
        
    }

}
