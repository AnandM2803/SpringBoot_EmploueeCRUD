package com.employee.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class EmployeeEntity {

	@Id
	@SequenceGenerator(initialValue = 100,allocationSize = 1,name = "id",sequenceName = "id")
	@GeneratedValue(generator = "id")
	
	@Column(name = "Emp_ID")
	private int id;
	
	@Column(name = "Emp_Name")
	private String name;
	
	@Column(name = "Phone_No")
	private long phone;
	
	@Column(name = "Emp_Email")
	private String email;
	
	@Column(name = "Emp_Address")
	private String address;
	
	@Column(name = "Date of Birth")
	private java.sql.Date dob;
	
	@Column(name = "Emp_Age")
	private int age;
	
	@Column(name = "Emp_Salary")
	private double salary;
}
