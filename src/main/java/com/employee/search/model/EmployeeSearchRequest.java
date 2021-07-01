package com.employee.search.model;

import lombok.Data;
import lombok.ToString;

import java.util.Optional;

@Data
@ToString
public class EmployeeSearchRequest {
    private Optional<String> firstName;
    private Optional<String> lastName;
    private Optional<AgeCriteria> age;
    private Optional<SalaryCriteria> salary;
    private Optional<String> address;
    private Optional<String> bloodGroup;
}
