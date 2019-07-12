/**
 * 
 */
package com.progesco.rh.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
	private EmployeeModel buildEmployeeModel(Employee employee) {
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
	 * Build employee
	 * @param employeeModel
	 * @return
	 */
	private Employee buildEmployee(EmployeeModel employeeModel) {
		Employee employee = new Employee();
		employee.setId(employeeModel.getId());
		employee.setBirthDate(employeeModel.getBirthDate());
		employee.setEmail(employeeModel.getEmail());
		employee.setFirstName(employeeModel.getFirstName());
		employee.setLastName(employeeModel.getLastName());
		employee.setGender(employeeModel.getGender());
		employee.setMainPhone(employeeModel.getMainPhone());
		employee.setMaritalStatus(employeeModel.getMaritalStatus());
		employee.setNationality(employeeModel.getNationality());
		employee.setNbChild(employeeModel.getNbChild());
		employee.setPlaceOfBirth(employeeModel.getPlaceOfBirth());
		employee.setRegistrationNumber(employeeModel.getRegistrationNumber());
		employee.setSecondPhone(employeeModel.getSecondPhone());
		
		return employee;
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
	
	/**
	 * Add a new employee
	 * @param employeeModel
	 * @return
	 */
	public EmployeeModel addEmployee(EmployeeModel employeeModel) {
		Employee employee = buildEmployee(employeeModel);
		employeeRepository.save(employee);
		String registrationNumber = buildRegistrationNumber(employee.getLastName(), employee.getFirstName(), employee.getBirthDate(), employee.getId());
		employee.setRegistrationNumber(registrationNumber);
		employeeRepository.save(employee);
		employeeModel.setId(employee.getId());
		
		return employeeModel;
	}
	
	/**
	 * Build registration number
	 * @param lastname
	 * @param firstname
	 * @param birthDate
	 * @param Id
	 * @return
	 */
	private String buildRegistrationNumber(String lastname, String firstname, Date birthDate, Long Id) {
		String registrationNumber = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		registrationNumber = "SA-" + lastname.substring(0,2).toUpperCase() + firstname.substring(0,2).toUpperCase() + simpleDateFormat.format(birthDate) + "-" + Id;
		
		return registrationNumber;
	}
}
