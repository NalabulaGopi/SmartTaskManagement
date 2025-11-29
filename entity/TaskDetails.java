package com.smartTaskManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TaskDetails")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDetails 
{    
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 @Column(nullable=false)
     private String emailid;
	 @Column(nullable=false)
     private String typeoftask;
	 @Column(nullable=false)
     private int priority;
	 @Column(nullable=false)
     private String lastDate;
}
