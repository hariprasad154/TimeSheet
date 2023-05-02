package com.timesheet.timesheet.controller;

import com.timesheet.timesheet.Dto.ManagerDto;
import com.timesheet.timesheet.Dto.ResponceDto;
import com.timesheet.timesheet.Service.ManagerService;
import com.timesheet.timesheet.model.Manager;
import com.timesheet.timesheet.repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping("/addManager")
    public ResponceDto addManager(@RequestBody ManagerDto managerDto){
      return managerService.addManager(managerDto);
    }
    @GetMapping("/get/{manager_id}")
    public ResponceDto getById(@PathVariable int manager_id){
        return managerService.getById(manager_id);
    }
    @GetMapping("/getall")
    public ResponceDto getAllData(){
        return managerService.getAllData();
    }
    @DeleteMapping("/delete/{manager_id}")
    public ResponceDto deleteById(@PathVariable int manager_id){
        return managerService.deleteById(manager_id);
    }
    @PutMapping("/update/{manager_id}")
    public Manager updateById(@PathVariable int manager_id, @RequestBody ManagerDto managerDto){
        return managerService.updateById(manager_id,managerDto);
    }

}
