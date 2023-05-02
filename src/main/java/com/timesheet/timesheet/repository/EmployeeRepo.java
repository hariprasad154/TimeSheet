package com.timesheet.timesheet.repository;

import com.timesheet.timesheet.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from Employee_table where email = :email",nativeQuery = true)
    Employee findDataByMail(String email);
}
