package com.indra.hometutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.indra.hometutor.module.Tutor;
import com.indra.hometutor.repository.TutorRepository;

@Controller
@RequestMapping("/Tutor")
public class TutorController {
	
//	@Autowired
//	private TutorRepository tutorRepository;
//
//	@GetMapping("/tutorRegister") 
//	public String registerTutor() {
//		
//		
//		return "tutorRegister";
//	}
//	
//	
//	@PostMapping("/saveTutor")
//	public String saveTutor(@ModelAttribute Tutor tutor,Model model) {
//		
//		System.out.println(tutor.toString());
//		tutorRepository.save(tutor);
//		model.addAttribute("user", tutor);
//		
//		return "login";
//	}
}
