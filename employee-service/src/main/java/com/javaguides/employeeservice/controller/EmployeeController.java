package com.javaguides.employeeservice.controller;

import com.javaguides.employeeservice.dto.EmpDeptDto;
import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmpDeptDto> getEmployee(@PathVariable("id") Long employeeId){
        EmpDeptDto empDeptDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(empDeptDto,HttpStatus.OK);
    }
}
