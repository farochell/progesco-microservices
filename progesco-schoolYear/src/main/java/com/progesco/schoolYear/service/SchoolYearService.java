/**
 * 
 */
package com.progesco.schoolYear.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.schoolYear.entity.SchoolYear;
import com.progesco.schoolYear.exception.SchoolYearNotFoundException;
import com.progesco.schoolYear.repository.SchoolYearRepository;

/**
 * @author emile
 *
 */
@Service("SchoolYearService")
public class SchoolYearService {

	@Autowired
	private SchoolYearRepository schoolYearRepository;

	/**
	 * Return all school years
	 * 
	 * @return
	 */
	public List<SchoolYear> getAllSchoolyears() {
		return schoolYearRepository.findAll();
	}

	/**
	 * Add a new school year
	 * 
	 * @param schoolYear
	 */
	public SchoolYear addSchoolYear(SchoolYear schoolYear) {
		return schoolYearRepository.save(schoolYear);
	}

	/**
	 * Retrieve schoolyear by ID
	 * 
	 * @param id
	 * @return
	 */
	public Optional<SchoolYear> retrieveSchoolYear(Long id) {
		return schoolYearRepository.findById(id);
	}
	
	/**
	 * Retrieve active school year
	 * @return
	 */
	public Optional<SchoolYear> retrieveActiveSchoolYear() {		
		Optional<SchoolYear> schoolYear = schoolYearRepository.findOneByIsActive();
	    return schoolYear;
	}

	/**
	 * Allows to update SchoolYear status
	 * @param id
	 * @param status
	 * @return
	 */
	public SchoolYear updateStatus(Long id, Integer status) {
		Optional<SchoolYear> schoolYear = schoolYearRepository.findById(id);
		if(!schoolYear.isPresent()) {
			throw new SchoolYearNotFoundException("id-" + id);
		}

		Boolean statusValue = convertStatusValue(status);		

		if(statusValue.equals(true)) {
			// Disable all school years => only one school year can be actived
			List<SchoolYear> schoolyears = schoolYearRepository.findAll();
			for(SchoolYear schoolyear: schoolyears) {
				schoolyear.setActive(false);
				schoolYearRepository.save(schoolyear);
			}
		}

		schoolYear.get().setActive(statusValue);
		schoolYearRepository.save(schoolYear.get());

		return schoolYear.get();
	}

	/**
	 * Return True or False allowing status value
	 * @param status
	 * @return
	 */
	Boolean convertStatusValue(Integer status) {
		Boolean statusValue = false;
		switch(status) {
		case 1:
			statusValue = true;
			break;
		case 0:
			statusValue = false;
			break;
		default:
			statusValue = false;
			break;
		}

		return statusValue;
	}
}
