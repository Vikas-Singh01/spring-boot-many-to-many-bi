package com.jsp.springbootmanytomanybi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springbootmanytomanybi.dto.Students;
import com.jsp.springbootmanytomanybi.dto.Subjects;
import com.jsp.springbootmanytomanybi.service.SubjectService;

@RestController
public class SubjectController 
{
	@Autowired
	SubjectService subjectService;
	
	
	@PostMapping("/insertSubjectStudents")
	public void insertSubjectStudents(@RequestBody List<Subjects> subjects)
	{
		subjectService.insertSubjectStudents(subjects);
	}
	
	
	@GetMapping("/getSubjectId/{id}")
	public int getById(@PathVariable int id)
	{
		return subjectService.getById(id);
	}
	
	
	@GetMapping("/getStudentSubject/{id}")
	public List<Students> getStudentSubject(@PathVariable int id)
	{
		return subjectService.getStudentSubject(id);
	}
	
	
	@PutMapping("/updateDetails/{subjectId}/{studentId}")
	public String updateSubjectStudent(@PathVariable int subjectId,@PathVariable int studentId,@RequestBody Subjects subjects,@RequestBody Students students)
	{
		return subjectService.updateSubjectStudent(subjectId, studentId, subjects, students);
	}
	
	
	@DeleteMapping("/deleteSubjectStudent/{id}")
	public String deleteSubjectStudent(@PathVariable int id)
	{
		return subjectService.deleteSubjectStudent(id);
	}
	
	
	@GetMapping("/getAllSubjects")
	public List<Subjects> getSubjects()
	{
		return subjectService.getSubjects();
	}
	
	@GetMapping("/getAllSubjectsStudents")
	public List<Object> getSubjectStudent()
	{
		return subjectService.getSubjectStudent();
	}
	
}
