/**
 * 
 */
package com.progesco.schoolYear.controller;

import java.net.URI;
import java.net.URISyntaxException;
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

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import com.progesco.schoolYear.exception.SchoolYearNotFoundException;
import com.progesco.schoolYear.model.SchoolYear;
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
    public List<SchoolYear> getAllSchoolyears(){
		return schoolYearService.getAllSchoolyears();		
	}
	
	@GetMapping("/schoolyear/{id}")
	  public Resource<SchoolYear> retrieveSchoolyear(@PathVariable long id) {
	    Optional<SchoolYear> schoolYear = schoolYearService.retrieveSchoolYear(id);

	    if (!schoolYear.isPresent())
	      throw new SchoolYearNotFoundException("id-" + id);

	    Resource<SchoolYear> resource = new Resource<SchoolYear>(schoolYear.get());

	    ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllSchoolyears());

	    resource.add(linkTo.withRel("all-schoolyears"));

	    return resource;
	  }
	
	@PostMapping(value="/schoolyear")
	public ResponseEntity<SchoolYear> addSchoolYear(@RequestBody SchoolYear schoolYear) throws URISyntaxException {
		SchoolYear resource = schoolYearService.addSchoolYear(schoolYear);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(resource);	
	}
}
