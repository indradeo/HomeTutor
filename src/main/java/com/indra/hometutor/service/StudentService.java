package com.indra.hometutor.service;

import org.springframework.stereotype.Service;

import com.indra.hometutor.module.Student;

import java.util.List;


@Service
public interface StudentService {
	
	public List<Student> getStudentData();

}
