/**
 * 
 */
package com.progesco.client.pedagogy.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.progesco.client.constant.Constant;
import com.progesco.client.pedagogy.beans.Classroom;
import com.progesco.client.pedagogy.beans.Course;
import com.progesco.client.pedagogy.beans.Department;
import com.progesco.client.pedagogy.beans.Level;
import com.progesco.client.pedagogy.beans.Program;
import com.progesco.client.pedagogy.beans.Session;
import com.progesco.client.pedagogy.beans.Speciality;

/**
 * @author emile.camara
 *
 */
@FeignClient(name = "progesco-pedagogy", url = Constant.URL_PEDAGOGY)
public interface PedagogyProxy {
	
	/**
	 * ******************************************** CLASSROOM *********************************************
	 */
	
	@GetMapping(value = "/classrooms")
	List<Classroom> getAllClassrooms();

	@GetMapping(value = "/classrooms/{id}")
	Resource<Classroom> findClassroom(@PathVariable("id") long id);

	@PostMapping(value = "/classrooms")
	Classroom addClassroom(@RequestBody Classroom classroom);
	
	@PutMapping(value = "/classrooms")
	Classroom updateClassroom(@RequestBody Classroom classroom);
	
	/**
	 * ******************************************** COURSE *********************************************
	 */
	
	@GetMapping(value = "/courses")
	List<Course> getAllCourses();

	@GetMapping(value = "/courses/{id}")
	Resource<Course> findCourse(@PathVariable("id") long id);

	@PostMapping(value = "/courses")
	Course addCourse(@RequestBody Course course);
	
	@PutMapping(value = "/courses")
	Course updateCourse(@RequestBody Course course);
	
	/**
	 * ****************************************** DEPARTMENT *******************************************
	 */
	
	@GetMapping(value = "/departments")
	List<Department> getAllDepartments();

	@GetMapping(value = "/departments/{id}")
	Resource<Department> findDepartment(@PathVariable("id") long id);

	@PostMapping(value = "/departments")
	Department addDepartment(@RequestBody Department department);
	
	@PutMapping(value = "/departments")
	Department updateDepartment(@RequestBody Department department);
	
	/**
	 * ******************************************* LEVEL **********************************************
	 */
	
	@GetMapping(value = "/levels")
	List<Level> getAllLevels();

	@GetMapping(value = "/levels/{id}")
	Resource<Level> findLevel(@PathVariable("id") long id);

	@PostMapping(value = "/levels")
	Level addLevel(@RequestBody Level level);
	
	@PutMapping(value = "/levels")
	Level updateLevel(@RequestBody Level level);
	
	/**
	 * ****************************************** PROGRAM *********************************************
	 */
	
	@GetMapping(value = "/programs")
	List<Program> getAllPrograms();

	@GetMapping(value = "/programs/{id}")
	Resource<Program> findProgram(@PathVariable("id") long id);

	@PostMapping(value = "/programs")
	Program addProgram(@RequestBody Program program);
	
	/**
	 * ***************************************** SPECIALITY ********************************************
	 */
	
	@GetMapping(value = "/specialities")
	List<Speciality> getAllSpecialities();

	@GetMapping(value = "/specialities/{id}")
	Resource<Speciality> findSpeciality(@PathVariable("id") long id);

	@PostMapping(value = "/specialities")
	Speciality addSpeciality(@RequestBody Speciality speciality);
	
	@PutMapping(value = "/specialities")
	Speciality updateSpeciality(@RequestBody Speciality speciality);
	
	/**
	 * ***************************************** SESSION ********************************************
	 */
	
	@GetMapping(value = "/sessions")
	List<Session> getAllSessions();

	@GetMapping(value = "/sessions/{id}")
	Resource<Session> findSession(@PathVariable("id") long id);

	@PostMapping(value = "/sessions")
	Session addSession(@RequestBody Session session);
	
	@PutMapping(value = "/sessions")
	Session updateSession(@RequestBody Session session);

}
