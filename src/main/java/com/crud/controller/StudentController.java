package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.model.StudentModel;
import com.crud.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/saveOrUpdate")
	public Student saveOrUpdateStudent(@RequestBody StudentModel studentModel) {
		return studentService.saveOrUpdateStudent(studentModel);	
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudentById(@PathVariable("id") Integer id) {
		return studentService.deleteStudentById(id);		
	}
	
	@GetMapping("/get")
	public List<Student> getAllData(@RequestParam(value = "id", required = false) Integer id ){
		return studentService.getAllData(id);
		
	}

}
