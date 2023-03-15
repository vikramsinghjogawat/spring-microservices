package com.javaguides.employeeservice.service;

import com.javaguides.employeeservice.dto.EmpDeptDto;
import com.javaguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmpDeptDto getEmployeeById(Long id);
}
