package com.crud.model;

import java.sql.Date;


import lombok.Data;

@Data
public class StudentModel {
	private Integer id;

	private String firstName;

	private String lastName;

	private String email;

	private Date dob;

	private Integer age;

	private String standard;
}
