package com.smartTaskManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartTaskManagement.entity.TaskDetails;

public interface TaskDetailsRepository extends JpaRepository<TaskDetails, Integer>
{
	List<TaskDetails> findByEmailid(String emailid);
}
