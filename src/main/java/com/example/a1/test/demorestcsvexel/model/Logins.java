package com.example.a1.test.demorestcsvexel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Logins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "Application")
    String Application;
    @Column(name = "AppAccountName")
    String AppAccountName;
    @Column(name = "IsActive")
    boolean IsActive;
    @Column(name = "JobTitle")
    String JobTitle;
    @Column(name = "Department")
    String Department;

    public Logins(String application, String appAccountName, boolean isActive, String jobTitle, String department) {
        Application = application;
        AppAccountName = appAccountName;
        IsActive = isActive;
        JobTitle = jobTitle;
        Department = department;
    }
}
