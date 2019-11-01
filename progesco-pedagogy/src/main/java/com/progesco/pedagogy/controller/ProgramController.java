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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.progesco.pedagogy.entity.Program;
import com.progesco.pedagogy.exception.ProgramNotFoundException;
import com.progesco.pedagogy.service.ProgramService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile
 *
 */
@RestController
public class ProgramController {
	@Autowired
	private ProgramService programService;
	
	@GetMapping(value = "/programs")
	public List<Program> getAllPrograms(HttpServletRequest request) {
		return programService.getAllPrograms(request);
	}
	
	@GetMapping("/programs/{id}")
	public Resource<Program> retrieveProgram(@PathVariable long id, HttpServletRequest request) {
        Program program = programService.retrieveProgram(id, request);

		Resource<Program> resource = new Resource<Program>(program);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllPrograms(request));

		resource.add(linkTo.withRel("all-programs"));

		return resource;
	}
	
	@PostMapping(value = "/programs")
	public ResponseEntity<Program> addProgram(@RequestBody Program program, HttpServletRequest request) {
		Program resource = programService.addProgram(program, request);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
