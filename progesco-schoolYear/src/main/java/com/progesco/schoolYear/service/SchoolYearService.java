/**
 * 
 */
package com.progesco.schoolYear.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.schoolYear.model.SchoolYear;
import com.progesco.schoolYear.repository.SchoolYearRepository;

/**
 * @author emile
 *
 */
@Service("schoolyears")
public class SchoolYearService {

	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	/**
	 * Return all school years
	 * @return
	 */
	public List<SchoolYear> getAllSchoolyears() {
		return schoolYearRepository.findAll();
	}
	
	/**
	 * Add a new school year
	 * @param schoolYear
	 */
	public SchoolYear addSchoolYear(SchoolYear schoolYear) {
		return schoolYearRepository.save(schoolYear);
	}
	
	/**
	 * Retrieve schoolyear by ID
	 * @param id
	 * @return
	 */
	public Optional<SchoolYear> retrieveSchoolYear(Long id) {
		return  schoolYearRepository.findById(id);
	}
}
