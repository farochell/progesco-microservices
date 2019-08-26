/**
 * 
 */
package com.progesco.pedagogy.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.progesco.pedagogy.model.GroupModel;
import com.progesco.pedagogy.model.GroupModelCollection;
import com.progesco.pedagogy.service.GroupService;

/**
 * @author emile.camara
 *
 */
@RestController
public class GroupController {
	@Autowired
	private GroupService groupService;
	
	@GetMapping(value = "/groups/page/{page}")
	public GroupModelCollection getAllGroups(@PathVariable("page") int page) {
		PageRequest pageable = PageRequest.of(page - 1, 15);
		
		return groupService.getAllGroups(pageable);
	}
	
	@GetMapping("/groups/{id}")
	public Resource<GroupModel> retrieveGroup(@PathVariable long id) {
		GroupModel group = groupService.retrieveGroup(id);

		Resource<GroupModel> resource = new Resource<GroupModel>(group);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllGroups(1));

		resource.add(linkTo.withRel("all-groups"));

		return resource;
	}
	
	@GetMapping("/groups/classroom/{id}")
	public List<GroupModel> getGroupByClassroom(@PathVariable long id) {
		List<GroupModel> groups = groupService.getGroupByClassroom(id);

		return groups;
	}
	
	@PostMapping(value = "/groups")
	public ResponseEntity<GroupModel> addGroup(@RequestBody GroupModel groupModel) {
		GroupModel resource = groupService.addGroup(groupModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/groups")
	public ResponseEntity<GroupModel> updateCourse(@RequestBody GroupModel groupModel) {
		GroupModel resource = groupService.updateGroup(groupModel);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@DeleteMapping(value = "/groups/{id}")
	public void deleteGroup(@PathVariable Long id) {
		groupService.deleteGroup(id);
	}
}
