package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeEntity;
import com.employee.responsestructure.ResponseStructure;
import com.employee.service.EmployeeSrvice;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeSrvice service;
	
	@PostMapping("/addAllDetails")
	public ResponseStructure<EmployeeEntity> addAllDetails(@RequestBody EmployeeEntity entity)
	{
		return service.addAllDetails(entity);
	}
	
	@GetMapping("/getalldetails")
	public ResponseStructure<List<EmployeeEntity>> getALlDetails()
	{
		return service.getAlldetails();
	}
	@GetMapping("/getbyid/{id}")
	public ResponseStructure<EmployeeEntity> getById(@PathVariable int id)
	{
		return service.getById(id);
	}
	@GetMapping("/getbyname/{name}")
	public ResponseStructure<List<EmployeeEntity>> getByName(@PathVariable String name)
	{
		return service.getByName(name);
	}
	
	
	@GetMapping("/getbyphone/{phone}")
	public ResponseStructure<EmployeeEntity> getByPhone(@PathVariable long phone)
	{
		return service.getByPhone(phone);
	}
	
	@PutMapping("/updatebyid/{id}")
	public EmployeeEntity updateById(@PathVariable int id,@RequestBody EmployeeEntity entity)
	{
		return service.updateById(id,entity);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseStructure<EmployeeEntity> deleteById(@PathVariable int id)
	{
		return service.deleteById(id);
	}
}
