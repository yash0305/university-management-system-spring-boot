package com.yash.university_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yash.university_management_system.entity.Student;
import com.yash.university_management_system.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}