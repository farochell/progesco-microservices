/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Speciality;
import com.progesco.pedagogy.repository.SpecialityRepository;

/**
 * @author emile
 *
 */
@Service("SpecialityService")
public class SpecialityService {
	@Autowired
	private SpecialityRepository specialityRepository;
	
	/**
	 * Return all specialities
	 * @return
	 */
	public List<Speciality> getAllSpecialities() {
		return specialityRepository.findAll();
	}
	
	/**
	 * Add a new speciality
	 * @param speciality
	 */
	public Speciality addSpeciality(Speciality speciality) {
		return specialityRepository.save(speciality);
	}
	
	/**
	 * Retrieve speciality by ID
	 * @param id
	 * @return
	 */
	public Optional<Speciality> findSpeciality(Long id) {
		return  specialityRepository.findById(id);
	}
	
	/**
	 * Allows to update a speciality
	 * @param speciality
	 * @return
	 */
	public Speciality updateSpeciality(Speciality speciality) {
		return specialityRepository.save(speciality);
	}
}
