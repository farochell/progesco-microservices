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

/**
 * @author emile
 *
 */
@FeignClient(name = "progesco-pedagogy", url = Constant.URL_PEDAGOGY)
public interface ClassroomProxy {
	@GetMapping(value = "/classrooms")
	List<Classroom> getAllClassrooms();

	@GetMapping(value = "/classroom/{id}")
	Resource<Classroom> findClassroom(@PathVariable("id") long id);

	@PostMapping(value = "/classroom")
	Classroom addClassroom(@RequestBody Classroom classroom);
	
	@PutMapping(value = "/classroom")
	Classroom updateClassroom(@RequestBody Classroom classroom);
}
