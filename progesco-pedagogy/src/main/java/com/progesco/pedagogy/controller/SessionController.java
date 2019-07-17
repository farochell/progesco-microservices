/**
 * 
 */
package com.progesco.pedagogy.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.progesco.pedagogy.entity.Session;
import com.progesco.pedagogy.exception.SessionNotFoundException;
import com.progesco.pedagogy.service.SessionService;

/**
 * @author emile.camara
 *
 */
@RestController
public class SessionController {
	@Autowired
	private SessionService sessionService;
	
	@GetMapping(value = "/sessions")
	public List<Session> getAllSessions() {
		return sessionService.getAllSessions();
	}
	
	@GetMapping("/sessions/{id}")
	public Resource<Session> retrieveSession(@PathVariable long id) {
		Optional<Session> session = sessionService.findSession(id);

		if (!session.isPresent())
			throw new SessionNotFoundException("id-" + id);

		Resource<Session> resource = new Resource<Session>(session.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllSessions());

		resource.add(linkTo.withRel("all-sessions"));

		return resource;
	}
	
	@PostMapping(value = "/sessions")
	public ResponseEntity<Session> addSession(@RequestBody Session session) {
		Session resource = sessionService.addSession(session);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
	
	@PutMapping(value = "/sessions")
	public ResponseEntity<Session> updateSession(@RequestBody Session session) {
		Session resource = sessionService.updateSession(session);

		return ResponseEntity.status(HttpStatus.OK).body(resource);
	}
}
