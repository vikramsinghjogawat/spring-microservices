package com.javaguides.employeeservice.service.Impl;

import com.javaguides.employeeservice.dto.DepartmentDto;
import com.javaguides.employeeservice.dto.EmpDeptDto;
import com.javaguides.employeeservice.exception.EmailAlreadyExistsException;
import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.entity.Employee;
import com.javaguides.employeeservice.repository.EmployeeRepository;
import com.javaguides.employeeservice.service.APIFeignClient;
import com.javaguides.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private APIFeignClient apiFeignClient;

    //private WebClient webClient;

    //private RestTemplate restTemplate;

    private ModelMapper modelMapper;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        List<Employee> employees = employeeRepository.findByEmail(employeeDto.getEmail());
        if(!employees.isEmpty()){
            throw new EmailAlreadyExistsException(employeeDto.getEmail());
        }
        Employee employeeToSave = modelMapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employeeToSave);

        EmployeeDto savedEmpDto = modelMapper.map(savedEmployee, EmployeeDto.class);

        return savedEmpDto;
    }

    @Override
    public EmpDeptDto getEmployeeById(Long id) {

        Employee employee=  employeeRepository.findById(id).get();
//        CODE FOR RESTTEMPLATE
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();


//        CODE FOR WEBCLIENT
//        DepartmentDto departmentDto= webClient.get()
//                                                    .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
//                                                    .retrieve()
//                                                    .bodyToMono(DepartmentDto.class)
//                                                    .block();
        DepartmentDto departmentDto = apiFeignClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);

        EmpDeptDto empDeptDto = new EmpDeptDto(employeeDto,departmentDto);

        return empDeptDto;
    }
}
