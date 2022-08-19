package com.example.springbootsetup.employee;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=2,max = 10, message ="first name should have between 2-10 characters")
    @Column(name="first_name")
    private String firstName;

    @Size(min=2,max = 10, message ="last name should have between 2-10 characters")
    @Column(name="last_name")
    private String lastName;
    @Email(message = "invalid email entered")
    private String email;

    @Min(value = 18, message = "must be more than or equal to 18")
    @Max(value = 65, message = "must be less than or equal to 65")
    private int age;


}
