package com.employee.search.model;

import lombok.Data;

@Data
public class AgeCriteria {
    private Criteria criteria;
    private int year;
    private int month;
    private int days;
}
