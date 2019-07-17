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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.progesco.pedagogy.entity.Level;
import com.progesco.pedagogy.exception.LevelNotFoundException;
import com.progesco.pedagogy.service.LevelService;

/**
 * @author emile
 *
 */
@RestController
public class LevelController {
	@Autowired
	private LevelService levelService;
	
	@GetMapping(value = "/levels")
	public List<Level> getAllLevels() {
		return levelService.getAllLevels();
	}
	
	@GetMapping("/levels/{id}")
	public Resource<Level> retrieveSchoolyear(@PathVariable long id) {
		Optional<Level> level = levelService.findLevel(id);

		if (!level.isPresent())
			throw new LevelNotFoundException("id-" + id);

		Resource<Level> resource = new Resource<Level>(level.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllLevels());

		resource.add(linkTo.withRel("all-levels"));

		return resource;
	}
	
	@PostMapping(value = "/levels")
	public ResponseEntity<Level> addLevel(@RequestBody Level level) {
		Level resource = levelService.addLevel(level);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	
	@PutMapping(value = "/levels")
	public ResponseEntity<Level> updateLevel(@RequestBody Level level) {
		Level resource = levelService.updateLevel(level);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
}
