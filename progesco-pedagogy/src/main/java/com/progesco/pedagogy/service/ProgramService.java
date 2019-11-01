/**
 *
 */
package com.progesco.pedagogy.service;

import java.util.List;
import java.util.Optional;

import com.progesco.pedagogy.exception.ProgramForbiddenException;
import com.progesco.pedagogy.exception.ProgramNotFoundException;
import com.progesco.pedagogy.utils.Constant;
import com.progesco.pedagogy.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Program;
import com.progesco.pedagogy.repository.ProgramRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile
 *
 */
@Service("ProgramService")
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

	@Value("${app.jwtSecret}")
	private String jwtSecret;


    /**
     * Return all programs
	 * @param request
     * @return
     */
    public List<Program> getAllPrograms(HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_PROGRAM_VIEW,
																							   this.jwtSecret)) {
			throw new ProgramForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

    	return programRepository.findAll();
    }

    /**
     * Add a new program
     * @param program
	 * @param request
     */
    public Program addProgram(Program program, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_PROGRAM_ADD,
																							   this.jwtSecret)) {
			throw new ProgramForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

    	return programRepository.save(program);
    }

    /**
     * Retrieve program by ID
     * @param id
     * @return
     */
    public Optional<Program> findProgram(Long id) {
        return programRepository.findById(id);
    }

	/**
	 * Retrieve a program by ID
	 * @param id
	 * @param request
	 * @return
	 */
    public Program retrieveProgram(Long id, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_PROGRAM_VIEW,
																							   this.jwtSecret)) {
			throw new ProgramForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

		Optional<Program> program = this.findProgram(id);

		if (!program.isPresent())
			throw new ProgramNotFoundException("id-" + id);

		return program.get();
	}
}
