/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Program;
import com.progesco.pedagogy.repository.ProgramRepository;

/**
 * @author emile
 *
 */
@Service("ProgramService")
public class ProgramService {

	@Autowired
	private ProgramRepository programRepository;
	
	/**
	 * Return all programs
	 * @return
	 */
	public List<Program> getAllPrograms() {
		return programRepository.findAll();
	}
	
	/**
	 * Add a new program
	 * @param program
	 */
	public Program addProgram(Program program) {
		return programRepository.save(program);
	}
	
	/**
	 * Retrieve program by ID
	 * @param id
	 * @return
	 */
	public Optional<Program> findProgram(Long id) {
		return  programRepository.findById(id);
	}
}
