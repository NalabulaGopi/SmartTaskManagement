package com.smartTaskManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Userdetails 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
	@Column(nullable=false)
   private String name;
	 @Column(nullable=false,unique=true)
   private String emailid;
	 @Column(nullable=false,unique=true)
   private String password;
}
