/**
 * 
 */
package com.progesco.client.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.progesco.client.bundles.schoolyear.beans.SchoolYear;
import com.progesco.client.bundles.schoolyear.proxies.SchoolYearProxy;

/**
 * @author emile
 *
 */
@RestController
public class Client {
	 @Autowired
	 private SchoolYearProxy schoolYearProxy;
	 
	 @RequestMapping("/schoolyears")
	 public @ResponseBody Iterable<SchoolYear> getSchoolyears(){
		 List<SchoolYear> schoolyears =  schoolYearProxy.getAllSchoolyears();
		 
		 return schoolyears;
	 }
	 
	 @GetMapping(value = "/schoolyear/{id}")
	 Resource<SchoolYear> retrieveSchoolyear(@PathVariable("id") long id) {
		 Resource<SchoolYear> resource = schoolYearProxy.retrieveSchoolyear(id);
		 return resource;
	 }	 
	 
	 @PostMapping(value="/schoolyear")
	 ResponseEntity<SchoolYear> addSchoolyear(@RequestBody SchoolYear schoolYear) {
		 SchoolYear resource = schoolYearProxy.addSchoolyear(schoolYear);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			        .buildAndExpand(resource.getId()).toUri();

		return ResponseEntity.created(location).build(); 
		
	 }
}
