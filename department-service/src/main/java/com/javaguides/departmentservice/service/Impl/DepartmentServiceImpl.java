package com.javaguides.departmentservice.service.Impl;

import com.javaguides.departmentservice.dto.DepartmentDto;
import com.javaguides.departmentservice.entity.Department;
import com.javaguides.departmentservice.exception.ResouceNotFoundException;
import com.javaguides.departmentservice.repository.DepartmentRepository;
import com.javaguides.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto,Department.class);

        Department savedDept = departmentRepository.save(department);

        DepartmentDto savedDeptDto = modelMapper.map(department, DepartmentDto.class);
        return savedDeptDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        if(department==null){
            throw new ResouceNotFoundException("Department","department code",code);
        }
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
                return departmentDto;
    }
}
