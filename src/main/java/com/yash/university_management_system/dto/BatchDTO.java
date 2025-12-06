package com.yash.university_management_system.dto;


import java.time.LocalDate;
import java.util.Date;

public class BatchDTO {
    private Integer id;
    private String batchName;
    private LocalDate batchTiming;

    public BatchDTO() {
    }

    public BatchDTO(Integer id, String batchName, LocalDate batchTiming) {
        this.id = id;
        this.batchName = batchName;
        this.batchTiming = batchTiming;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public LocalDate getBatchTiming() {
        return batchTiming;
    }

    public void setBatchTiming(LocalDate batchTiming) {
        this.batchTiming = batchTiming;
    }
}
