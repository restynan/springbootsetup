package com.example.springbootsetup.employee.impl;

import com.example.springbootsetup.employee.Employee;
import com.example.springbootsetup.employee.EmployeeRepository;
import com.example.springbootsetup.employee.EmployeeService;
import com.example.springbootsetup.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployee(Long id) {

        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id",id));
        //return employeeRepository.findById(id).get();

    }


    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }


    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee employee1 = getEmployee(employeeId);
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employee1.setAge(employee.getAge());
        return employeeRepository.save(employee1);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee","id",employeeId));
        employeeRepository.deleteById(employeeId);
    }

}
