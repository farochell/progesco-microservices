/**
 * 
 */
package com.progesco.rh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.progesco.rh.service.EmployeeService;
import com.progesco.rh.model.EmployeeModel;

/**
 * @author emile.camara
 *
 */
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 
	
	@GetMapping("/employees")
	public List<EmployeeModel> getAllEmployee() {
		return employeeService.getAllEmployees();
	}
}
