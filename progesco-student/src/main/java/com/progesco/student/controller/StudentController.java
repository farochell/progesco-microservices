/**
 * 
 */
package com.progesco.student.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.progesco.student.model.StudentCollectionModel;
import com.progesco.student.model.StudentModel;
import com.progesco.student.service.StudentService;

/**
 * @author emile
 *
 */
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/students/page/{page}")
	public StudentCollectionModel getAllStudents(@PathVariable("page") int page) {
		PageRequest pageable = PageRequest.of(page - 1, 15);
		
		return studentService.getAllStudents(pageable);
	}
	
	@GetMapping("/students/{id}")
	public StudentModel retrieveStudent(@PathVariable long id) {
		return studentService.retrieveStudent(id);
	}
	
	@PostMapping(value = "/students")
	public ResponseEntity<StudentModel> addStudent(@RequestBody StudentModel studentModel) {
		StudentModel resource = studentService.addStudent(studentModel);
		return ResponseEntity.status(HttpStatus.OK).body(resource);
		
	}
}
