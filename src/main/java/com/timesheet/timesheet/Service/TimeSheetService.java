package com.timesheet.timesheet.Service;

import com.timesheet.timesheet.Dto.ResponceDto;
import com.timesheet.timesheet.Dto.TimeSheetDto;
import com.timesheet.timesheet.model.TimeSheet;
import org.springframework.stereotype.Service;


public interface TimeSheetService  {


    ResponceDto getAllTimeSheets();

    ResponceDto addTimeSheet(TimeSheetDto timeSheetDto);

    TimeSheet editTimeSheet(int employeeId, TimeSheetDto timeSheetDto);

    ResponceDto getById(int timeseetId);

    String deleteById(int timeseetId);
}
