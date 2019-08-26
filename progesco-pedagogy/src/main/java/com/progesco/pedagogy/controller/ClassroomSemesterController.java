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

import com.progesco.pedagogy.entity.ClassroomSemester;
import com.progesco.pedagogy.model.ClassroomSemesterModel;
import com.progesco.pedagogy.service.ClassroomSemesterService;

/**
 * @author emile.camara
 *
 */
@RestController
public class ClassroomSemesterController {
	@Autowired
	private ClassroomSemesterService classroomSemesterService;
	
	@GetMapping("/classroomsemesters")
	public List<ClassroomSemesterModel> getAllClassroomSemesters() {
		return classroomSemesterService.getAllClassroomSemesters();
	}
	
	@GetMapping("/classroomsemesters/classroom/{id}")
	public List<ClassroomSemesterModel> getAllClassroomSemestersByClassroom(@PathVariable long id) {
		return classroomSemesterService.getAllClassroomSemestersByClassroom(id);
	}
	
	@GetMapping("/classroomsemesters/{id}")
	public Resource<ClassroomSemester> retrieveClassroomSemester(@PathVariable long id) {
		Optional<ClassroomSemester> classroomsemester = classroomSemesterService.findClassroomSemester(id);

		Resource<ClassroomSemester> resource = new Resource<ClassroomSemester>(classroomsemester.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllClassroomSemesters());

		resource.add(linkTo.withRel("all-classroomsemesters"));

		return resource;
	}
	
	@PostMapping(value = "/classroomsemesters")
	public ResponseEntity<ClassroomSemesterModel> addClassroomSemester(@RequestBody ClassroomSemesterModel classroomSemesterModel) {
		ClassroomSemesterModel resource = classroomSemesterService.addClassroomSemester(classroomSemesterModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/classroomsemesters")
	public ResponseEntity<ClassroomSemesterModel> updateClassroomSemester(@RequestBody ClassroomSemesterModel classroomSemesterModel) {
		ClassroomSemesterModel resource = classroomSemesterService.updateClassroomSemester(classroomSemesterModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
