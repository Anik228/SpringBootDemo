package com.example.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "VARCHAR(36)", nullable = false, updatable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Hide from Swagger POST requests
    private String id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_percentage")
    private float percentage;

    @Column(name = "student_branch")
    private String branch;

    public Student() {
    }

    public Student(String name, float percentage, String branch) {
        this.name = name;
        this.percentage = percentage;
        this.branch = branch;
    }


    public String getId() {  // Match type with field
        return id;
    }
    public void setId(String id) { // Match type with field
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPercentage() {
        return percentage;
    }
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", percentage=" + percentage + ", branch=" + branch + "]";
    }
}
