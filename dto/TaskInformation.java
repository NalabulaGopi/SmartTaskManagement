package com.smartTaskManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskInformation 
{
	private long id;
    private String emailid;
    private String typeoftask;
    private int priority;
    private String lastDate;
}
