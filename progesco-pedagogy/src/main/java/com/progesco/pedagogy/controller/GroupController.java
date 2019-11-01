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

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile.camara
 *
 */
@RestController
public class GroupController {
	@Autowired
	private GroupService groupService;
	
	@GetMapping(value = "/groups/page/{page}")
	public GroupModelCollection getAllGroups(@PathVariable("page") int page, HttpServletRequest request) {
		PageRequest pageable = PageRequest.of(page - 1, 15);
		
		return groupService.getAllGroups(pageable, request);
	}
	
	@GetMapping("/groups/{id}")
	public Resource<GroupModel> retrieveGroup(@PathVariable long id, HttpServletRequest request) {
		GroupModel group = groupService.retrieveGroup(id, request);

		Resource<GroupModel> resource = new Resource<GroupModel>(group);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllGroups(1, request));

		resource.add(linkTo.withRel("all-groups"));

		return resource;
	}
	
	@GetMapping("/groups/classroom/{id}")
	public List<GroupModel> getGroupByClassroom(@PathVariable long id, HttpServletRequest request) {
		List<GroupModel> groups = groupService.getGroupByClassroom(id, request);

		return groups;
	}
	
	@PostMapping(value = "/groups")
	public ResponseEntity<GroupModel> addGroup(@RequestBody GroupModel groupModel, HttpServletRequest request) {
		GroupModel resource = groupService.addGroup(groupModel, request);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/groups")
	public ResponseEntity<GroupModel> updateCourse(@RequestBody GroupModel groupModel, HttpServletRequest request) {
		GroupModel resource = groupService.updateGroup(groupModel, request);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@DeleteMapping(value = "/groups/{id}")
	public void deleteGroup(@PathVariable Long id, HttpServletRequest request) {
		groupService.deleteGroup(id, request);
	}
}
