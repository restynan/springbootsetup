package com.example.springbootsetup.employee;

import io.swagger.annotations.Api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
@RequestMapping("/api/employees")
@Api(value = "" , tags = {"employee service"})
@Tag(name = "employee service", description = "Service for employees")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @Operation(summary = "get employee by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee information Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content) })
    @GetMapping("/v1/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@Parameter(description = "Id of Employee to be searched")@PathVariable("employeeId") Long employeeId){

        return new ResponseEntity<>(employeeService.getEmployee(employeeId) ,HttpStatus.OK);

    }

    // build save Employee API
    @PostMapping
    public ResponseEntity<Employee>saveEmployee(@RequestBody @Valid Employee employee){
        return  new ResponseEntity<>( employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // build get  All Employee API
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return  new ResponseEntity<>( employeeService.getAllEmployees(),HttpStatus.OK);
    }


    // build update employee
    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employeeId,employee),HttpStatus.OK);

    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
    }
}
