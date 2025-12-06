package com.yash.university_management_system.dto;

public class CourseSimpleDTO {

    private Integer id;
    private String courseName;

    public CourseSimpleDTO(Integer id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    

}
