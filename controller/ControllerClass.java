package com.smartTaskManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartTaskManagement.dto.TaskInformation;
import com.smartTaskManagement.dto.UserInformation;
import com.smartTaskManagement.entity.TaskDetails;
import com.smartTaskManagement.service.EmailService;
import com.smartTaskManagement.service.ServiceClass;

@Controller
public class ControllerClass 
{
	@Autowired
	ServiceClass serviceclass;
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/register")
	public String userRegistration(Model model)
	{
	   model.addAttribute("userinfo",new UserInformation());	
		return "page";
	}
	
	@RequestMapping("/requestpage")
	public String request(UserInformation ui)
	{
        System.out.println(ui);
        serviceclass.UserRegistration(ui);
        return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
        return "login"; 
    }
	
	@PostMapping("/login")
	public String checklogin(String emailid,String password,Model model)
	{
        boolean success = serviceclass.validateLogin(emailid, password);
         if(success)
         {
        	 System.out.println("Welcome");
        	 model.addAttribute("tinfo", new TaskInformation());
        	 return "TaskDetails";
        }
         else
         {
        	 model.addAttribute("error", "Invalid credentials");
             return "login";
         }
	}
	
	@RequestMapping("/TaskRequest")
	public String add(TaskInformation tinfo, Model model) 
	{
		try {
		serviceclass.TaskDetailsInsertion(tinfo);
		
		String subject = "✅ Task Added Successfully - Smart Task Management";

		String body = "Hello " + tinfo.getEmailid() + ",\n\n"
		    + "We’re happy to let you know that your new task has been added successfully to the Smart Task Management system.\n\n"
		    + "Here are the details of your task:\n"
		    + "• Task Type: " + tinfo.getTypeoftask() + "\n"
		    + "• Priority: " + tinfo.getPriority() + "\n"
		    + "• Due Date: " + tinfo.getLastDate() + "\n"
		    + "• Assigned Email: " + tinfo.getEmailid() + "\n\n"
		    + "What this means:\n"
		    + "- Your task is now saved in the system.\n"
		    + "- You can view or update it anytime by logging into your account.\n"
		    + "- A reminder will be sent as the due date approaches (if enabled).\n\n"
		    + "Thank you for using Smart Task Management to stay organized and productive!\n\n"
		    + "Best regards,\n"
		    + "Smart Task Management Team";

	    emailService.sendTaskEmail(tinfo.getEmailid(), subject, body);
	    
	    
	    model.addAttribute("successMessage", "Task Added Successfully ✅");
	    model.addAttribute("tinfo", new TaskInformation());
		}
		catch (IllegalArgumentException e) {
	        model.addAttribute("errorMessage", e.getMessage());
	        model.addAttribute("tinfo", tinfo); // keep entered values
	    }
        return "TaskDetails";
        
		
		
	}

	
	@RequestMapping("/GetTaskDetailsByEmailid")
	public String GetTaskDetailsByEmailid(String emailid,Model model)
	{
	  System.out.println(emailid);
	  model.addAttribute("tasks", serviceclass.getTasksByEmail(emailid));
	  return "TaskDetailsByEmailid";
	}
	
	@GetMapping("/TaskDetails")
	public String showTaskDetails(Model model) {
	    model.addAttribute("tinfo", new TaskInformation());
	    return "TaskDetails";
	}
}
