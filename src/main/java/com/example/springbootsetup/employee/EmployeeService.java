package com.example.springbootsetup.employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(Long id);

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Long employeeId, Employee employee);

    void deleteEmployee(Long employeeId);
}
