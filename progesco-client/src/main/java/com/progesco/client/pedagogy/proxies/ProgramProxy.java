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
import org.springframework.web.bind.annotation.RequestBody;

import com.progesco.client.constant.Constant;
import com.progesco.client.pedagogy.beans.Program;

/**
 * @author emile
 *
 */
@FeignClient(name = "progesco-pedagogy", url = Constant.URL_PEDAGOGY)
public interface ProgramProxy {
	@GetMapping(value = "/programs")
	List<Program> getAllPrograms();

	@GetMapping(value = "/program/{id}")
	Resource<Program> findProgram(@PathVariable("id") long id);

	@PostMapping(value = "/program")
	Program addProgram(@RequestBody Program program);
}
