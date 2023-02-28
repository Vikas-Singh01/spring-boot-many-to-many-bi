package com.jsp.springbootmanytomanybi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springbootmanytomanybi.dto.Students;
import com.jsp.springbootmanytomanybi.repositery.StudentRepositery;

@Repository
public class StudentDao {

	@Autowired
	StudentRepositery studentRepositery;
	
	public void insertStudents(List<Students> students)
	{
		studentRepositery.saveAll(students);
	}
}
