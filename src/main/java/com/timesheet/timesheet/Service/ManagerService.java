package com.timesheet.timesheet.Service;

import com.timesheet.timesheet.Dto.ManagerDto;
import com.timesheet.timesheet.Dto.ResponceDto;
import com.timesheet.timesheet.model.Manager;

public interface ManagerService {
    ResponceDto addManager(ManagerDto managerDto);

    ResponceDto getById(int managerId);

    ResponceDto getAllData();

    ResponceDto deleteById(int managerId);

    Manager updateById(int managerId, ManagerDto managerDto);
}
