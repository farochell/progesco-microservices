/**
 * 
 */
package com.progesco.pedagogy.controller;

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

import com.progesco.pedagogy.model.ClassroomModel;
import com.progesco.pedagogy.service.ClassroomService;

/**
 * @author emile
 *
 */
@RestController
public class ClassroomController {
	@Autowired
	private ClassroomService classroomService;
	
	@GetMapping(value = "/classrooms")
	public List<ClassroomModel> getAllClassrooms() {
		return classroomService.getAllClassrooms();
	}
	
	@GetMapping("/classroom/{id}")
	public Resource<ClassroomModel> retrieveClassroom(@PathVariable long id) {
		ClassroomModel course = classroomService.findClassroom(id);

		Resource<ClassroomModel> resource = new Resource<ClassroomModel>(course);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllClassrooms());

		resource.add(linkTo.withRel("all-courses"));

		return resource;
	}
	
	@PostMapping(value = "/classroom")
	public ResponseEntity<ClassroomModel> addClassroom(@RequestBody ClassroomModel courseModel) {
		ClassroomModel resource = classroomService.addClassroom(courseModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/classroom")
	public ResponseEntity<ClassroomModel> updateClassroom(@RequestBody ClassroomModel courseModel) {
		ClassroomModel resource = classroomService.updateClassroom(courseModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
