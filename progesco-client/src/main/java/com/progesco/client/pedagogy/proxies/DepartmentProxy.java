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
import com.progesco.client.pedagogy.beans.Department;

/**
 * @author emile
 *
 */
@FeignClient(name = "progesco-pedagogy", url = Constant.URL_PEDAGOGY)
public interface DepartmentProxy {
	@GetMapping(value = "/departments")
	List<Department> getAllDepartments();

	@GetMapping(value = "/department/{id}")
	Resource<Department> findDepartment(@PathVariable("id") long id);

	@PostMapping(value = "/department")
	Department addDepartment(@RequestBody Department department);
	
	@PutMapping(value = "/department")
	Department updateDepartment(@RequestBody Department department);
}
