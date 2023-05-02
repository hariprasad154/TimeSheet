package com.timesheet.timesheet.repository;

import com.timesheet.timesheet.model.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSheetRepo extends JpaRepository<TimeSheet,Integer> {
    @Query(value = "select * from timesheet_table where employee_id = :employeeId",nativeQuery = true)
    List<TimeSheet> findByEmpId(int employeeId);
}
