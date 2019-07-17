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

import com.progesco.pedagogy.model.CourseModel;
import com.progesco.pedagogy.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping(value = "/courses")
	public List<CourseModel> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/courses/{id}")
	public Resource<CourseModel> retrieveCourse(@PathVariable long id) {
		CourseModel course = courseService.findCourse(id);

		Resource<CourseModel> resource = new Resource<CourseModel>(course);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllCourses());

		resource.add(linkTo.withRel("all-courses"));

		return resource;
	}
	
	@PostMapping(value = "/courses")
	public ResponseEntity<CourseModel> addCourse(@RequestBody CourseModel courseModel) {
		CourseModel resource = courseService.addCourse(courseModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/courses")
	public ResponseEntity<CourseModel> updateCourse(@RequestBody CourseModel courseModel) {
		CourseModel resource = courseService.updateCourse(courseModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
