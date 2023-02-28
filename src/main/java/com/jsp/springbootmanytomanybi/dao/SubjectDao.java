package com.jsp.springbootmanytomanybi.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springbootmanytomanybi.dto.Students;
import com.jsp.springbootmanytomanybi.dto.Subjects;
import com.jsp.springbootmanytomanybi.repositery.SubjectRepositery;

@Repository
public class SubjectDao {

	@Autowired
	SubjectRepositery subjectRepositery;
	
	public void insertSubjectStudents(List<Subjects> subjects)
	{
		subjectRepositery.saveAll(subjects);
	}
	
	public int getById(int id)
	{
		Optional<Subjects> optional=subjectRepositery.findById(id);
		if(optional.isPresent())
		{
			return optional.get().getSubjectId();
		}
		else
		{
			return 0;
		}
	}
	
	public List<Students> getStudentSubject(int id)
	{
		Optional<Subjects> optional=subjectRepositery.findById(id);
		if(optional.isPresent())
		{
			return optional.get().getStudents();
		}
		else
		{
			return null;
		}
	}
	
	public void updateSubjectStudent(int subjectId, int studentId,Subjects subjects,Students students)
	{
		Optional<Subjects> optional=subjectRepositery.findById(subjectId);
		
		Subjects subjects2=optional.get();
		List<Students> students2=subjects2.getStudents();
		
		if(optional.isPresent())
		{
			
			if(subjects.getSubjectName()!=null)
			{
			subjects2.setSubjectName(subjects.getSubjectName());
			subjectRepositery.save(subjects2);
			}
			
			else if (students.getStudentEmail()!=null) 
			{
				for (Students students3 : students2) 
				{
					if(students3.getStudentId()==studentId)
					{
						students3.setStudentEmail(students.getStudentEmail());
						subjectRepositery.save(subjects2);
					}
				}
			}
			
			else if ((subjects.getSubjectName()!=null)&&(students.getStudentEmail()!=null)) 
			{
				subjects2.setSubjectName(subjects.getSubjectName());
				for (Students students3 : students2) 
				{
					if(students3.getStudentId()==studentId)
					{
						students3.setStudentEmail(students.getStudentEmail());
					}
				}
				subjectRepositery.save(subjects2);
			}
		}
	}
	
	public void deleteSubjectStudent(int id)
	{
		Optional<Subjects> optional=subjectRepositery.findById(id);
		
		if(optional.isPresent())
		{
			subjectRepositery.delete(optional.get());
		}
	}
	
	public List<Subjects> getSubjects()
	{
		List<Subjects> subjects=subjectRepositery.findAll();
		return subjects;
	}
//	or if we want to display students also along with subjects then-
	public List<Subjects> getSubjectStudent()
	{
		List<Subjects> subjects=subjectRepositery.findAll();
		return subjects;
	}
}
