/**
 * 
 */
package com.progesco.client.bundles.schoolyear.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.progesco.client.bundles.schoolyear.beans.SchoolYear;

/**
 * @author emile
 *
 */
@FeignClient(name = "progesco-zuul")
@RibbonClient(name = "progesco-schoolyear")
public interface SchoolYearProxy {
	@GetMapping(value = "/schoolyears")
	List<SchoolYear> getAllSchoolyears();

	@GetMapping(value = "/schoolyears/{id}")
	Resource<SchoolYear> retrieveSchoolyear(@PathVariable("id") long id);
	
	@GetMapping(value = "/schoolyears/activeyear")
	SchoolYear retrieveActiveSchoolYear();

	@PostMapping(value = "/schoolyears")
	SchoolYear addSchoolyear(@RequestBody SchoolYear schoolYear);
	
	@PutMapping(value = "/schoolyears/status/{id}/{status}")
	SchoolYear updateStatus(@PathVariable("id") long id, @PathVariable("status") Integer status);
	
}
