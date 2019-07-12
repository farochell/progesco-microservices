/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Department;
import com.progesco.pedagogy.repository.DepartmentRepository;

/**
 * @author emile
 *
 */
@Service("DepartmentService")
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	/**
	 * Return all departments
	 * @return
	 */
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	/**
	 * Return department by id
	 * @param id
	 * @return
	 */
	public Optional<Department> findDepartment(Long id) {
		return departmentRepository.findById(id);
	}
	
	/**
	 * Add a new department
	 * @param department
	 * @return
	 */
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	/**
	 * Add a new department
	 * @param department
	 * @return
	 */
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}
}
