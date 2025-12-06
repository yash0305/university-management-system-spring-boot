package com.yash.university_management_system.dto;


public class CourseRequestDTO {

    private String course_name;
    private Double course_fee;
    private String duration;
    private Integer credits;
    public CourseRequestDTO(String course_name, Double course_fee, String duration, Integer credits) {
        this.course_name = course_name;
        this.course_fee = course_fee;
        this.duration = duration;
        this.credits = credits;
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
