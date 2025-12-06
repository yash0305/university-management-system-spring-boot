package com.yash.university_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.university_management_system.entity.Batch;
import com.yash.university_management_system.entity.Course;
import com.yash.university_management_system.entity.Staff;
import com.yash.university_management_system.entity.Professor;
import com.yash.university_management_system.entity.Student;

import com.yash.university_management_system.service.UniversityService;

@RestController
@RequestMapping("/admin")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/professors")
    public List<Professor> getAllProfessors() {
        return universityService.getAllProfessors();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return universityService.getAllStudents();
    }

    @GetMapping("/staff")
    public List<Staff> getAllStaff() {
        return universityService.getAllStaff();
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return universityService.getAllCourses();
    }

    @GetMapping("/batches")
    public List<Batch> getAllBatches() {
        return universityService.getAllBatches();
    }
}
