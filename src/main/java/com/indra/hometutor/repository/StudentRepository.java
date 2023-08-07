package com.indra.hometutor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.hometutor.module.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

	Student findAllById(String studentMobile);
	
	List<Student> findAllByMobile(String mobile);

}
