package com.jsp.springbootmanytomanybi.repositery;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springbootmanytomanybi.dto.Subjects;

public interface SubjectRepositery extends JpaRepository<Subjects, Integer>
{

}
