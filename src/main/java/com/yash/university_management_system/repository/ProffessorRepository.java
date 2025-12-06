package com.yash.university_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.university_management_system.entity.Professor;

public interface ProffessorRepository extends JpaRepository<Professor, Integer>{

    @Query(value = "SELECT * FROM professor", nativeQuery = true)
    List<Professor> getAllProfessors();

}
