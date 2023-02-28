package com.jsp.springbootmanytomanybi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class Subjects 
{

		@Id
		private int subjectId;
		private String subjectName;
		
		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "studentsubject",
		joinColumns = { @JoinColumn(name="subjectid")},
		inverseJoinColumns = {@JoinColumn(referencedColumnName="studentid")})
		@JsonBackReference
		private  List<Students> students;
		public int getSubjectId() {
			return subjectId;
		}
		public void setSubjectId(int subjectId) {
			this.subjectId = subjectId;
		}
		public String getSubjectName() {
			return subjectName;
		}
		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}
		public List<Students> getStudents() {
			return students;
		}
		public void setStudents(List<Students> students) {
			this.students = students;
		}
}
