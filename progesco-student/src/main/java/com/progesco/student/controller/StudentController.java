/**
 * 
 */
package com.progesco.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progesco.student.entity.Student;
import com.progesco.student.service.StudentService;

/**
 * @author emile
 *
 */
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/students")
	public List<Student> getAllSchoolyears() {
		return studentService.getAllStudents();
	}
}
