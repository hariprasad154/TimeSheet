package com.timesheet.timesheet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.timesheet.timesheet.Dto.TimeSheetDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "timesheet_table")
public class TimeSheet {
    @Id
    @GeneratedValue
    private int timeseetId;
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id")
    private int employeeId;
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "manager_id")
    private int managerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate date;
    private String status;
    private String description;

    public void update(TimeSheetDto timeSheetDto){
        this.date=LocalDate.now();
        this.employeeId=timeSheetDto.getEmployeeId();
        this.managerId=timeSheetDto.getManagerId();
        this.startDate=timeSheetDto.getStartDate();
        this.endDate=timeSheetDto.getEndDate();
        this.description=timeSheetDto.getDescription();
    }
    public TimeSheet(TimeSheetDto timeSheetDto){
        this.update(timeSheetDto);
    }

}
