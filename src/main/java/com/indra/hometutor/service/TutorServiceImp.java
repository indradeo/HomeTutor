package com.indra.hometutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.hometutor.module.Tutor;
import com.indra.hometutor.repository.TutorRepository;

@Service
public class TutorServiceImp implements TutorService{
	
	@Autowired
	private TutorRepository tutorRepo;
	
	public TutorServiceImp(TutorRepository tutorRepo) {
		super();
		this.tutorRepo = tutorRepo;
	}

	@Override
	public List<Tutor> getAllTutor() {
		
		return (List<Tutor>) tutorRepo.findAll();
	}

}
