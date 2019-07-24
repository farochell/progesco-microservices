/**
 * 
 */
package com.progesco.client.bundles.schooling.proxies;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.progesco.client.bundles.schooling.beans.EducationalRegistration;
import com.progesco.client.bundles.schooling.beans.EducationalRegistrationCollection;
import com.progesco.client.constant.Constant;

/**
 * @author emile.camara
 *
 */
@FeignClient(name = "progesco-schooling", url = Constant.URL_SCHOOLING)
public interface EducationalRegistrationProxy {
	@GetMapping(value = "/educationalregistrations/page/{page}")
	EducationalRegistrationCollection getAllEducationalRegistrations(@PathVariable("page") int page);

	@GetMapping(value = "/educationalregistrations/{id}")
	Resource<EducationalRegistration> retrieveEducationalRegistration(@PathVariable("id") long id);
	
	@GetMapping("/educationalregistrations/student/{id}/registrations")
	List<EducationalRegistration> getStudentEducationalRegistrations(@PathVariable("id") long id);
	
	@PostMapping(value = "/educationalregistrations")
	EducationalRegistration addEducationalRegistration(@RequestBody EducationalRegistration educationalRegistration);
	
	@PutMapping(value = "/educationalregistrations")
	EducationalRegistration updateEducationalRegistration(@RequestBody EducationalRegistration educationalRegistration);
}
