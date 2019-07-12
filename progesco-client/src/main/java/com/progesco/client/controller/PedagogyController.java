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
import com.progesco.client.pedagogy.proxies.ClassroomProxy;
import com.progesco.client.pedagogy.proxies.CourseProxy;
import com.progesco.client.pedagogy.proxies.DepartmentProxy;
import com.progesco.client.pedagogy.proxies.LevelProxy;
import com.progesco.client.pedagogy.proxies.ProgramProxy;
import com.progesco.client.pedagogy.proxies.SpecialityProxy;

/**
 * @author emile
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PedagogyController {
	@Autowired
	CourseProxy courseProxy;
	
	@Autowired
	DepartmentProxy departmentProxy;
	
	@Autowired
	LevelProxy levelProxy;
	
	@Autowired
	ProgramProxy programProxy;
	
	@Autowired
	SpecialityProxy specialityProxy;
	
	@Autowired
	ClassroomProxy classroomProxy;

	@GetMapping("/courses")
	public @ResponseBody Iterable<Course> getCourses() {
		List<Course> courses = courseProxy.getAllCourses();

		return courses;
	}
	
	@GetMapping("/departments")
	public @ResponseBody Iterable<Department> getDepartments() {
		List<Department> departments = departmentProxy.getAllDepartments();

		return departments;
	}
	
	@GetMapping("/levels")
	public @ResponseBody Iterable<Level> getLevels() {
		List<Level> levels = levelProxy.getAllLevels();

		return levels;
	}
	
	@GetMapping("/programs")
	public @ResponseBody Iterable<Program> getPrograms() {
		List<Program> programs = programProxy.getAllPrograms();

		return programs;
	}
	
	@GetMapping("/specialities")
	public @ResponseBody Iterable<Speciality> getSpecialities() {
		List<Speciality> specialities = specialityProxy.getAllSpecialities();

		return specialities;
	}

	@GetMapping(value = "/course/{id}")
	Resource<Course> retrieveCourse(@PathVariable("id") long id) {
		Resource<Course> resource = courseProxy.findCourse(id);
		return resource;
	}
	
	@GetMapping(value = "/department/{id}")
	Resource<Department> retrieveDepartment(@PathVariable("id") long id) {
		Resource<Department> resource = departmentProxy.findDepartment(id);
		return resource;
	}
	
	@GetMapping(value = "/level/{id}")
	Resource<Level> retrieveLevel(@PathVariable("id") long id) {
		Resource<Level> resource = levelProxy.findLevel(id);
		return resource;
	}
	
	@GetMapping(value = "/program/{id}")
	Resource<Program> retrieveProgram(@PathVariable("id") long id) {
		Resource<Program> resource = programProxy.findProgram(id);
		return resource;
	}
	
	@GetMapping(value = "/speciality/{id}")
	Resource<Speciality> retrieveSpeciality(@PathVariable("id") long id) {
		Resource<Speciality> resource = specialityProxy.findSpeciality(id);
		return resource;
	}
	
	@GetMapping(value = "/classroom/{id}")
	Resource<Classroom> retrieveClassroom(@PathVariable("id") long id) {
		Resource<Classroom> resource = classroomProxy.findClassroom(id);
		return resource;
	}
	
	@GetMapping("/classrooms")
	public @ResponseBody Iterable<Classroom> getAllClassrooms() {
		List<Classroom> classrooms = classroomProxy.getAllClassrooms();

		return classrooms;
	}
	
	/********************************************************************************************************************/
	/********************************************************* ADD ******************************************************/
	/********************************************************************************************************************/
	

	@PostMapping(value = "/course")
	ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course resource = courseProxy.addCourse(course);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PostMapping(value = "/department")
	ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		Department resource = departmentProxy.addDepartment(department);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PostMapping(value = "/level")
	ResponseEntity<Level> addLevel(@RequestBody Level level) {
		Level resource = levelProxy.addLevel(level);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PostMapping(value = "/speciality")
	ResponseEntity<Speciality> addSpeciality(@RequestBody Speciality speciality) {
		Speciality resource = specialityProxy.addSpeciality(speciality);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PostMapping(value = "/classroom")
	ResponseEntity<Classroom> addClassroom(@RequestBody Classroom classroom) {
		Classroom resource = classroomProxy.addClassroom(classroom);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	/********************************************************************************************************************/
	/****************************************************** UPDATE ******************************************************/
	/********************************************************************************************************************/
	
	@PutMapping(value = "/department")
	ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		Department resource = departmentProxy.updateDepartment(department);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping(value = "/level")
	ResponseEntity<Level> updateLevel(@RequestBody Level level) {
		Level resource = levelProxy.updateLevel(level);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping(value = "/speciality")
	ResponseEntity<Speciality> updateSpeciality(@RequestBody Speciality speciality) {
		Speciality resource = specialityProxy.updateSpeciality(speciality);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping(value = "/course")
	ResponseEntity<Course> updateCourse(@RequestBody Course course) {
		Course resource = courseProxy.updateCourse(course);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping(value = "/classroom")
	ResponseEntity<Classroom> updateClassroom(@RequestBody Classroom classroom) {
		Classroom resource = classroomProxy.updateClassroom(classroom);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
