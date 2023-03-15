package com.javaguides.departmentservice.controller;

import com.javaguides.departmentservice.dto.DepartmentDto;
import com.javaguides.departmentservice.exception.ErrorDetails;
import com.javaguides.departmentservice.exception.ResouceNotFoundException;
import com.javaguides.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String code){
        DepartmentDto dto =  departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
