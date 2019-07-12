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
import com.progesco.client.pedagogy.beans.Level;

/**
 * @author emile
 *
 */
@FeignClient(name = "progesco-pedagogy", url = Constant.URL_PEDAGOGY)
public interface LevelProxy {
	@GetMapping(value = "/levels")
	List<Level> getAllLevels();

	@GetMapping(value = "/level/{id}")
	Resource<Level> findLevel(@PathVariable("id") long id);

	@PostMapping(value = "/level")
	Level addLevel(@RequestBody Level level);
	
	@PutMapping(value = "/level")
	Level updateLevel(@RequestBody Level level);
}
