package com.employee.search.api;

import com.employee.search.model.Employee;
import com.employee.search.model.EmployeeSearchRequest;
import com.employee.search.service.EmployeeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirement(name = "employeeapi")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/employeesearch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> searchEmployee(@RequestBody EmployeeSearchRequest request) {
        List<Employee> employees = employeeService.search(request);
        return ResponseEntity.ok(employees);
    }
}
