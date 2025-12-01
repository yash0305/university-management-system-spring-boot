package com.yash.university_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.university_management_system.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    
}
