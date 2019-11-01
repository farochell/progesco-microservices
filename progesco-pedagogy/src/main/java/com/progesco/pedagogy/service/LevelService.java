package com.progesco.pedagogy.service;

import java.util.List;
import java.util.Optional;

import com.progesco.pedagogy.exception.LevelForbiddenException;
import com.progesco.pedagogy.exception.LevelNotFoundException;
import com.progesco.pedagogy.utils.Constant;
import com.progesco.pedagogy.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Level;
import com.progesco.pedagogy.repository.LevelRepository;

import javax.servlet.http.HttpServletRequest;

@Service("LevelService")
public class LevelService {
	@Autowired
	private LevelRepository levelRepository;

	@Value("${app.jwtSecret}")
	private String jwtSecret;
	
	/**
	 * Return all levels
	 * @param request
	 * @return
	 */
	public List<Level> getAllLevels(HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_LEVEL_VIEW,
																							   this.jwtSecret)) {
			throw new LevelForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

		return levelRepository.findAll();
	}
	
	/**
	 * Add a new level
	 * @param level
	 * @param request
	 */
	public Level addLevel(Level level, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_LEVEL_ADD,
																							   this.jwtSecret)) {
			throw new LevelForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

		return levelRepository.save(level);
	}
	
	/**
	 * Retrieve level by ID
	 * @param id
	 * @return
	 */
	public Optional<Level> findLevel(Long id) {
		return  levelRepository.findById(id);
	}


	/**
	 * Retrieve a level by ID
	 * @param id
	 * @param request
	 * @return
	 */
	public Level retrieveLevel(Long id, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_LEVEL_VIEW,
																							   this.jwtSecret)) {
			throw new LevelForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

		Optional<Level> level = this.findLevel(id);

		if (!level.isPresent())
			throw new LevelNotFoundException("id-" + id);

		return level.get();
	}
	
	/**
	 * Allows to update un level record
	 * @param level
	 * @param request
	 * @return
	 */
	public Level updateLevel(Level level, HttpServletRequest request) {

		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_LEVEL_UPD,
																							   this.jwtSecret)) {
			throw new LevelForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		return levelRepository.save(level);
	}
	
}
