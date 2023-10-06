package com.indra.hometutor.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.indra.hometutor.module.Contact;
import com.indra.hometutor.module.Search;
import com.indra.hometutor.module.Student;
import com.indra.hometutor.module.Tutor;
import com.indra.hometutor.repository.ContactRepo;
import com.indra.hometutor.repository.StudentRepository;
import com.indra.hometutor.repository.TutorRepository;
import com.indra.hometutor.service.StudentService;
import com.indra.hometutor.service.TutorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class HomeController {

	// HomePage
	@GetMapping("/")
	public String home(HttpServletRequest req ,Model model) {
		HttpSession session=req.getSession(false);

		if(session != null) {	
			return "main";
		}

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

		String tutorMobile=tutor.getMobile();
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
	public String saveStudent(@ModelAttribute Student student,Tutor tutor ,Model model) {

		String tutorMobile=tutor.getMobile();
		String studentMobile=student.getMobile();

		String regex = "^[6789]\\d{9}$";


		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(student.getMobile());

		if(!matcher.matches()) {

			String isvalidNumber="Are bhai kya kr rhe ho ... number toh shi daalo ";
			model.addAttribute("student", student);
			model.addAttribute("isValidNumber" ,isvalidNumber);
			return "studentRegister";
		}



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
	public String getTutor(@ModelAttribute Search search , Model model ,HttpServletRequest req) {


		System.out.println(search.getCity());

		String tutor_tuition=search.getTutor_tuition();
		String isTutor="Tutor";
		String isTuition="Tuition";
		System.out.println(tutor_tuition +" hello ");

		if(tutor_tuition == isTutor) {

			List<Tutor> tutorData=tutorService.getAllTutor();
			model.addAttribute("data", tutorData);
			System.out.println("tutor search"); 

		}else if(tutor_tuition!=isTuition) {

			List<Student> studentdata = studentService.getStudentData();

			model.addAttribute("data", studentdata);
			System.out.println("Tuition Search");
		}else {
			System.out.println("index");
			String message="NO RECORD FOUND !!";
			model.addAttribute("message", message);
			return "search-tutor-tuition";
		}

		if(req.getSession(false)!=null) {
			return "searchAll";
		}
		return "search-tutor-tuition";
	}

	@PostMapping("/")
	public String getTuition() {

		return "index";
	} 



	//Online Search

	@GetMapping("/Tutor-Tuition")
	public String onlineTuition(HttpServletRequest req, Model model) {
		if(req.getSession(false)==null) {
			return "login";

		}
		List <Student> studentData=studentRepository.findAll();
		List <Tutor>   tutorData =tutorRepository.findAll();

		model.addAttribute("tutorData", tutorData);
		model.addAttribute("studentData", studentData);
		return "tutor-tuition";
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

		return "login";
	}

	//	@PostMapping("/studentLogin")
	//	public String studentLogin(@ModelAttribute("student") Student student, HttpServletRequest req) {
	//		
	//		String studentMobile=student.getMobile();
	//		System.out.println(studentMobile);
	//		List<Student> studentData=studentRepository.findAllByMobile(studentMobile);
	//		System.out.println(studentData);
	//		if(!studentData.isEmpty()) {
	//			Student s=studentData.get(0);
	//			if(student.getPassword().equals(s.getPassword())){
	//				System.out.println("Login Successful");
	//	            req.getSession();
	//				return "successLogin"; 
	//			}else {
	//				return "login";
	//			}
	//		}else {
	//			System.out.println("Not Found");
	//			return "redirect:login";
	//		}
	//	}




	//Login control

	@PostMapping("/studentLogin")
	public String studentLogin(@ModelAttribute("student") Student student , HttpServletRequest req , Model model) {


		String clientIp=req.getRemoteAddr();
		String clientlocalIp=req.getLocalAddr();
		System.out.println(clientIp);
		System.out.println(clientlocalIp);

		String studentMobile=student.getMobile();

		List<Student> studentData=studentRepository.findAllByMobile(studentMobile);
		List<Tutor> tutorData=tutorRepository.findAllByMobile(studentMobile);

		if(!studentData.isEmpty()) {
			Student s=studentData.get(0);

			if(student.getPassword().equals(s.getPassword())){
				System.out.println("Login Successful");
				req.getSession();
				System.out.println(s);
				String user=s.getEmail();
				System.out.println(user);
				model.addAttribute("s", s);
				return "redirect:/"; 
			}else {
				System.out.println("login failed : ");
				String message="Doesn't match username and password";
				model.addAttribute("message", message);
				return "login";
			}
		}else if(!tutorData.isEmpty()) {
			Tutor s=tutorData.get(0);

			if(student.getPassword().equals(s.getPassword())){
				System.out.println("Login Successful");
				req.getSession();
				System.out.println(s);
				String user=s.getEmail();
				System.out.println(user);
				model.addAttribute("user", user);
				return "redirect:/"; 
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


	@GetMapping("/logout")
	public String Logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/";
	}


	//	@GetMapping("/home")
	//	String Home(HttpServletRequest req) {
	//		
	//		HttpSession session=req.getSession(false);
	//		
	//		if(session !=null) {
	//			return "main";
	//		}else {
	//			return "login";
	//		}
	//	}


	// Student Details

	@GetMapping("studentDetails/{id}")
	public String StudentDetails(@PathVariable  int id , Model model, Student student,HttpServletRequest req) {

		if(req.getSession(false)==null) {
			return "redirect:/login";
		}
		Student st=studentRepository.findAllById(id);
		System.out.println(st);
		model.addAttribute("st", st);
		return "studentProfile";
	}
	
	
	@GetMapping("tutorDetails/{id}")
	public String TutorDetails(@PathVariable  int id , Model model, Tutor tutor,HttpServletRequest req) {

		if(req.getSession(false)==null) {
			return "login";
		}
		Tutor st=tutorRepository.findById(id);
		System.out.println(st);
		model.addAttribute("st", st);
		return "studentProfile";
	}
	
	
	@GetMapping("/resetPassword")
	public String resestPassword() {
		
		
		
		
		return "reset-password";
	}
	
	
	//Code for Contact message
	
	@Autowired
	private ContactRepo contactRepo;
	
	@PostMapping("/contactMessage")
	public String contactMessage(@ModelAttribute Contact contact) {
		
		contactRepo.save(contact);
		
		System.out.println(contact+"Contact message controller");
		
		return "redirect:/";
	}
}
