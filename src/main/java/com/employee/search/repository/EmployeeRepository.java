package com.employee.search.repository;

import com.employee.search.model.Employee;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();
    @PostConstruct
    public void load() {
        Employee employee1 = Employee.builder()
                .id(1)
                .firstName("Raj")
                .lastName("Khurana")
                .dateOfBirth(LocalDate.of(1980, 01, 01))
                .designation("Software Developer")
                .salary(100000)
                .address("Mumbai")
                .bloodGroup("B Positive")
                .build();
        employees.add(employee1);

        Employee employee2 = Employee.builder()
                .id(2)
                .firstName("Ajay")
                .lastName("Kumar")
                .dateOfBirth(LocalDate.of(1985, 05, 05))
                .designation("Software Developer")
                .salary(50000)
                .address("Bangalore")
                .bloodGroup("O Positive")
                .build();
        employees.add(employee2);

        Employee employee3 = Employee.builder()
                .id(3)
                .firstName("Pooja")
                .lastName("Mishra")
                .dateOfBirth(LocalDate.of(1989, 05, 01))
                .designation("Software Tester")
                .salary(15000)
                .address("Mumbai")
                .bloodGroup("B Positive")
                .build();
        employees.add(employee3);

        Employee employee4 = Employee.builder()
                .id(4)
                .firstName("Ritu")
                .lastName("Khanna")
                .dateOfBirth(LocalDate.of(1985, 01, 01))
                .designation("Receptionist")
                .salary(10000)
                .address("Bangalore")
                .bloodGroup("A Positive")
                .build();
        employees.add(employee4);

        Employee employee5 = Employee.builder()
                .id(5)
                .firstName("Raj")
                .lastName("Malhotra")
                .dateOfBirth(LocalDate.of(1990, 01, 01))
                .designation("Software Developer")
                .salary(90000)
                .address("Mumbai")
                .bloodGroup("AB Positive")
                .build();
        employees.add(employee5);

        Employee employee6 = Employee.builder()
                .id(6)
                .firstName("Pooja")
                .lastName("Malhotra")
                .dateOfBirth(LocalDate.of(1986, 11, 01))
                .designation("Software Tester")
                .salary(185000)
                .address("Mumbai")
                .bloodGroup("B Positive")
                .build();
        employees.add(employee6);

        Employee employee7 = Employee.builder()
                .id(7)
                .firstName("Rahul")
                .lastName("Khanna")
                .dateOfBirth(LocalDate.of(1970, 12, 21))
                .designation("Manager")
                .salary(1000000)
                .address("Mumbai")
                .bloodGroup("B Positive")
                .build();
        employees.add(employee7);

        Employee employee8 = Employee.builder()
                .id(8)
                .firstName("Ratan")
                .lastName("Tata")
                .dateOfBirth(LocalDate.of(1960, 01, 01))
                .designation("CEO")
                .salary(10000000)
                .address("Mumbai")
                .bloodGroup("0 Positive")
                .build();
        employees.add(employee8);

        Employee employee9 = Employee.builder()
                .id(9)
                .firstName("Mittal")
                .lastName("shah")
                .dateOfBirth(LocalDate.of(1988, 05, 01))
                .designation("Lead")
                .salary(5000)
                .address("Bangalore")
                .bloodGroup("B Positive")
                .build();
        employees.add(employee9);

        Employee employee10 = Employee.builder()
                .id(10)
                .firstName("Rani")
                .lastName("Mukharji")
                .dateOfBirth(LocalDate.of(1980, 06, 21))
                .designation("Software Tester")
                .salary(520000)
                .address("Mumbai")
                .bloodGroup("B Positive")
                .build();
        employees.add(employee10);
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }
}
