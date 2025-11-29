package com.smartTaskManagement.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartTaskManagement.dao.DAO;
import com.smartTaskManagement.dto.TaskInformation;
import com.smartTaskManagement.dto.UserInformation;
import com.smartTaskManagement.entity.TaskDetails;
import com.smartTaskManagement.entity.Userdetails;

@Service
public class ServiceClass 
{

	@Autowired
    DAO dao;
	
	@Autowired
	ModelMapper mapper;

    
	
	public void UserRegistration(UserInformation userinfo)
	{
		Userdetails userdetails=mapper.map(userinfo, Userdetails.class);
		dao.insertUserDetails(userdetails);
	}
	
	public boolean validateLogin(String emailid, String password) {
        Userdetails user = dao.findByEmail(emailid);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
	
	public void TaskDetailsInsertion(TaskInformation tinfo)
	{
		if (tinfo.getPriority() < 1 || tinfo.getPriority() > 5) {
            throw new IllegalArgumentException(
                "Priority must be between 1 and 5. Provided: " + tinfo.getPriority()
            );
        }
		TaskDetails td=mapper.map(tinfo, TaskDetails.class);
		dao.insertTaskDetails(td);
	}
	
	public List<TaskDetails> getTasksByEmail(String emailid) 
	{
		
        return dao.findbyEmailid(emailid);
    }
}
