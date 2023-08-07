package com.indra.hometutor.service;

import com.indra.hometutor.module.Student;
import com.indra.hometutor.repository.StudentRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
	
	private StudentRepository repo;
	
	public  StudentServiceImp(StudentRepository repo){
		super();
		this.repo= repo;
	}
	
	
	public List<Student> getStudentData(){
		
		return (List<Student>) repo.findAll();
	}

}
