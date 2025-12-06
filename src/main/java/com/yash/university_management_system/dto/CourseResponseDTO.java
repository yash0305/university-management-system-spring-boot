package com.yash.university_management_system.dto;

import com.yash.university_management_system.entity.Course;

public class CourseResponseDTO {
     private Integer id;
    private String course_name;
    private Double course_fee;
    private String duration;
    private Integer credits;

    // No professors field (hidden)

    public CourseResponseDTO(Course c) {
        this.id = c.getId();
        this.course_name = c.getCourse_name();
        this.course_fee = c.getCourse_fee();
        this.duration = c.getDuration();
        this.credits = c.getCredits();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Double getCourse_fee() {
        return course_fee;
    }

    public void setCourse_fee(Double course_fee) {
        this.course_fee = course_fee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    

}
