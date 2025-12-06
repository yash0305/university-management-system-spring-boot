package com.yash.university_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.university_management_system.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT * FROM course", nativeQuery = true)
    List<Course> getAllCourses();

}
