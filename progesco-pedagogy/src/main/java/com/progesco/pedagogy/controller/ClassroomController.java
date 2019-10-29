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

import com.progesco.pedagogy.entity.Classroom;
import com.progesco.pedagogy.model.ClassroomModel;
import com.progesco.pedagogy.service.ClassroomService;

/**
 * @author emile
 *
 */
@RestController
public class ClassroomController {
	private final ClassroomService classroomService;

	public ClassroomController(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}

	@GetMapping(value = "/classrooms")
	public List<ClassroomModel> getAllClassrooms() {
		return classroomService.getAllClassrooms();
	}
	
	@GetMapping("/classrooms/{id}")
	public Resource<Classroom> retrieveClassroom(@PathVariable long id) {
		Optional<Classroom> classroom = classroomService.findClassroom(id);

		Resource<Classroom> resource = new Resource<Classroom>(classroom.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllClassrooms());

		resource.add(linkTo.withRel("all-classrooms"));

		return resource;
	}
	
	@PostMapping(value = "/classrooms")
	public ResponseEntity<ClassroomModel> addClassroom(@RequestBody ClassroomModel classroomModel) {
		ClassroomModel resource = classroomService.addClassroom(classroomModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/classrooms")
	public ResponseEntity<ClassroomModel> updateClassroom(@RequestBody ClassroomModel classroomModel) {
		ClassroomModel resource = classroomService.updateClassroom(classroomModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
