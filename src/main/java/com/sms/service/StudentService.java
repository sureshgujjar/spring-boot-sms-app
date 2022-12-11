package com.sms.service;

import java.util.List;

import com.sms.entity.Student;

public interface StudentService 
{
   List <Student> fetchAllStu();
   Student saveStudent(Student student);
   Student editStudent(Integer id);
   Student updateStudent(Student student);
   void deleteStudent(Integer id);
}
