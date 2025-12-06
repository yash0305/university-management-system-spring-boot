package com.yash.university_management_system.dto;

public class StudentSimpleDTO {
    private Integer id;
    private String studentName;

    public StudentSimpleDTO(Integer id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    // getters and setters
    
}
