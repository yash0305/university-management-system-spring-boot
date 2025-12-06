package com.yash.university_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.university_management_system.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM student", nativeQuery = true)
    List<Student> getAllStudents();
}
