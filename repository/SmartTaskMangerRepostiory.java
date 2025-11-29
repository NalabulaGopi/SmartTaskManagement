package com.smartTaskManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartTaskManagement.entity.Userdetails;


public interface SmartTaskMangerRepostiory  extends JpaRepository<Userdetails, Integer>
{
	 Userdetails findByEmailid(String emailid);
}
