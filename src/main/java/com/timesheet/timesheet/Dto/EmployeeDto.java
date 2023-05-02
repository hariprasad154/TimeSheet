package com.timesheet.timesheet.Dto;

import com.timesheet.timesheet.model.Manager;
import lombok.Data;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private Manager managerId;


}
