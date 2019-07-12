/**
 * 
 */
package com.progesco.client.pedagogy.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.progesco.client.constant.Constant;
import com.progesco.client.pedagogy.beans.Speciality;

/**
 * @author emile
 *
 */
@FeignClient(name = "progesco-pedagogy", url = Constant.URL_PEDAGOGY)
public interface SpecialityProxy {
	@GetMapping(value = "/specialities")
	List<Speciality> getAllSpecialities();

	@GetMapping(value = "/speciality/{id}")
	Resource<Speciality> findSpeciality(@PathVariable("id") long id);

	@PostMapping(value = "/speciality")
	Speciality addSpeciality(@RequestBody Speciality speciality);
	
	@PutMapping(value = "/speciality")
	Speciality updateSpeciality(@RequestBody Speciality speciality);
}
