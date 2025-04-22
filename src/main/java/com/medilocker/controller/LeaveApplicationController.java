package com.medilocker.controller;

import com.medilocker.entity.LeaveApplication;
import com.medilocker.service.LeaveApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveApplicationController {

    @Autowired
    private LeaveApplicationService leaveApplicationService;

    @PostMapping("/addLeave/{doctor_id}")
    public LeaveApplication addLeave(@RequestBody LeaveApplication leave,@PathVariable int doctor_id){
        return leaveApplicationService.addLeave(leave,doctor_id);
    }

    @GetMapping("/getLeave/{leave_id}")
    public LeaveApplication getLeave(@PathVariable int leave_id){
        return leaveApplicationService.getLeave(leave_id);
    }

    @GetMapping("/getAllLeave")
    public List<LeaveApplication> getAllLeave(){
        return leaveApplicationService.getAllLeave();
    }
    
    @PutMapping("update/{leave_id}")
    public LeaveApplication updateLeave(@RequestBody LeaveApplication leave,@PathVariable int leave_id) {
    	return leaveApplicationService.updateLeave(leave_id, leave);
    }
    
}
