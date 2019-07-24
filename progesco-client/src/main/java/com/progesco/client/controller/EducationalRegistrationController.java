/**
 * 
 */
package com.progesco.client.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.progesco.client.bundles.schooling.beans.EducationalRegistration;
import com.progesco.client.bundles.schooling.beans.EducationalRegistrationCollection;
import com.progesco.client.bundles.schooling.proxies.EducationalRegistrationProxy;
/**
 * @author emile.camara
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EducationalRegistrationController {
	@Autowired
	private EducationalRegistrationProxy educationalRegistrationProxy;
	
	@GetMapping(value ="/educationalregistrations/page/{page}")
	public EducationalRegistrationCollection getAllEducationalRegistrations(@PathVariable("page") int page) {
		
		return educationalRegistrationProxy.getAllEducationalRegistrations(page);
	}
	
	@GetMapping(value = "/educationalregistrations/{id}")
	Resource<EducationalRegistration> getEducationalRegistration(@PathVariable("id") long id) {
		Resource<EducationalRegistration> resource = educationalRegistrationProxy.retrieveEducationalRegistration(id);
		return resource;
	}
	
	@GetMapping("/educationalregistrations/student/{id}/registrations")
	List<EducationalRegistration> getStudentEducationalRegistrations(@PathVariable("id") long id) {
		return educationalRegistrationProxy.getStudentEducationalRegistrations(id);
	}
	
	@PostMapping(value = "/educationalregistrations")
	ResponseEntity<EducationalRegistration> addEducationalRegistration(@RequestBody EducationalRegistration educationalRegistration) {
		 EducationalRegistration resource = educationalRegistrationProxy.addEducationalRegistration(educationalRegistration);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			        .buildAndExpand(resource.getId()).toUri();

		return ResponseEntity.created(location).build(); 
		
	 }
	
	@PutMapping(value = "/educationalregistrations")
	ResponseEntity<EducationalRegistration> updateEducationalRegistration(@RequestBody EducationalRegistration educationalRegistration) {
		 EducationalRegistration resource = educationalRegistrationProxy.updateEducationalRegistration(educationalRegistration);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			        .buildAndExpand(resource.getId()).toUri();

		return ResponseEntity.created(location).build(); 
		
	 }
}
