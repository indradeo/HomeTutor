package com.indra.hometutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.indra.hometutor.module.Student;
import com.indra.hometutor.repository.StudentRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Student")
public class StudentController {

//	@Autowired
//	private StudentRepository studentRepository;
//	
//	
//	@GetMapping("/studentRegister") 
//	public String registerStudent(Model model) {
//		
//		model.addAttribute("student", new Student());
//		return "studentRegister";
//	}
//	
//	@PostMapping("/saveStudent")
//	public String saveStudent( @ModelAttribute("student") Student student) {
//
//		System.out.println("Succefully register");
//		studentRepository.save(student);
//		
//		return "redirect:/";
//	}
//	
//	@PostMapping("/studentLogin")
//	public String studentLogin(@ModelAttribute("student") Student student, HttpServletRequest req) {
//		
//		String studentMobile=student.getMobile();
//		List<Student> studentData=studentRepository.findAllByMobile(studentMobile);
//		System.out.println(studentData);
//		Student s=studentData.get(0);
//		if(student.getPassword().equals(s.getPassword())){
//			System.out.println("Login Successful");
//            req.getSession();
//			return "Login successfull"; 
//		}else {
//			return "login";
//		}
//	}
}
