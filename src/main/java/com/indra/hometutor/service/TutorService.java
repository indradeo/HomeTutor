package com.indra.hometutor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indra.hometutor.module.Tutor;

@Service
public interface TutorService {
	
	public List<Tutor> getAllTutor();
}
