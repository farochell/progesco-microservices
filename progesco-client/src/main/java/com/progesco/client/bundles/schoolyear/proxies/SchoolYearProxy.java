/**
 * 
 */
package com.progesco.client.bundles.schoolyear.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.progesco.client.bundles.schoolyear.beans.SchoolYear;
import com.progesco.client.constant.Constant;

/**
 * @author emile
 *
 */
@FeignClient(name = "progesco-schoolyear", url = Constant.URL_SCHOOLYEAR)
public interface SchoolYearProxy {
	@GetMapping(value = "/schoolyears")
	List<SchoolYear> getAllSchoolyears();

	@GetMapping(value = "/schoolyear/{id}")
	Resource<SchoolYear> retrieveSchoolyear(@PathVariable("id") long id);
	
	@GetMapping(value = "/schoolyear/activeyear")
	SchoolYear retrieveActiveSchoolYear();

	@PostMapping(value = "/schoolyear")
	SchoolYear addSchoolyear(@RequestBody SchoolYear schoolYear);
	
	@PutMapping(value = "/schoolyear/status/{id}/{status}")
	SchoolYear updateStatus(@PathVariable("id") long id, @PathVariable("status") Integer status);
	
}
