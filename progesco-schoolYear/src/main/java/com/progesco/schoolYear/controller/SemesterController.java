/**
 * 
 */
package com.progesco.schoolYear.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

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


import com.progesco.schoolYear.model.SemesterModel;
import com.progesco.schoolYear.service.SemesterService;



/**
 * @author emile
 *
 */
@RestController
public class SemesterController {
   
	@Autowired
	private SemesterService semesterService;
	
	@GetMapping(value = "/semesters")
	public List<SemesterModel> getAllSemesters() {
		return semesterService.getAllSemesters();
	}
	
	@GetMapping("/semester/{id}")
	public Resource<SemesterModel> retrieveSemester(@PathVariable long id) {
		SemesterModel semester = semesterService.findSemester(id);

		Resource<SemesterModel> resource = new Resource<SemesterModel>(semester);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllSemesters());

		resource.add(linkTo.withRel("all-courses"));

		return resource;
	}
	
	@PostMapping(value = "/semester")
	public ResponseEntity<SemesterModel> addSemester(@RequestBody SemesterModel courseModel) {
		SemesterModel resource = semesterService.addSemester(courseModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/semester")
	public ResponseEntity<SemesterModel> updateSemester(@RequestBody SemesterModel courseModel) {
		SemesterModel resource = semesterService.updateSemester(courseModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
