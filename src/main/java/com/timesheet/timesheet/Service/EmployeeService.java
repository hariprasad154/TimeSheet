package com.timesheet.timesheet.Service;

import com.timesheet.timesheet.Dto.EmployeeDto;
import com.timesheet.timesheet.Dto.ResponceDto;
import com.timesheet.timesheet.model.Employee;

public interface EmployeeService {
    ResponceDto addManager(EmployeeDto employeeDto);

    ResponceDto getById(int employeeId);

    ResponceDto getAllData();

    ResponceDto deleteById(int employeeId);

    Employee updateById(int employeeId, EmployeeDto employeeDto);
}
