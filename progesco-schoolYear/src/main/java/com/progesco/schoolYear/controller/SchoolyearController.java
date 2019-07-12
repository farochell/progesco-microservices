/**
 * 
 */
package com.progesco.schoolYear.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.progesco.schoolYear.entity.SchoolYear;
import com.progesco.schoolYear.exception.SchoolYearNotFoundException;
import com.progesco.schoolYear.service.SchoolYearService;

/**
 * @author emile
 *
 */
@RestController
public class SchoolyearController {

	@Autowired
	private SchoolYearService schoolYearService;

	@GetMapping(value = "/schoolyears")
	public List<SchoolYear> getAllSchoolyears() {
		return schoolYearService.getAllSchoolyears();
	}

	@GetMapping("/schoolyears/{id}")
	public Resource<SchoolYear> retrieveSchoolyear(@PathVariable long id) {
		Optional<SchoolYear> schoolYear = schoolYearService.retrieveSchoolYear(id);

		if (!schoolYear.isPresent())
			throw new SchoolYearNotFoundException("id-" + id);

		Resource<SchoolYear> resource = new Resource<SchoolYear>(schoolYear.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllSchoolyears());

		resource.add(linkTo.withRel("all-schoolyears"));

		return resource;
	}
	
	@GetMapping("/schoolyears/activeyear")
	public Optional<SchoolYear> retrieveActiveSchoolYear() {
		return schoolYearService.retrieveActiveSchoolYear();
	}

	@PostMapping(value = "/schoolyears")
	public ResponseEntity<Object> addSchoolYear(@Valid @RequestBody SchoolYear schoolYear) throws URISyntaxException {
		SchoolYear resource = schoolYearService.addSchoolYear(schoolYear);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(resource.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value = "/schoolyears/status/{id}/{status}")
	public ResponseEntity<SchoolYear> updateStatus(@PathVariable long id, @PathVariable Integer status) {
		SchoolYear resource = schoolYearService.updateStatus(id, status);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
