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

import com.progesco.pedagogy.entity.Speciality;
import com.progesco.pedagogy.exception.SpecialityNotFoundException;
import com.progesco.pedagogy.service.SpecialityService;

/**
 * @author emile
 *
 */
@RestController
public class SpecialityController {
	@Autowired
	private SpecialityService specialityService;
	
	@GetMapping(value = "/specialities")
	public List<Speciality> getAllSpecialities() {
		return specialityService.getAllSpecialities();
	}
	
	@GetMapping("/speciality/{id}")
	public Resource<Speciality> retrieveSpeciality(@PathVariable long id) {
		Optional<Speciality> speciality = specialityService.findSpeciality(id);

		if (!speciality.isPresent())
			throw new SpecialityNotFoundException("id-" + id);

		Resource<Speciality> resource = new Resource<Speciality>(speciality.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllSpecialities());

		resource.add(linkTo.withRel("all-specialities"));

		return resource;
	}
	
	@PostMapping(value = "/speciality")
	public ResponseEntity<Speciality> addSpeciality(@RequestBody Speciality speciality) {
		Speciality resource = specialityService.addSpeciality(speciality);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/speciality")
	public ResponseEntity<Speciality> updateSpeciality(@RequestBody Speciality speciality) {
		Speciality resource = specialityService.updateSpeciality(speciality);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
