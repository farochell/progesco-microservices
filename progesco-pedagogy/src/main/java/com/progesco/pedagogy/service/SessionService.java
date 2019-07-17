/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Session;
import com.progesco.pedagogy.repository.SessionRepository;

/**
 * @author emile.camara
 *
 */
@Service("SessionService")
public class SessionService {
	@Autowired
	private SessionRepository sessionRepository;
	
	/**
	 * Return all specialities
	 * @return
	 */
	public List<Session> getAllSessions() {
		return sessionRepository.findAll();
	}
	
	/**
	 * Add a new session
	 * @param session
	 */
	public Session addSession(Session session) {
		return sessionRepository.save(session);
	}
	
	/**
	 * Retrieve session by ID
	 * @param id
	 * @return
	 */
	public Optional<Session> findSession(Long id) {
		return  sessionRepository.findById(id);
	}
	
	/**
	 * Allows to update a session
	 * @param session
	 * @return
	 */
	public Session updateSession(Session session) {
		return sessionRepository.save(session);
	}
}
