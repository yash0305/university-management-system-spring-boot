package com.yash.university_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.university_management_system.entity.Staff;

public interface StaffRepositiory extends JpaRepository<Staff, Integer> {

    @Query(value = "SELECT * FROM staff", nativeQuery = true)
    List<Staff> getAllStaff();

}
