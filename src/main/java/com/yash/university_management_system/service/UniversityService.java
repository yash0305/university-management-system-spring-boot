package com.yash.university_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.university_management_system.entity.Batch;
import com.yash.university_management_system.entity.Course;
import com.yash.university_management_system.entity.Staff;
import com.yash.university_management_system.entity.Student;
import com.yash.university_management_system.entity.Professor;

import com.yash.university_management_system.repository.BatchRepository;
import com.yash.university_management_system.repository.CourseRepository;
import com.yash.university_management_system.repository.ProffessorRepository;
import com.yash.university_management_system.repository.StaffRepositiory;
import com.yash.university_management_system.repository.StudentRepository;


@Service
public class UniversityService {

    private final ProffessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final StaffRepositiory staffRepository;
    private final CourseRepository courseRepository;
    private final BatchRepository batchRepository;

    public UniversityService(ProffessorRepository professorRepository,
                             StudentRepository studentRepository,
                             StaffRepositiory staffRepository,
                             CourseRepository courseRepository,
                             BatchRepository batchRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
        this.staffRepository = staffRepository;
        this.courseRepository = courseRepository;
        this.batchRepository = batchRepository;
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.getAllProfessors();
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public List<Batch> getAllBatches() {
        return batchRepository.getAllBatches();
    }
}