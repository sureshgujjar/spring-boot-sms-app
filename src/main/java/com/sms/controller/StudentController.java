package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.entity.Student;
import com.sms.service.StudentService;

@Controller
public class StudentController 
{
   @Autowired
   private StudentService stuService;
   public StudentController()
   {
	   	super();
	   	this.stuService=stuService;
    }
   @GetMapping("/error")
   public String errorPage()
   {
	   return "error";
   }
   @GetMapping("/")
   public String rootPage(Model model)
   {
	   model.addAttribute("students",stuService.fetchAllStu());
	   return "students"; 
    }
 
   @GetMapping("/students")
   public String getAllStudents(Model model)
   {
	   model.addAttribute("students",stuService.fetchAllStu());
	   return "students"; 
    }
   @GetMapping("/students/new")
   public String createStudent(Model model)
   {
	   
	   Student student=new Student();
	   model.addAttribute("student_obj",student);
	   return "create_student";
	}
   @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student_obj")Student student)
    {
    	stuService.saveStudent(student);
    	return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Integer id,Model model)
    {
       model.addAttribute("student",stuService.editStudent(id));
       return "edit_student";
    			
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Integer id,@ModelAttribute("student") Student student,Model model)
    {
    	//Get Student from database
    	Student fetchStudent=stuService.editStudent(id);
    	fetchStudent.setId(student.getId());
    	fetchStudent.setFirst_name(student.getFirst_name());
    	fetchStudent.setLast_name(student.getLast_name());
    	fetchStudent.setEmail(student.getEmail());
    	//Save Updated Student Into Database 
    	stuService.updateStudent(fetchStudent);
    	return "redirect:/students"; 
    }
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Integer id)
    {
    	stuService.deleteStudent(id);
    	return "redirect:/students";
    }
    
}
