package com.adak.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adak.web.entity.Employee;
import com.adak.web.repository.Repository;

@Service
public class MyService {

	@Autowired
	Repository repository;

	public void addEmp(Employee emp) {
		repository.save(emp);
	}

	public List<Employee> getAllEmp() {
		return repository.findAll();
	}
	
	public Employee getEmpById(Long id) {
		Optional<Employee> containner= repository.findById(id);
		if(containner.isPresent()) {
			return containner.get();
		}
		return null;
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
