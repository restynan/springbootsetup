package com.example.springbootsetup.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private final EmployeeService employeeService;

    public EmployeeControllerTest(MockMvc mockMvc, EmployeeService employeeService) {
        this.mockMvc = mockMvc;
        this.employeeService = employeeService;
    }
   /* @Test
    public void ShoudReturnStatus200WhenGetEmployeeEndpointIsCalled() throws Exception {
        Employee employee =  Employee.builder().id(3l).firstName("Peter").lastName("john").build();
        when(employeeService.getEmployee(3l)).thenReturn(employee);
        mockMvc.perform(get("/api/employees/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }*/

}
