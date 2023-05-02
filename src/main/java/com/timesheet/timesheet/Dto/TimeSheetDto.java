package com.timesheet.timesheet.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.timesheet.timesheet.model.Employee;
import com.timesheet.timesheet.model.Manager;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;
@Data
public class TimeSheetDto {
    private int employeeId;
    private int managerId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate EndDate;
    private String Description;

}
