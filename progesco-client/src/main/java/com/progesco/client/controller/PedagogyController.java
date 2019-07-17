/**
 * 
 */
package com.progesco.client.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.progesco.client.pedagogy.beans.Classroom;
import com.progesco.client.pedagogy.beans.Course;
import com.progesco.client.pedagogy.beans.Department;
import com.progesco.client.pedagogy.beans.Level;
import com.progesco.client.pedagogy.beans.Program;
import com.progesco.client.pedagogy.beans.Speciality;
import com.progesco.client.pedagogy.proxies.PedagogyProxy;

/**
 * @author emile
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PedagogyController {
	@Autowired
	PedagogyProxy pedagogyProxy;

	@GetMapping("/courses")
	public @ResponseBody Iterable<Course> getCourses() {
		List<Course> courses = pedagogyProxy.getAllCourses();

		return courses;
	}
	
	@GetMapping("/departments")
	public @ResponseBody Iterable<Department> getDepartments() {
		List<Department> departments = pedagogyProxy.getAllDepartments();

		return departments;
	}
	
	@GetMapping("/levels")
	public @ResponseBody Iterable<Level> getLevels() {
		List<Level> levels = pedagogyProxy.getAllLevels();

		return levels;
	}
	
	@GetMapping("/programs")
	public @ResponseBody Iterable<Program> getPrograms() {
		List<Program> programs = pedagogyProxy.getAllPrograms();

		return programs;
	}
	
	@GetMapping("/specialities")
	public @ResponseBody Iterable<Speciality> getSpecialities() {
		List<Speciality> specialities = pedagogyProxy.getAllSpecialities();

		return specialities;
	}

	@GetMapping(value = "/courses/{id}")
	Resource<Course> retrieveCourse(@PathVariable("id") long id) {
		Resource<Course> resource = pedagogyProxy.findCourse(id);
		return resource;
	}
	
	@GetMapping(value = "/departments/{id}")
	Resource<Department> retrieveDepartment(@PathVariable("id") long id) {
		Resource<Department> resource = pedagogyProxy.findDepartment(id);
		return resource;
	}
	
	@GetMapping(value = "/levels/{id}")
	Resource<Level> retrieveLevel(@PathVariable("id") long id) {
		Resource<Level> resource = pedagogyProxy.findLevel(id);
		return resource;
	}
	
	@GetMapping(value = "/programs/{id}")
	Resource<Program> retrieveProgram(@PathVariable("id") long id) {
		Resource<Program> resource = pedagogyProxy.findProgram(id);
		return resource;
	}
	
	@GetMapping(value = "/specialities/{id}")
	Resource<Speciality> retrieveSpeciality(@PathVariable("id") long id) {
		Resource<Speciality> resource = pedagogyProxy.findSpeciality(id);
		return resource;
	}
	
	@GetMapping(value = "/classrooms/{id}")
	Resource<Classroom> retrieveClassroom(@PathVariable("id") long id) {
		Resource<Classroom> resource = pedagogyProxy.findClassroom(id);
		return resource;
	}
	
	@GetMapping("/classrooms")
	public @ResponseBody Iterable<Classroom> getAllClassrooms() {
		List<Classroom> classrooms = pedagogyProxy.getAllClassrooms();

		return classrooms;
	}
	
	/********************************************************************************************************************/
	/********************************************************* ADD ******************************************************/
	/********************************************************************************************************************/
	

	@PostMapping(value = "/courses")
	ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course resource = pedagogyProxy.addCourse(course);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PostMapping(value = "/departments")
	ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		Department resource = pedagogyProxy.addDepartment(department);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PostMapping(value = "/levels")
	ResponseEntity<Level> addLevel(@RequestBody Level level) {
		Level resource = pedagogyProxy.addLevel(level);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PostMapping(value = "/specialities")
	ResponseEntity<Speciality> addSpeciality(@RequestBody Speciality speciality) {
		Speciality resource = pedagogyProxy.addSpeciality(speciality);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PostMapping(value = "/classrooms")
	ResponseEntity<Classroom> addClassroom(@RequestBody Classroom classroom) {
		Classroom resource = pedagogyProxy.addClassroom(classroom);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	/********************************************************************************************************************/
	/****************************************************** UPDATE ******************************************************/
	/********************************************************************************************************************/
	
	@PutMapping(value = "/departments")
	ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		Department resource = pedagogyProxy.updateDepartment(department);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping(value = "/levels")
	ResponseEntity<Level> updateLevel(@RequestBody Level level) {
		Level resource = pedagogyProxy.updateLevel(level);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping(value = "/specialities")
	ResponseEntity<Speciality> updateSpeciality(@RequestBody Speciality speciality) {
		Speciality resource = pedagogyProxy.updateSpeciality(speciality);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping(value = "/courses")
	ResponseEntity<Course> updateCourse(@RequestBody Course course) {
		Course resource = pedagogyProxy.updateCourse(course);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping(value = "/classrooms")
	ResponseEntity<Classroom> updateClassroom(@RequestBody Classroom classroom) {
		Classroom resource = pedagogyProxy.updateClassroom(classroom);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
