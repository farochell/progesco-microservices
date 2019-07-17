/**
 * 
 */
package com.progesco.progescoschooling.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.progesco.progescoschooling.entity.EducationalRegistration;
import com.progesco.progescoschooling.model.EducationalRegistrationCollectionModel;
import com.progesco.progescoschooling.model.EducationalRegistrationModel;
import com.progesco.progescoschooling.repository.EducationalRegistrationRepository;

/**
 * @author emile.camara
 *
 */
@Service("EducationalRegistrationService")
public class EducationalRegistrationService {
	@Autowired
	private EducationalRegistrationRepository educationalRegistrationRepository;
	
	/**
	 * Allow to build model from entity
	 * @param educationalRegistration
	 * @return
	 */
	private EducationalRegistrationModel buildEducationalRegistrationModel(EducationalRegistration educationalRegistration) {
		EducationalRegistrationModel educationalRegistrationModel = new EducationalRegistrationModel();
		
		educationalRegistrationModel.setClassroom(educationalRegistration.getClassroom());
		educationalRegistrationModel.setId(educationalRegistration.getId());
		educationalRegistrationModel.setRegistrationNumber(educationalRegistration.getRegistrationNumber());
		educationalRegistrationModel.setSchoolYear(educationalRegistration.getSchoolYear());
		educationalRegistrationModel.setSession(educationalRegistration.getSession());
		educationalRegistrationModel.setStatus(educationalRegistration.getStatus());
		
		return educationalRegistrationModel;
	}
	
	/**
	 * Allow to build an entity from model
	 * @param educationalRegistrationModel
	 * @return
	 */
	public EducationalRegistration buildEducationalRegistration(EducationalRegistrationModel educationalRegistrationModel) {
		EducationalRegistration educationalRegistration = new EducationalRegistration();
		
		educationalRegistration.setClassroom(educationalRegistrationModel.getClassroom());
		educationalRegistration.setId(educationalRegistrationModel.getId());
		educationalRegistration.setRegistrationNumber(educationalRegistrationModel.getRegistrationNumber());
		educationalRegistration.setSchoolYear(educationalRegistrationModel.getSchoolYear());
		educationalRegistration.setSession(educationalRegistrationModel.getSession());
		educationalRegistration.setStatus(educationalRegistrationModel.getStatus());
		
		return educationalRegistration;
	}
	
	/**
	 * Return all records
	 * @param pageable
	 * @return
	 */
	public EducationalRegistrationCollectionModel getAllEducationalRegistrations(Pageable pageable) {
		EducationalRegistrationCollectionModel educationalRegistrationCollectionModel = new EducationalRegistrationCollectionModel();
		Page<EducationalRegistration> educationalRegistrations = educationalRegistrationRepository.findAll(pageable);		
		int totalPages = educationalRegistrations.getTotalPages();
		if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            educationalRegistrationCollectionModel.setTotalItems(pageNumbers);
        }
		List<EducationalRegistrationModel> educationalRegistrationModels = new ArrayList<>();
		
		for(EducationalRegistration student: educationalRegistrations.getContent()) {
			
			educationalRegistrationModels.add(buildEducationalRegistrationModel(student));
		}
		
		educationalRegistrationCollectionModel.setEducationalRegistrationModels(educationalRegistrationModels);
		
		return educationalRegistrationCollectionModel;
	}
}
