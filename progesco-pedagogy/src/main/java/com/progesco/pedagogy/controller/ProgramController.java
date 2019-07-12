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

/**
 * @author emile
 *
 */
@RestController
public class ProgramController {
	@Autowired
	private ProgramService programService;
	
	@GetMapping(value = "/programs")
	public List<Program> getAllPrograms() {
		return programService.getAllPrograms();
	}
	
	@GetMapping("/program/{id}")
	public Resource<Program> retrieveProgram(@PathVariable long id) {
		Optional<Program> program = programService.findProgram(id);

		if (!program.isPresent())
			throw new ProgramNotFoundException("id-" + id);

		Resource<Program> resource = new Resource<Program>(program.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllPrograms());

		resource.add(linkTo.withRel("all-programs"));

		return resource;
	}
	
	@PostMapping(value = "/program")
	public ResponseEntity<Program> addProgram(@RequestBody Program program) {
		Program resource = programService.addProgram(program);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
