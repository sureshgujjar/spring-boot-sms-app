package com.sms.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student;
import com.sms.repo.StudentRepo;
import com.sms.service.StudentService;

@Service
public class StudentServiceImp implements StudentService
{
	@Autowired
	private StudentRepo stuRepo;
	public StudentServiceImp()
	{
		super();
		this.stuRepo=stuRepo; 
	}

	@Override
	public List<Student> fetchAllStu() {
		
		return stuRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) 
	{
		return stuRepo.save(student);
	}

	@Override
	
	public Student editStudent(Integer id) 
	{
		return stuRepo.findById(id).orElseThrow();
		
	}

	@Override
	public Student updateStudent(Student student) {
		return stuRepo.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		
		stuRepo.deleteById(id);
		
	}

}
