/**
 * 
 */
package com.progesco.client.bundles.student.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.progesco.client.bundles.student.beans.Student;
import com.progesco.client.bundles.student.beans.StudentCollection;
import com.progesco.client.constant.Constant;

/**
 * @author emile
 *
 */
@FeignClient(name = "progesco-student", url = Constant.URL_STUDENT)
public interface StudentProxy {
	@GetMapping(value = "/students/page/{page}")
	StudentCollection getAllStudents(@PathVariable("page") int page);
	
	@GetMapping(value = "/students/{id}")
	Resource<Student> getStudent(@PathVariable("id") long id);
	
	@PostMapping(value = "/students")
	Student addStudent(@RequestBody Student student);
	
	@PutMapping(value = "/students")
	Student updateStudent(@RequestBody Student student);
	
}
