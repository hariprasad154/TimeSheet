package com.timesheet.timesheet.Service;

import com.timesheet.timesheet.Dto.EmployeeDto;
import com.timesheet.timesheet.Dto.ResponceDto;
import com.timesheet.timesheet.model.Employee;
import com.timesheet.timesheet.model.Manager;
import com.timesheet.timesheet.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public ResponceDto addManager(EmployeeDto employeeDto) {
        Employee data=employeeRepo.findDataByMail(employeeDto.getEmail());
        if (data!=null){
            return new ResponceDto("Enter the unique Email id the manager is alredy present ",employeeDto.getEmail());
        }else{
            Employee employee=new Employee(employeeDto);
            return new ResponceDto("The manager is added  :",employeeRepo.save(employee));
        }
    }

    @Override
    public ResponceDto getById(int employeeId) {
        return new ResponceDto("The employee ",employeeRepo.findById(employeeId));
    }

    @Override
    public ResponceDto getAllData() {
        return new ResponceDto("The data is ",employeeRepo.findAll());
    }

    @Override
    public ResponceDto deleteById(int employeeId) {
        employeeRepo.deleteById(employeeId);
        return new ResponceDto("The employee deleted by ",employeeId);
    }

    @Override
    public Employee updateById(int employeeId, EmployeeDto employeeDto) {
        Employee empData=this.employeeRepo.getById(employeeId);
        empData.update(employeeDto);
        return employeeRepo.save(empData);
    }
}
