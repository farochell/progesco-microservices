/**
 * 
 */
package com.progesco.client.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.progesco.client.pedagogy.beans.Group;
import com.progesco.client.pedagogy.beans.GroupCollection;
import com.progesco.client.pedagogy.beans.Level;
import com.progesco.client.pedagogy.beans.Program;
import com.progesco.client.pedagogy.beans.Session;
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
		return pedagogyProxy.getAllCourses();
	}
	
	@GetMapping("/departments")
	public @ResponseBody Iterable<Department> getDepartments() {
		return pedagogyProxy.getAllDepartments();
	}
	
	@GetMapping("/levels")
	public @ResponseBody Iterable<Level> getLevels() {
		return pedagogyProxy.getAllLevels();
	}
	
	@GetMapping("/programs")
	public @ResponseBody Iterable<Program> getPrograms() {
		return pedagogyProxy.getAllPrograms();
	}
	
	@GetMapping("/specialities")
	public @ResponseBody Iterable<Speciality> getSpecialities() {
		return pedagogyProxy.getAllSpecialities();
	}

	@GetMapping(value = "/courses/{id}")
	Resource<Course> retrieveCourse(@PathVariable("id") long id) {
		return pedagogyProxy.findCourse(id);
	}
	
	@GetMapping(value = "/departments/{id}")
	Resource<Department> retrieveDepartment(@PathVariable("id") long id) {
		return pedagogyProxy.findDepartment(id);
	}
	
	@GetMapping(value = "/levels/{id}")
	Resource<Level> retrieveLevel(@PathVariable("id") long id) {
		return pedagogyProxy.findLevel(id);
	}
	
	@GetMapping(value = "/programs/{id}")
	Resource<Program> retrieveProgram(@PathVariable("id") long id) {
		return pedagogyProxy.findProgram(id);
	}
	
	@GetMapping(value = "/specialities/{id}")
	Resource<Speciality> retrieveSpeciality(@PathVariable("id") long id) {
		return pedagogyProxy.findSpeciality(id);
	}
	
	@GetMapping(value = "/classrooms/{id}")
	Resource<Classroom> retrieveClassroom(@PathVariable("id") long id) {
		return pedagogyProxy.findClassroom(id);
	}
	
	@GetMapping("/classrooms")
	public @ResponseBody Iterable<Classroom> getAllClassrooms() {
		return pedagogyProxy.getAllClassrooms();
	}
	
	@GetMapping("/sessions")
	public @ResponseBody Iterable<Session> getAllSessions() {
        return  pedagogyProxy.getAllSessions();
	}
	
	@GetMapping(value = "/groups/page/{page}")
	public GroupCollection getAllGroups(@PathVariable("page") int page) {
		return pedagogyProxy.getAllGroups(page);
	}
	
	@GetMapping(value = "/groups/{id}")
	public Resource<Group> findGroup(@PathVariable("id") long id) {
		return pedagogyProxy.findGroup(id);
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
	
	@PostMapping(value = "/sessions")
	ResponseEntity<Session> addSession(@RequestBody Session session) {
		Session resource = pedagogyProxy.addSession(session);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PostMapping(value = "/groups")
	ResponseEntity<Group> addGroup(@RequestBody Group group) {
		Group resource = pedagogyProxy.addGroup(group);

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
	
	@PutMapping(value = "/sessions")
	ResponseEntity<Session> updateSession(@RequestBody Session session) {
		Session resource = pedagogyProxy.updateSession(session);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping(value = "/groups")
	ResponseEntity<Group> updateGroup(@RequestBody Group group) {
		Group resource = pedagogyProxy.updateGroup(group);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	/********************************************************************************************************************/
	/****************************************************** DELETE ******************************************************/
	/********************************************************************************************************************/
	
	@DeleteMapping(value = "/groups/{id}") 
	public void deleteGroup(@PathVariable("id") long id) {
		pedagogyProxy.deleteGroup(id);
	}
}
