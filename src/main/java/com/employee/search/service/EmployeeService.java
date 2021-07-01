package com.employee.search.service;

import com.employee.search.model.AgeCriteria;
import com.employee.search.model.Criteria;
import com.employee.search.model.Employee;
import com.employee.search.model.EmployeeSearchRequest;
import com.employee.search.repository.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    private final static Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository repository;

    @Cacheable(cacheNames = "employees")
    public List<Employee> search(EmployeeSearchRequest employeeSearchRequest) throws  IllegalArgumentException {
        LOG.info("Find employee for search Criteria " + employeeSearchRequest);
        List<Employee> employees = repository.getEmployees();
        Stream<Employee> employeeStream = employees.stream();

        if (employeeSearchRequest.getFirstName().isPresent() && !StringUtils.isEmpty(employeeSearchRequest.getFirstName().get())) {
            employeeStream = employeeStream.filter( e -> e.getFirstName().equalsIgnoreCase(employeeSearchRequest.getFirstName().get()));
        }
        if (employeeSearchRequest.getLastName().isPresent() && !StringUtils.isEmpty(employeeSearchRequest.getLastName().get())) {
            employeeStream = employeeStream.filter( e -> e.getLastName().equalsIgnoreCase(employeeSearchRequest.getLastName().get()));
        }
        if (employeeSearchRequest.getAddress().isPresent() && !StringUtils.isEmpty(employeeSearchRequest.getAddress().get())) {
            employeeStream = employeeStream.filter( e -> e.getAddress().toLowerCase(Locale.ROOT).contains(employeeSearchRequest.getAddress().get().toLowerCase(Locale.ROOT)));
        }
        if (employeeSearchRequest.getAge().isPresent()) {
            AgeCriteria ageCriteria = employeeSearchRequest.getAge().get();
            LocalDate currentDate = LocalDate.now();
            LocalDate dateOfBirth = currentDate
                    .minusYears(ageCriteria.getYear())
                    .minusMonths(ageCriteria.getMonth())
                    .minusDays(ageCriteria.getDays());
            if (ageCriteria.getCriteria() == Criteria.LESS) {
                employeeStream = employeeStream.filter(e -> e.getDateOfBirth().isAfter(dateOfBirth));
            } else if (ageCriteria.getCriteria() == Criteria.GREATER){
                employeeStream = employeeStream.filter(e -> e.getDateOfBirth().isBefore(dateOfBirth));
            } else {
                LOG.warn("Incorrect age criteria provided");
                throw  new IllegalArgumentException("Incorrect age criteria provided correct value " + Criteria.values());
            }
        }
        if (employeeSearchRequest.getSalary().isPresent()) {
            if (employeeSearchRequest.getSalary().get().getCriteria() == Criteria.LESS) {
                employeeStream = employeeStream.filter(e -> e.getSalary() < employeeSearchRequest.getSalary().get().getSalary());
            } else if (employeeSearchRequest.getSalary().get().getCriteria() == Criteria.GREATER){
                employeeStream = employeeStream.filter(e -> e.getSalary() > employeeSearchRequest.getSalary().get().getSalary());
            } else {
                LOG.warn("Incorrect age criteria provided");
                throw  new IllegalArgumentException("Incorrect salary criteria provided correct value " + Criteria.values());
            }
        }
        return employeeStream.collect(Collectors.toList());
    }
}
