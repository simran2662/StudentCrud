package com.crud.util;

import org.springframework.stereotype.Service;

import com.crud.entity.Student;
import com.google.common.base.Strings;

@Service
public class StudentUtil {

	public void updateStudentData(Student student, Student student2) {
		if (!Strings.isNullOrEmpty(student2.getFirstName())) 
			student.setFirstName(student2.getFirstName());
		
		if (!Strings.isNullOrEmpty(student2.getLastName())) 
			student.setLastName(student2.getLastName());
		
		if (!Strings.isNullOrEmpty(student2.getEmail())) 
			student.setEmail(student2.getEmail());
		
		if(student2.getDob() != null) 
			student.setDob(student2.getDob());
		
		if(student2.getAge() != null) 
			student.setAge(student2.getAge());
		if(!Strings.isNullOrEmpty(student2.getStandard()))
			student.setStandard(student2.getStandard());
	}

}
