package com.indra.hometutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.hometutor.module.Search;
import com.indra.hometutor.module.Student;
import com.indra.hometutor.module.Tutor;
import com.indra.hometutor.service.StudentService;
import com.indra.hometutor.service.TutorService;

import java.util.List;

@Controller
@RequestMapping("/home-search")
public class SearchController {
	
//	@Autowired
//	private StudentService  studentService;
//	
//	@Autowired
//	private TutorService tutorService;
//
// 
//	public SearchController(StudentService  studentService , TutorService tutorService){
//		super();
//		this.studentService=studentService;
//		this.tutorService=tutorService;
//	}
//	
//	
//	@PostMapping("/search-tutor-tuition")
//	public String getTutor(@ModelAttribute Search search , Model model) {
//		
//		
//		System.out.println(search.getCity());
//		String tutor_tuition=search.getTutor_tuition();
//		
//		System.out.println(tutor_tuition +" hello ");
//		
//		if(tutor_tuition=="Tutor") {
//			
//			List<Tutor> tutorData=tutorService.getAllTutor();
//			model.addAttribute("data", tutorData);
//			System.out.println("tutor search"); 
//			
//		}else if(tutor_tuition=="Tuition") {
//			
//			List<Student> studentdata = studentService.getStudentData();
//			
//			model.addAttribute("data", studentdata);
//			System.out.println("Tuition Search");
//		}
//			
//		return "search-tutor-tuition";
//	}
//	
//	@PostMapping("/")
//	public String getTuition() {
//		
//		return "index";
//	}
	
}
