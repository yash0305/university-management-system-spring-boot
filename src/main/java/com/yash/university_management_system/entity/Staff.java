package com.yash.university_management_system.entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String role;
    private Date date_of_joining;
    private Double salary;
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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Date getDate_of_joining() {
        return date_of_joining;
    }
    public void setDate_of_joining(Date date_of_joining) {
        this.date_of_joining = date_of_joining;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }


    
}
