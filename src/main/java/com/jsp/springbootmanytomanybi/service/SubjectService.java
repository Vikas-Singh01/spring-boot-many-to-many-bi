package com.jsp.springbootmanytomanybi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springbootmanytomanybi.dao.SubjectDao;
import com.jsp.springbootmanytomanybi.dto.Students;
import com.jsp.springbootmanytomanybi.dto.Subjects;

@Service
public class SubjectService {

	
	@Autowired
	SubjectDao subjectDao;
	
	public void insertSubjectStudents(List<Subjects> subjects)
	{
		subjectDao.insertSubjectStudents(subjects);
	}
	
	public int getById(int id)
	{
		return subjectDao.getById(id);
	}
	
	public List<Students> getStudentSubject(int id)
	{
		return subjectDao.getStudentSubject(id);
	}
	
	public String updateSubjectStudent(int subjectId, int studentId,Subjects subjects,Students students)
	{
		if (subjectDao.getById(subjectId)!=0) 
		{
			subjectDao.updateSubjectStudent(subjectId, studentId, subjects, students);
			return "data updated";
		}
		else
		{
			return "check id";		}
	}
	
	public String deleteSubjectStudent(int id)
	{
		
		
		if(subjectDao.getById(id)!=0)
		{
		subjectDao.deleteSubjectStudent(id);
		return "data deleted";
		}
		
		else
		{
			return "check id please";
		}
	}
	public List<Subjects> getSubjects()
	{
		return subjectDao.getSubjects();
	}
	
	public List<Object> getSubjectStudent()
	{
		List<Subjects> subjects=subjectDao.getSubjectStudent();
		List<Object> objects=new ArrayList<>();
		for (Subjects subjects2 : subjects) 
		{
			List<Students> students=subjects2.getStudents();
			for (Students students2 : students) 
			{
				objects.add(students2);
			}
		}
		return objects;
		
		
	}
}
