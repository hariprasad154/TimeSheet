package com.timesheet.timesheet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.timesheet.timesheet.Dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Employee_table")
public class Employee {
    @Id
    @GeneratedValue
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Manager manager_id;

    private boolean isActive;

    public void update(EmployeeDto employeeDto){
        this.firstName=employeeDto.getFirstName();
        this.lastName=employeeDto.getLastName();
        this.email=employeeDto.getEmail();
        this.password=employeeDto.getPassword();
        this.role=employeeDto.getRole();
        this.manager_id=employeeDto.getManagerId();

    }
    public Employee(EmployeeDto employeeDto){
        this.update(employeeDto);
    }

}
