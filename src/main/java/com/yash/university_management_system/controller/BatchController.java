package com.yash.university_management_system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.university_management_system.dto.BatchDTO;
import com.yash.university_management_system.dto.StudentSimpleDTO;
import com.yash.university_management_system.entity.Batch;
import com.yash.university_management_system.entity.Student;
import com.yash.university_management_system.repository.BatchRepository;
import com.yash.university_management_system.repository.StudentRepository;

@RestController
@RequestMapping("/batches")
public class BatchController {

     @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private StudentRepository studentRepository;

      // ✔ GET batch by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getBatchById(@PathVariable Integer id) {
        Batch batch = batchRepository.findById(id).orElse(null);
        if (batch == null) return ResponseEntity.badRequest().body("Batch not found");

        BatchDTO dto = new BatchDTO(
        batch.getId(),
        batch.getBatch_name(),
        batch.getBatch_timing()  // pass Date directly
    );
        return ResponseEntity.ok(dto);
    }

    // ✔ GET students in a batch
    @GetMapping("/{id}/students")
    public ResponseEntity<?> getStudentsInBatch(@PathVariable Integer id) {
        Batch batch = batchRepository.findById(id).orElse(null);
        if (batch == null) return ResponseEntity.badRequest().body("Batch not found");

        List<StudentSimpleDTO> students = new ArrayList<>();
        for (Student s : batch.getStudents()) {
            students.add(new StudentSimpleDTO(s.getId(), s.getStudent_name()));
        }
        return ResponseEntity.ok(students);
    }

    // ✔ POST add student to batch
    @PostMapping("/{id}/add-student/{studentId}")
    public ResponseEntity<?> addStudentToBatch(@PathVariable Integer id, @PathVariable Integer studentId) {
        Batch batch = batchRepository.findById(id).orElse(null);
        Student student = studentRepository.findById(studentId).orElse(null);

        if (batch == null || student == null)
            return ResponseEntity.badRequest().body("Batch or Student not found");

        if (!batch.getStudents().contains(student)) {
            batch.getStudents().add(student);
            batchRepository.save(batch);
        } else {
            return ResponseEntity.badRequest().body("Student already in this batch");
        }

        return ResponseEntity.ok("Student added to batch successfully");
    }
}




