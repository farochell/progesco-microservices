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
import com.progesco.pedagogy.entity.ClassroomSemesterCourse;
import com.progesco.pedagogy.model.ClassroomSemesterCourseModel;
import com.progesco.pedagogy.service.ClassroomSemesterCourseService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile.camara
 *
 */
@RestController
public class ClassroomSemesterCourseController {
	@Autowired
	private ClassroomSemesterCourseService classroomSemesterCourseService;
	
	@GetMapping("/classroomsemestercourses")
	public List<ClassroomSemesterCourseModel> getAllClassroomSemesterCourses(HttpServletRequest request) {
		return classroomSemesterCourseService.getAllClassroomSemesterCourses(request);
	}
	
	@GetMapping("/classroomsemestercourses/course/{id}")
	public List<ClassroomSemesterCourseModel> getAllClassroomSemesterCoursesByCourse(@PathVariable long id, HttpServletRequest request) {
		return classroomSemesterCourseService.getAllClassroomSemesterCoursesByCourse(id, request);
	}
	
	@GetMapping("/classroomsemestercourses/classroomsemester/{id}")
	public List<ClassroomSemesterCourseModel> getAllClassroomSemesterCoursesByClassroomSemester(@PathVariable long id, HttpServletRequest request) {
		return classroomSemesterCourseService.getAllClassroomSemesterCoursesByClassroomSemester(id, request);
	}
	
	@GetMapping("/classroomsemestercourses/{id}")
	public Resource<ClassroomSemesterCourse> retrieveCourse(@PathVariable long id, HttpServletRequest request) {
		ClassroomSemesterCourse course = classroomSemesterCourseService.retrieveCourse(id, request);
		Resource<ClassroomSemesterCourse> resource = new Resource<ClassroomSemesterCourse>(course);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllClassroomSemesterCourses(request));

		resource.add(linkTo.withRel("all-classroomsemestercourses"));

		return resource;
	}
	
	@PostMapping(value = "/classroomsemestercourses")
	public ResponseEntity<ClassroomSemesterCourseModel> addClassroom(@RequestBody ClassroomSemesterCourseModel classroomSemesterCourseModel, HttpServletRequest request) {
		ClassroomSemesterCourseModel resource = classroomSemesterCourseService.addClassroomSemesterCourse(classroomSemesterCourseModel, request);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/classroomsemestercourses")
	public ResponseEntity<ClassroomSemesterCourseModel> updateClassroomSemesterCourse(@RequestBody ClassroomSemesterCourseModel classroomSemesterCourseModel, HttpServletRequest request) {
		ClassroomSemesterCourseModel resource = classroomSemesterCourseService.updateClassroomSemesterCourse(classroomSemesterCourseModel, request);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
