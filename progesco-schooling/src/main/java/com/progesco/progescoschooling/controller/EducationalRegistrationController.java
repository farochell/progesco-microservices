/**
 * 
 */
package com.progesco.progescoschooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.progesco.progescoschooling.Service.EducationalRegistrationService;
import com.progesco.progescoschooling.model.EducationalRegistrationCollectionModel;
import com.progesco.progescoschooling.model.EducationalRegistrationModel;

/**
 * @author emile.camara
 *
 */
@RestController
public class EducationalRegistrationController {
	@Autowired
	private EducationalRegistrationService educationalRegistrationService;
	
	@GetMapping(value = "/educationalregistrations/page/{page}")
	public EducationalRegistrationCollectionModel getAllEducationalRegistrations(@PathVariable("page") int page) {
		PageRequest pageable = PageRequest.of(page - 1, 15);
		
		return educationalRegistrationService.getAllEducationalRegistrations(pageable);
	}
	
	@GetMapping(value = "/educationalregistrations/page/{page}/status/{status}")
	public EducationalRegistrationCollectionModel getEducationalRegistrationsByStatus(@PathVariable("page") int page, @PathVariable("status") int status) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
		
		return educationalRegistrationService.getEducationalRegistrationsByStatus(pageable, status);
	}
	
	@GetMapping("/educationalregistrations/{id}")
	public EducationalRegistrationModel retrieveEducationalRegistration(@PathVariable long id) {
		return educationalRegistrationService.retrieveEducationalRegistration(id);
	}
	
	@GetMapping("/educationalregistrations/student/{id}/registrations")
	public List<EducationalRegistrationModel> getStudentEducationalRegistrations(@PathVariable long id) {
		return educationalRegistrationService.getStudentEducationalRegistrations(id);
	}
	
	@PostMapping(value = "/educationalregistrations")
	public ResponseEntity<EducationalRegistrationModel> addEducationalRegistration(@RequestBody EducationalRegistrationModel educationalRegistrationModel) {
		EducationalRegistrationModel resource = educationalRegistrationService.addEducationalRegistration(educationalRegistrationModel);
		return ResponseEntity.status(HttpStatus.OK).body(resource);		
	}
	
	@PutMapping(value = "/educationalregistrations")
	public ResponseEntity<EducationalRegistrationModel> updateEducationalRegistration(@RequestBody EducationalRegistrationModel educationalRegistrationModel) {
		EducationalRegistrationModel resource = educationalRegistrationService.updateEducationalRegistration(educationalRegistrationModel);
		return ResponseEntity.status(HttpStatus.OK).body(resource);		
	}
}
