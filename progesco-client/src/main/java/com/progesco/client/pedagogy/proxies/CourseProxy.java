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

import com.progesco.client.pedagogy.beans.Course;
import com.progesco.client.constant.Constant;

/**
 * @author emile
 *
 */
@FeignClient(name = "progesco-pedagogy", url = Constant.URL_PEDAGOGY)
public interface CourseProxy {
	@GetMapping(value = "/courses")
	List<Course> getAllCourses();

	@GetMapping(value = "/course/{id}")
	Resource<Course> findCourse(@PathVariable("id") long id);

	@PostMapping(value = "/course")
	Course addCourse(@RequestBody Course course);
	
	@PutMapping(value = "/course")
	Course updateCourse(@RequestBody Course course);
}
