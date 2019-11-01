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

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile
 *
 */
@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value = "/departments")
	public List<Department> getAllDepartments(HttpServletRequest request) {
		return departmentService.getAllDepartments(request);
	}
	
	@GetMapping("/departments/{id}")
	public Resource<Department> retrieveDepartment(@PathVariable long id, HttpServletRequest request) {
		Department department = departmentService.retrieveDepartment(id, request);

		Resource<Department> resource = new Resource<Department>(department);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllDepartments(request));

		resource.add(linkTo.withRel("all-departments"));

		return resource;
	}
	
	@PostMapping(value = "/departments")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department, HttpServletRequest request) {
		Department resource = departmentService.addDepartment(department, request);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/departments")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department, HttpServletRequest request) {
		Department resource = departmentService.updateDepartment(department, request);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
}
