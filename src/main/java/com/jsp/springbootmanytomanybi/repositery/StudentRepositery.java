package com.jsp.springbootmanytomanybi.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springbootmanytomanybi.dto.Students;

public interface StudentRepositery extends JpaRepository<Students, Integer>
{

}
