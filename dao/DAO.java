package com.smartTaskManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smartTaskManagement.entity.TaskDetails;
import com.smartTaskManagement.entity.Userdetails;
import com.smartTaskManagement.repository.SmartTaskMangerRepostiory;
import com.smartTaskManagement.repository.TaskDetailsRepository;

@Repository
public class DAO 
{    
	@Autowired
     SmartTaskMangerRepostiory str;
	@Autowired
	 TaskDetailsRepository tdr;
	 public Userdetails insertUserDetails(Userdetails us)
	 {
		 return str.save(us);
	 }
	 
	 public Userdetails findByEmail(String emailid) {
	        return str.findByEmailid(emailid);
	    }
	 
	 public TaskDetails insertTaskDetails(TaskDetails ts)
	 {
		  return tdr.save(ts);
	 }
	 
	 public List<TaskDetails> findbyEmailid(String emailid)
	 {
		  List<TaskDetails> list=tdr.findByEmailid(emailid);
		  return list;
	 }
}
