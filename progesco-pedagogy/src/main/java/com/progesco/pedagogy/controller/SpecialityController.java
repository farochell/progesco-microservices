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

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile
 *
 */
@RestController
public class SpecialityController {
	@Autowired
	private SpecialityService specialityService;
	
	@GetMapping(value = "/specialities")
	public List<Speciality> getAllSpecialities(HttpServletRequest request) {
		return specialityService.getAllSpecialities(request);
	}
	
	@GetMapping("/specialities/{id}")
	public Resource<Speciality> retrieveSpeciality(@PathVariable long id, HttpServletRequest request) {
		Speciality speciality = specialityService.retrieveSpeciality(id, request);

		Resource<Speciality> resource = new Resource<Speciality>(speciality);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllSpecialities(request));

		resource.add(linkTo.withRel("all-specialities"));

		return resource;
	}
	
	@PostMapping(value = "/specialities")
	public ResponseEntity<Speciality> addSpeciality(@RequestBody Speciality speciality, HttpServletRequest request) {
		Speciality resource = specialityService.addSpeciality(speciality, request);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/specialities")
	public ResponseEntity<Speciality> updateSpeciality(@RequestBody Speciality speciality, HttpServletRequest request) {
		Speciality resource = specialityService.updateSpeciality(speciality, request);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
