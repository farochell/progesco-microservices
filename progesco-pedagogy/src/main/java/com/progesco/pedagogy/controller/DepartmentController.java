/**
 * 
 */
package com.progesco.pedagogy.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.progesco.pedagogy.entity.Department;
import com.progesco.pedagogy.exception.DepartmentNotFoundException;
import com.progesco.pedagogy.service.DepartmentService;

/**
 * @author emile
 *
 */
@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value = "/departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@GetMapping("/department/{id}")
	public Resource<Department> retrieveSchoolyear(@PathVariable long id) {
		Optional<Department> department = departmentService.findDepartment(id);

		if (!department.isPresent())
			throw new DepartmentNotFoundException("id-" + id);

		Resource<Department> resource = new Resource<Department>(department.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllDepartments());

		resource.add(linkTo.withRel("all-departments"));

		return resource;
	}
	
	@PostMapping(value = "/department")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		Department resource = departmentService.addDepartment(department);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/department")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		Department resource = departmentService.updateDepartment(department);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
}
