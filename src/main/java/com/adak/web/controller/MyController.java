package com.adak.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adak.web.entity.Employee;
import com.adak.web.service.MyService;

@Controller
@RequestMapping("/adak")
public class MyController {

	@Autowired
	private MyService myService;

	@PostMapping("/save")
	public String insertEmp(@ModelAttribute Employee emp) {

		myService.addEmp(emp);

		return "redirect:/adak/get";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id,Model m) {
		
		Employee emp= myService.getEmpById(id);
		m.addAttribute("emp", emp);
		return "edit";
	}

	@GetMapping("/get")
	public String readAllEmp(Model m) {

		List<Employee> list = myService.getAllEmp();

		m.addAttribute("Employees", list);

		return "about";
	}
	
	@GetMapping("/addEmp")
		public String addEmployee() {
		
		return "addEmp";
		
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee emp) {
		
		myService.addEmp(emp);
		return "redirect:/get";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable Long id) {
		myService.deleteById(id);
		return "redirect:/adak/get";
	}
}
