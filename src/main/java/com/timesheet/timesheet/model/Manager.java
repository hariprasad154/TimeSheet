package com.timesheet.timesheet.model;

import com.timesheet.timesheet.Dto.ManagerDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "manager_table")
public class Manager {
    @Id
    @GeneratedValue
    private int managerId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isActive;

    public void update(ManagerDto managerDto){
        this.firstName=managerDto.getFirstName();
        this.lastName=managerDto.getLastName();
        this.email=managerDto.getEmail();
        this.password= managerDto.getPassword();
    }
    public  Manager(ManagerDto managerDto){
        this.update(managerDto);
    }

}
