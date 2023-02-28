package com.jsp.springbootmanytomanybi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springbootmanytomanybi.dto.Students;
import com.jsp.springbootmanytomanybi.service.StudentService;

@RestController
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/insertStudents")
	public void insertStudents(@RequestBody List<Students> students)
	{
		studentService.insertStudents(students);
	}
}
