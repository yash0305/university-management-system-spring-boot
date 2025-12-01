package com.yash.university_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.university_management_system.entity.Professor;

public interface ProffessorRepository extends JpaRepository<Professor, Integer>{

}
