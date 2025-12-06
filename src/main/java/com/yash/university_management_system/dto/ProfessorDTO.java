package com.yash.university_management_system.dto;

public class ProfessorDTO {

    private Integer id;
    private String name;
    private String expertise;

    public ProfessorDTO(Integer id, String name, String expertise) {
        this.id = id;
        this.name = name;
        this.expertise = expertise;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    

}
