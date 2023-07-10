package com.employee.serviceimpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.repository.EmployeeRepository;
import com.employee.responsestructure.ResponseStructure;
import com.employee.service.EmployeeSrvice;

@Service
public class EmployeeServiceimpl  implements EmployeeSrvice{
	
	@Autowired
	EmployeeRepository repository;

	@Override
	public ResponseStructure<EmployeeEntity> addAllDetails(EmployeeEntity entity) {

ResponseStructure<EmployeeEntity> structure=new ResponseStructure<>();

entity.setAge(Period.between(entity.getDob().toLocalDate(), LocalDate.now()).getYears());
structure.setMessga("Data Saved Successufully");
structure.setCode(HttpStatus.CREATED.value());
structure.setDataT(repository.save(entity));
return structure;
	}

	@Override
	public ResponseStructure<List<EmployeeEntity>> getAlldetails() {
		
		ResponseStructure<List<EmployeeEntity>> structure=new ResponseStructure<List<EmployeeEntity>>();
		
		List<EmployeeEntity> list=repository.findAll();
		
		if(list.isEmpty())
		{
			structure.setMessga("Data is Not found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setDataT(null);
		}
		else
		{
			structure.setMessga("Data Found");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setDataT(list);
		}
		return structure;
	}

	@Override
	public ResponseStructure<EmployeeEntity> getById(int id) {
		
		ResponseStructure<EmployeeEntity> structure=new ResponseStructure<EmployeeEntity>();
		
		EmployeeEntity entity=repository.findById(id).get();
		if(entity==null)
		{
			structure.setMessga("Data Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setDataT(null);
		}
		else
		{
			structure.setMessga("Data Found");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setDataT(entity);
		}
		return structure;
	}

	@Override
	public ResponseStructure<List<EmployeeEntity>> getByName(String name) {
		
		ResponseStructure<List<EmployeeEntity>> structure=new ResponseStructure<List<EmployeeEntity>>();
		
		List<EmployeeEntity> list=repository.getByName(name);
		if(list.isEmpty())
		{
			structure.setMessga("Data Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setDataT(null);
		}
		else
		{
			structure.setMessga("Data Found");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setDataT(list);
		}
		return structure;
	}

	@Override
	public ResponseStructure<EmployeeEntity> getByPhone(long phone) {
		ResponseStructure<EmployeeEntity> structure=new ResponseStructure<EmployeeEntity>();
		
		EmployeeEntity entity=repository.getByPhone(phone);
		if(entity==null)
		{
			structure.setMessga("Data Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setDataT(null);
		}
		else
		{
			structure.setMessga("Data Found");
			structure.setCode(HttpStatus.FOUND.value());
			structure.setDataT(entity);
		}
		return structure;
	}

	@Override
	public EmployeeEntity updateById(int id, EmployeeEntity entity) {
		
		EmployeeEntity entity2=repository.findById(id).get();
		if(entity2!=null)
		{
			entity2.setAge(Period.between(entity.getDob().toLocalDate(), LocalDate.now()).getYears());
			entity2.setName(entity.getName());
			entity2.setAddress(entity.getAddress());
			entity2.setDob(entity.getDob());
			entity2.setEmail(entity.getEmail());
			entity2.setPhone(entity.getPhone());
			entity2.setSalary(entity.getSalary());
			repository.save(entity2);
			}
		return entity2;
	}

	@Override
	public ResponseStructure<EmployeeEntity> deleteById(int id) {
		
		ResponseStructure<EmployeeEntity> structure=new ResponseStructure<EmployeeEntity>();
		EmployeeEntity entity=repository.findById(id).get();
		if(entity==null)
		{
			structure.setMessga("Data Not Found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setDataT(null);
		}
		else
		{
			repository.deleteById(id);
			structure.setMessga("Data Deleted Successfully");
			structure.setCode(HttpStatus.OK.value());
			structure.setDataT(entity);
		}
		return structure;
	}

	

}
