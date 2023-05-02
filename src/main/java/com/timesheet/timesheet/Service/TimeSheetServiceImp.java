package com.timesheet.timesheet.Service;

import com.timesheet.timesheet.Dto.ResponceDto;
import com.timesheet.timesheet.Dto.TimeSheetDto;
import com.timesheet.timesheet.model.TimeSheet;
import com.timesheet.timesheet.repository.EmployeeRepo;
import com.timesheet.timesheet.repository.ManagerRepo;
import com.timesheet.timesheet.repository.TimeSheetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TimeSheetServiceImp implements TimeSheetService {
    @Autowired
    private TimeSheetRepo timeSheetRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ManagerRepo managerRepo;

    @Override
    public ResponceDto addTimeSheet(TimeSheetDto timeSheetDto) {
        LocalDate startDate=timeSheetDto.getStartDate();
        LocalDate endDate=timeSheetDto.getEndDate();
        List<TimeSheet> data=timeSheetRepo.findByEmpId(timeSheetDto.getEmployeeId());
        System.out.println(data);
        boolean isPresent=false;
        if(data!=null){
            for(int i=0;i< data.size();i++) {
                LocalDate start = data.get(i).getStartDate();
                LocalDate end = data.get(i).getEndDate();

                if (startDate.isEqual(start)&& endDate.isEqual(end)) {
                    isPresent = true;
                }
            }
            if (isPresent){
                return new ResponceDto("The Data present with that dates ", startDate + " " + "to  " + endDate);
            }else {
                TimeSheet timeSheet = new TimeSheet(timeSheetDto);
                timeSheet.setStatus("Draft");
                return new ResponceDto("The TimeSheet Added ",timeSheetRepo.save(timeSheet));
            }
        }
        else {
            TimeSheet timeSheet = new TimeSheet(timeSheetDto);
            timeSheet.setStatus("Draft");
            return new ResponceDto("The TimeSheet Added ", timeSheetRepo.save(timeSheet));
        }
    }

    @Override
    public TimeSheet editTimeSheet(int employeeId, TimeSheetDto timeSheetDto) {
        TimeSheet data=this.timeSheetRepo.getById(employeeId);
        data.setStatus("Draft");
        data.update(timeSheetDto);
        return timeSheetRepo.save(data);
    }

    @Override
    public ResponceDto getById(int timeseetId) {
        TimeSheet timeSheet= timeSheetRepo.findById(timeseetId).orElseThrow();
        return new ResponceDto("the data is ",timeSheet);
    }
    @Override
    public ResponceDto getAllTimeSheets() {
        return new ResponceDto("the time sheet data ",timeSheetRepo.findAll());
    }
    @Override
    public String deleteById(int timeseetId) {
        timeSheetRepo.deleteById(timeseetId);
        return "The data deleted ......";
    }

}
