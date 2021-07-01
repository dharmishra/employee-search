package com.employee.search.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String designation;
    private double salary;
    private String address;
    private String bloodGroup;
}
