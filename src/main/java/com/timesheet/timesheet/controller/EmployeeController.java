package com.timesheet.timesheet.controller;

import com.timesheet.timesheet.Dto.EmployeeDto;
import com.timesheet.timesheet.Dto.ResponceDto;
import com.timesheet.timesheet.Service.EmployeeService;
import com.timesheet.timesheet.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemployee")
    public ResponceDto addManager(@RequestBody EmployeeDto employeeDto){
        return employeeService.addManager(employeeDto);
    }
    @GetMapping("/get/{employee_id}")
    public ResponceDto getById(@PathVariable int employee_id){
        return employeeService.getById(employee_id);
    }
    @GetMapping("/getall")
    public ResponceDto getAllData(){
        return employeeService.getAllData();
    }
    @DeleteMapping("/delete/{employee_id}")
    public ResponceDto deleteById(@PathVariable int employee_id){
        return employeeService.deleteById(employee_id);
    }
    @PutMapping("/update/{employee_id}")
    public Employee updateById(@PathVariable int employee_id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateById(employee_id,employeeDto);
    }
}
