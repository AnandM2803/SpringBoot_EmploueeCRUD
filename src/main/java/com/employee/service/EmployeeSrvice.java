package com.employee.service;

import java.util.List;

import com.employee.entity.EmployeeEntity;
import com.employee.responsestructure.ResponseStructure;

public interface EmployeeSrvice {

	ResponseStructure<EmployeeEntity> addAllDetails(EmployeeEntity entity);

	ResponseStructure<List<EmployeeEntity>> getAlldetails();

	ResponseStructure<EmployeeEntity> getById(int id);

	ResponseStructure<List<EmployeeEntity>> getByName(String name);

	ResponseStructure<EmployeeEntity> getByPhone(long phone);

	EmployeeEntity updateById(int id, EmployeeEntity entity);

	ResponseStructure<EmployeeEntity> deleteById(int id);

	

}
