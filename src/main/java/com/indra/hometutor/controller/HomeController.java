package com.indra.hometutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.indra.hometutor.module.Search;
import com.indra.hometutor.module.Student;
import com.indra.hometutor.module.Tutor;
import com.indra.hometutor.repository.StudentRepository;
import com.indra.hometutor.repository.TutorRepository;
import com.indra.hometutor.service.StudentService;
import com.indra.hometutor.service.TutorService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class HomeController {
	
	// HomePage
	@GetMapping("/")
	public String home() {
		
		return "index";
	}
		
	
	//TUTOR REGISTER CONTrol
	
	@Autowired
	private TutorRepository tutorRepository;

	@GetMapping("/tutorRegister") 
	public String registerTutor() {
		
		
		return "tutorRegister";
	}
	
	
	@PostMapping("/saveTutor")
	public String saveTutor(@ModelAttribute Tutor tutor,Student student,Model model) {
		
		long tutorMobile=tutor.getMobile();
		String studentMobile=student.getMobile();
		List<Student> checkMobileAvailability=studentRepository.findAllByMobile(studentMobile);
		List<Tutor> isMobileAvailable=tutorRepository.findAllByMobile(tutorMobile);
		if(!checkMobileAvailability.isEmpty() || !isMobileAvailable.isEmpty()) {
			 String message = "User is already registered with "+ tutorMobile;
		     model.addAttribute("message", message);
		     return "tutorRegister";
		}
		System.out.println(tutor.toString());
		tutorRepository.save(tutor);
		model.addAttribute("user", tutor);
		
		return "login";
	}
	
	
	
	//Student control
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@GetMapping("/studentRegister") 
	public String registerStudent(Model model) {
		
		model.addAttribute("student", new Student());
		return "studentRegister";
	
	}

	
	@PostMapping("/saveStudent")
	public String saveStudent( @ModelAttribute("student") Student student,Tutor tutor ,Model model) {
		
		long tutorMobile=tutor.getMobile();
		String studentMobile=student.getMobile();
		List<Student> checkMobileAvailability=studentRepository.findAllByMobile(studentMobile);
		List<Tutor> isMobileAvailable=tutorRepository.findAllByMobile(tutorMobile);
		
		if(!checkMobileAvailability.isEmpty() || !isMobileAvailable.isEmpty()) {
			 String message = "User is already registered with "+ studentMobile;
		     model.addAttribute("message", message);
		     return "studentRegister";
		}
		System.out.println("Succefully register");
		studentRepository.save(student);
		model.addAttribute("user", student);
		
		return "login";
	}
	
	
	
	
	//search controller
	
	@Autowired
	private StudentService  studentService;
	
	@Autowired
	private TutorService tutorService;
	
	@PostMapping("/search-tutor-tuition")
	public String getTutor(@ModelAttribute Search search , Model model) {
		
		
		System.out.println(search.getCity());
		String tutor_tuition=search.getTutor_tuition();
		
		System.out.println(tutor_tuition +" hello ");
		
		if("Tutor"==tutor_tuition) {
			
			List<Tutor> tutorData=tutorService.getAllTutor();
			model.addAttribute("data", tutorData);
			System.out.println("tutor search"); 
			
		}else if("Tuition"==tutor_tuition) {
			
			List<Student> studentdata = studentService.getStudentData();
			
			model.addAttribute("data", studentdata);
			System.out.println("Tuition Search");
		}else {
			System.out.println("index");
			return "redirect:/";
		}
			
		return "search-tutor-tuition";
	}
	
	@PostMapping("/")
	public String getTuition() {
		
		return "index";
	}

	
	
	//Online Search
	
	@GetMapping("/OnlineTuition")
	public String onlineTuition() {
		
		return "search";
	}
	
	
	
	
//	@GetMapping("/tutorRegister") 
//	public String registerTutor() {
//		
//		
//		return "tutorRegister";
//	}
	
//	@GetMapping("/studentRegister") 
//	public String registerStudent(Model model) {
//		
//		model.addAttribute("student", new Student());
//		return "studentRegister";
//	}
	
//	@PostMapping("/saveTutor")
//	public String saveTutor(@ModelAttribute Tutor tutor,Model model) {
//		
//		System.out.println(tutor.toString());
//		tutorRepository.save(tutor);
//		model.addAttribute("user", tutor);
//		
//		return "login";
//	}
	
	
//	@PostMapping("/saveStudent")
//	public String saveStudent( @ModelAttribute("student") Student student) {
//
//		System.out.println("Succefully register");
//		studentRepository.save(student);
//		
//		return "redirect:/";
//	}
	
	@GetMapping("/login")
	public String login() {
//		Student student = new Student();
//		model.addAttribute("user", student);
		return "login";
	}
	
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
	
	
	
	
	//Login control
	
	@PostMapping("/studentLogin")
	public String studentLogin(@ModelAttribute Student student,Tutor tutor , HttpServletRequest req , Model model) {
		
		String studentMobile=student.getMobile();
		long tutorMobile=tutor.getMobile();
		List<Student> studentData=studentRepository.findAllByMobile(studentMobile);
		List<Tutor> tutorData=tutorRepository.findAllByMobile(tutorMobile);
		System.out.println(studentData);
		if(!studentData.isEmpty()) {
			Student s=studentData.get(0);
			
			if(student.getPassword().equals(s.getPassword())){
				System.out.println("Login Successful");
				req.getSession();
				return "successLogin"; 
			}else {
				System.out.println("login failed : ");
				String message="Doesn't match username and password";
				model.addAttribute("message", message);
				return "login";
			}
		}else if(!tutorData.isEmpty()) {
			Tutor s=tutorData.get(0);
			
			if(tutor.getPassword().equals(s.getPassword())){
				System.out.println("Login Successful");
				req.getSession();
				return "successLogin"; 
			}else {
				System.out.println("login failed : ");
				String message="Doesn't match username and password";
				model.addAttribute("message", message);
				return "login";
			}
			
		}else {
			System.out.println("User Not Found");
			String message="User Not Found";
			model.addAttribute("message", message);
			return "login";
		}
	}
}
