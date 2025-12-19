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

import com.yash.university_management_system.dto.CourseSimpleDTO;
import com.yash.university_management_system.dto.ProfessorDTO;
import com.yash.university_management_system.entity.Course;
import com.yash.university_management_system.entity.Professor;
import com.yash.university_management_system.repository.CourseRepository;
import com.yash.university_management_system.repository.ProffessorRepository;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProffessorRepository professorRepository;

    // @Autowired
    // private CourseRepository courseRepository;

    // ✔ GET professor by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getProfessorById(@PathVariable Integer id) {
        Professor prof = professorRepository.findById(id).orElse(null);
        if (prof == null) return ResponseEntity.badRequest().body("Professor not found");

        ProfessorDTO dto = new ProfessorDTO(prof.getId(), prof.getName(), prof.getExpertise());
        return ResponseEntity.ok(dto);
    }

    // ✔ POST create professor
    @PostMapping
    public ResponseEntity<?> createProfessor(@RequestBody Professor prof) {
        Professor saved = professorRepository.save(prof);
        return ResponseEntity.ok(new ProfessorDTO(saved.getId(), saved.getName(), saved.getExpertise()));
    }

    // ✔ PUT update professor
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfessor(@PathVariable Integer id, @RequestBody Professor updated) {
        Professor prof = professorRepository.findById(id).orElse(null);
        if (prof == null) return ResponseEntity.badRequest().body("Professor not found");

        prof.setName(updated.getName());
        prof.setExpertise(updated.getExpertise());
        prof.setSalary(updated.getSalary());
        professorRepository.save(prof);

        return ResponseEntity.ok("Professor updated successfully");
    }

    // ✔ DELETE professor
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable Integer id) {
        if (!professorRepository.existsById(id)){
                return ResponseEntity.badRequest().body("Professor not found");
        } 
        professorRepository.deleteById(id);
        return ResponseEntity.ok("Professor deleted successfully");
    }

    // ✔ GET courses taught by professor
    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getCoursesByProfessor(@PathVariable Integer id) {
        Professor prof = professorRepository.findById(id).orElse(null);
        if (prof == null) return ResponseEntity.badRequest().body("Professor not found");

        List<CourseSimpleDTO> courses = new ArrayList<>();
        for (Course c : prof.getCourses()) {
            courses.add(new CourseSimpleDTO(c.getId(), c.getCourse_name()));
        }
        return ResponseEntity.ok(courses);
    }
}

