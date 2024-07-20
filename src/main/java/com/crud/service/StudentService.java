package com.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.entity.Student;
import com.crud.model.StudentModel;

@Service
public interface StudentService {

	Student saveOrUpdateStudent(StudentModel studentModel);

	String deleteStudentById(Integer id);

	List<Student> getAllData(Integer id);



}
