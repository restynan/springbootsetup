package com.example.springbootsetup.employee;

import com.example.springbootsetup.employee.impl.EmployeeServiceImpl;
import com.example.springbootsetup.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private final EmployeeRepository employeeRepository;

    @InjectMocks
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeServiceTest(EmployeeRepository employeeRepository, EmployeeServiceImpl employeeServiceImpl) {
        this.employeeRepository = employeeRepository;
        this.employeeServiceImpl = employeeServiceImpl;
    }
/*
    @Test
    public void shouldFindEmployeeById(){
        Employee employee = Employee.builder().id(1l).build();
        //when(employeeRepository.findById(1l)).thenReturn(java.util.Optional.ofNullable(employee));
        assertEquals(employee,employeeServiceImpl.getEmployee(1l) );
    }
    @Test
    public void shouldThrowResourceNotFoundException(){
        assertThrows(ResourceNotFoundException.class, ()->employeeServiceImpl.getEmployee(2l));
    }
*/
}
