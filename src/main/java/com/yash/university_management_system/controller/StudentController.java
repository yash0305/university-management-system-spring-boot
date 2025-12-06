package com.yash.university_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.university_management_system.entity.Batch;
import com.yash.university_management_system.entity.Course;
import com.yash.university_management_system.entity.Student;
import com.yash.university_management_system.repository.BatchRepository;
import com.yash.university_management_system.repository.CourseRepository;
import com.yash.university_management_system.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private BatchRepository batchRepository;

    // GET Student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) 
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(student);
    }

     // GET Courses enrolled by student
    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getStudentCourses(@PathVariable Integer id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.getCourses());
    }

     // GET Batches of student
    @GetMapping("/{id}/batches")
    public ResponseEntity<?> getStudentBatches(@PathVariable Integer id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.getBatches());
    }

    // Enroll student into a course
    @PostMapping("/{studentId}/enroll-course/{courseId}")
    public ResponseEntity<?> enrollCousrses(@PathVariable Integer studentId, @PathVariable Integer courseId){
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        
        if(student == null || course == null){
            return ResponseEntity.badRequest().body("student or course not found");
        }

        if (student.getCourses().contains(course)) {
        return ResponseEntity.badRequest().body("Student is already enrolled in this course");
        }

        student.getCourses().add(course);
        studentRepository.save(student);
        return ResponseEntity.ok("course added successfully");
    }

// Assign batch to student
@PostMapping("/{studentId}/join-batch/{batchId}")
public ResponseEntity<?> assignBatchToStudent(
        @PathVariable Integer studentId,
        @PathVariable Integer batchId) {

    Student student = studentRepository.findById(studentId).orElse(null);
    Batch batch = batchRepository.findById(batchId).orElse(null); // ✅ Correct

    if (student == null || batch == null) {
        return ResponseEntity.badRequest().body("Student or Batch not found");
    }

    // Check if the student is already in the batch
    if (student.getBatches().contains(batch)) {
        return ResponseEntity.badRequest().body("Student is already enrolled in this batch");
    }

    // Add batch to student's list
    student.getBatches().add(batch);

    // Add student to batch's student list (optional but recommended)
    batch.getStudents().add(student);

    // Save student (relationship will be persisted)
    studentRepository.save(student);

    return ResponseEntity.ok("Batch assigned successfully");
}


}
