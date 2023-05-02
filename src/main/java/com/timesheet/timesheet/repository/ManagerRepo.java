package com.timesheet.timesheet.repository;

import com.timesheet.timesheet.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Integer> {
    @Query(value = "select * from manager_table where email = :email",nativeQuery = true)
    Manager findDataByMail(String email);
}
