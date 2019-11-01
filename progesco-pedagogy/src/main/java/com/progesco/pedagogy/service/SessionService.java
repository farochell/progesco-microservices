/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.List;
import java.util.Optional;

import com.progesco.pedagogy.exception.SessionForbiddenException;
import com.progesco.pedagogy.exception.SessionNotFoundException;
import com.progesco.pedagogy.utils.Constant;
import com.progesco.pedagogy.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Session;
import com.progesco.pedagogy.repository.SessionRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile.camara
 *
 */
@Service("SessionService")
public class SessionService {
	@Autowired
	private SessionRepository sessionRepository;

	@Value("${app.jwtSecret}")
	private String            jwtSecret;
	
	/**
	 * Return all specialities
	 * @param request
	 * @return
	 */
	public List<Session> getAllSessions(HttpServletRequest request) {

		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_SESSION_VIEW,
																							   this.jwtSecret)) {
			throw new SessionForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		return sessionRepository.findAll();
	}
	
	/**
	 * Add a new session
	 * @param session
	 * @param request
	 */
	public Session addSession(Session session, HttpServletRequest request) {

		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_SESSION_ADD,
																							   this.jwtSecret)) {
			throw new SessionForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
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
	 * @param request
	 * @return
	 */
	public Session updateSession(Session session, HttpServletRequest request) {

		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_SESSION_UPD,
																							   this.jwtSecret)) {
			throw new SessionForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		return sessionRepository.save(session);
	}

	/**
	 * Retrieve a session by id
	 * @param id
	 * @param request
	 * @return
	 */
	public Session retrieveSession(Long id, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_SESSION_VIEW,
																							   this.jwtSecret)) {
			throw new SessionForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

		Optional<Session> session = this.findSession(id);

		if (!session.isPresent())
			throw new SessionNotFoundException("id-" + id);

		return session.get();
	}
}
