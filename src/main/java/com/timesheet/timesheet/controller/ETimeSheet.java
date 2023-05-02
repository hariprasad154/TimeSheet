package com.timesheet.timesheet.controller;

import com.timesheet.timesheet.Dto.ResponceDto;
import com.timesheet.timesheet.Dto.TimeSheetDto;
import com.timesheet.timesheet.Service.TimeSheetService;
import com.timesheet.timesheet.model.TimeSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class ETimeSheet {
    @Autowired
    private TimeSheetService timeSheetService;
    @PostMapping("/timesheets")
    public ResponceDto addTimeSheet(@RequestBody TimeSheetDto timeSheetDto){
        return timeSheetService.addTimeSheet(timeSheetDto);
    }
    @PutMapping("/edit/{employee_id}")
    public TimeSheet editTimeSheet(@PathVariable int employee_id,@RequestBody TimeSheetDto timeSheetDto){
        return timeSheetService.editTimeSheet(employee_id,timeSheetDto);
    }

}
