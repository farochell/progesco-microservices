/**
 * 
 */
package com.progesco.rh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.rh.entity.Employee;
import com.progesco.rh.model.EmployeeModel;
import com.progesco.rh.repository.EmployeeRepository;

/**
 * @author emile.camara
 *
 */
@Service("EmployeeService")
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * Build Employee model
	 * @param employee
	 * @return
	 */
	public EmployeeModel buildEmployeeModel(Employee employee) {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setId(employee.getId());
		employeeModel.setBirthDate(employee.getBirthDate());
		employeeModel.setEmail(employee.getEmail());
		employeeModel.setFirstName(employee.getFirstName());
		employeeModel.setLastName(employee.getLastName());
		employeeModel.setGender(employee.getGender());
		employeeModel.setMainPhone(employee.getMainPhone());
		employeeModel.setMaritalStatus(employee.getMaritalStatus());
		employeeModel.setNationality(employee.getNationality());
		employeeModel.setNbChild(employee.getNbChild());
		employeeModel.setPlaceOfBirth(employee.getPlaceOfBirth());
		employeeModel.setRegistrationNumber(employee.getRegistrationNumber());
		employeeModel.setSecondPhone(employee.getSecondPhone());
		
		return employeeModel;
	}
	
	/**
	 * Return all employees
	 * @return
	 */
	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> employeeModels = new ArrayList<>();
		List<Employee> employees = employeeRepository.findAll();
		for(Employee employee: employees) {
			employeeModels.add(buildEmployeeModel(employee));
		}
		
		return employeeModels;
	}
}
