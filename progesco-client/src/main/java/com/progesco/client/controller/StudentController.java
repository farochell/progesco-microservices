/**
 * 
 */
package com.progesco.client.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.progesco.client.bundles.student.beans.Student;
import com.progesco.client.bundles.student.proxies.StudentProxy;

/**
 * @author emile
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentProxy studentProxy;
	
	@GetMapping(value ="/students")
	public @ResponseBody Iterable<Student> getAllStudents(){
		List<Student> students = studentProxy.getAll();
		
		return students;
	}
	
	@PostMapping(value = "/student")
	ResponseEntity<Student> addStudent(@RequestBody Student student) {
		 Student resource = studentProxy.addStudent(student);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			        .buildAndExpand(resource.getId()).toUri();

		return ResponseEntity.created(location).build(); 
		
	 }
}
