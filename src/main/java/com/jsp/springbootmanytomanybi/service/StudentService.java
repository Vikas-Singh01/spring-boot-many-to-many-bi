package com.jsp.springbootmanytomanybi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springbootmanytomanybi.dao.StudentDao;
import com.jsp.springbootmanytomanybi.dto.Students;

@Service
public class StudentService {

	
	@Autowired
	StudentDao studentDao;
	
	public void insertStudents(List<Students> students)
	{
		studentDao.insertStudents(students);
	}
}
