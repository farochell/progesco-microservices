/**
 * 
 */
package com.progesco.student.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.progesco.student.model.StudentCollectionModel;
import com.progesco.student.model.StudentModel;
import com.progesco.student.service.StudentService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile
 *
 */
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/students/page/{page}")
	public StudentCollectionModel getAllStudents(HttpServletRequest request, @PathVariable("page") int page) {
		PageRequest pageable = PageRequest.of(page - 1, 15);
		
		return studentService.getAllStudents(pageable, request);
	}
	
	@GetMapping("/students/{id}")
	public StudentModel retrieveStudent(HttpServletRequest request, @PathVariable long id) {
		return studentService.retrieveStudent(id, request);
	}
	
	@PostMapping(value = "/students")
	public ResponseEntity<StudentModel> addStudent(HttpServletRequest request, @RequestBody StudentModel studentModel) {
		StudentModel resource = studentService.addStudent(studentModel, request);
		return ResponseEntity.status(HttpStatus.OK).body(resource);
		
	}

	@PutMapping(value = "/students")
	public ResponseEntity<StudentModel> updateStudent(HttpServletRequest request, @RequestBody StudentModel studentModel) {
		StudentModel resource = studentService.updateStudent(studentModel, request);
		return ResponseEntity.status(HttpStatus.OK).body(resource);

	}
}
