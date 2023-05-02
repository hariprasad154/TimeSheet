package com.timesheet.timesheet.controller;

import com.timesheet.timesheet.Dto.ResponceDto;
import com.timesheet.timesheet.Service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timesheet")
public class TimeSheetController {
    @Autowired
    private TimeSheetService timeSheetService;
    @GetMapping("/gettimesheets")
    public ResponceDto getAllTimeSheets(){
        return timeSheetService.getAllTimeSheets();
    }
    @GetMapping("/get/{timeseet_id}")
    public ResponceDto getById(@PathVariable int timeseetId){
        return timeSheetService.getById(timeseetId);
    }
    @DeleteMapping ("/delete/{timeseet_id}")
    public String deleteById(@PathVariable int timeseet_id){
        return timeSheetService.deleteById(timeseet_id);
    }

}
