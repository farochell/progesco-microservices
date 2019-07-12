package com.progesco.pedagogy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Level;
import com.progesco.pedagogy.repository.LevelRepository;

@Service("LevelService")
public class LevelService {
	@Autowired
	private LevelRepository levelRepository;
	
	/**
	 * Return all levels
	 * @return
	 */
	public List<Level> getAllLevels() {
		return levelRepository.findAll();
	}
	
	/**
	 * Add a new level
	 * @param level
	 */
	public Level addLevel(Level level) {
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
	 * Allows to update un level record
	 * @param level
	 * @return
	 */
	public Level updateLevel(Level level) {
		return levelRepository.save(level);
	}
	
}
