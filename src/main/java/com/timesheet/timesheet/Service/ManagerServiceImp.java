package com.timesheet.timesheet.Service;

import com.timesheet.timesheet.Dto.ManagerDto;
import com.timesheet.timesheet.Dto.ResponceDto;
import com.timesheet.timesheet.model.Manager;
import com.timesheet.timesheet.repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImp implements  ManagerService{
    @Autowired
    private ManagerRepo managerRepo;

    @Override
    public ResponceDto addManager(ManagerDto managerDto) {
        Manager data=managerRepo.findDataByMail(managerDto.getEmail());
        if (data!=null){
            return new ResponceDto("Enter the unique Email id the manager is alredy present ",managerDto.getEmail());
        }else{
            Manager manager=new Manager(managerDto);
            return new ResponceDto("The manager is added  :",managerRepo.save(manager));
        }
    }

    @Override
    public ResponceDto getById(int managerId) {

        return new ResponceDto("The manager detailes are ",managerRepo.findById(managerId));
    }

    @Override
    public ResponceDto getAllData() {
        return new ResponceDto("The all data ",managerRepo.findAll());
    }

    @Override
    public ResponceDto deleteById(int managerId) {
//        Manager managerData=managerRepo.findById(managerId).orElseThrow();
        managerRepo.deleteById(managerId);
        return new ResponceDto("The data is deleted for the id ",managerId);
    }

    @Override
    public Manager updateById(int managerId, ManagerDto managerDto) {
        Manager data=this.managerRepo.getById(managerId);
        data.update(managerDto);
        return managerRepo.save(data);
//        return null;
    }

}
