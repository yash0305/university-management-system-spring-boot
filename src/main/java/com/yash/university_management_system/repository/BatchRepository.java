package com.yash.university_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yash.university_management_system.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer> {

    @Query(value = "SELECT * FROM batch", nativeQuery = true)
    List<Batch> getAllBatches();

}
