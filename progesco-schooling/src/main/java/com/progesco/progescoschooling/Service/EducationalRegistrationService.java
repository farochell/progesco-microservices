/**
 * 
 */
package com.progesco.progescoschooling.Service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.progesco.progescoschooling.entity.EducationalRegistration;
import com.progesco.progescoschooling.exception.EducationalRegistrationNotFoundException;
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
		educationalRegistration.setStudent(educationalRegistrationModel.getStudent());
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
	
	/**
	 * Add new record
	 * @param educationalRegistrationModel
	 * @return
	 */
	public EducationalRegistrationModel addEducationalRegistration(EducationalRegistrationModel educationalRegistrationModel) {
		EducationalRegistration educationalRegistration = buildEducationalRegistration(educationalRegistrationModel);
		educationalRegistrationRepository.save(educationalRegistration);
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = DATE_FORMAT.format(System.currentTimeMillis());
		String registration =  date + "-" + educationalRegistration.getId();
		educationalRegistration.setRegistrationNumber(registration);
		educationalRegistrationRepository.save(educationalRegistration);
		
		educationalRegistrationModel = buildEducationalRegistrationModel(educationalRegistration);
		
		return educationalRegistrationModel;
	}
	
	/**
	 * Update a record
	 * @param educationalRegistrationModel
	 * @return
	 */
	public EducationalRegistrationModel updateEducationalRegistration(EducationalRegistrationModel educationalRegistrationModel) {
		EducationalRegistration educationalRegistration = buildEducationalRegistration(educationalRegistrationModel);
		educationalRegistrationRepository.save(educationalRegistration);
		
		educationalRegistrationModel = buildEducationalRegistrationModel(educationalRegistration);
		return educationalRegistrationModel;		
	}
	
	/**
	 * Find a educationalRegistration by given ID
	 * @param id
	 * @return
	 */
	public EducationalRegistrationModel retrieveEducationalRegistration(Long id) {
		Optional<EducationalRegistration> educationalRegistration = educationalRegistrationRepository.findById(id);
		EducationalRegistrationModel educationalRegistrationModel = new EducationalRegistrationModel();
		if (!educationalRegistration.isPresent()) {
			throw new EducationalRegistrationNotFoundException("Id not found: " + id);
		}
		educationalRegistrationModel = buildEducationalRegistrationModel(educationalRegistration.get());
		
		return educationalRegistrationModel;
	}
	
	/**
	 * Return all educational registration of the student ID given
	 * @param studentId
	 * @return
	 */
	public List<EducationalRegistrationModel> getStudentEducationalRegistrations(Long studentId) {
		List<EducationalRegistrationModel> educationalRegistrationModels = new ArrayList<>();
		List<EducationalRegistration> educationalRegistrations = educationalRegistrationRepository.findByStudent(studentId);
		if(!educationalRegistrations.isEmpty()) {
			for(EducationalRegistration educationalRegistration: educationalRegistrations) {
				educationalRegistrationModels.add(buildEducationalRegistrationModel(educationalRegistration));
			}
		}
		return educationalRegistrationModels;
	}
	
	public EducationalRegistrationCollectionModel getEducationalRegistrationsByStatus(Pageable pageable, Integer status) {
		EducationalRegistrationCollectionModel educationalRegistrationCollectionModel = new EducationalRegistrationCollectionModel();
		List<EducationalRegistration> educationalRegistrationByStatus = educationalRegistrationRepository.findByStatus(status, pageable);		
		int totalPages = educationalRegistrationByStatus.size();
		if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            educationalRegistrationCollectionModel.setTotalItems(pageNumbers);
        }
		List<EducationalRegistrationModel> educationalRegistrationModels = new ArrayList<>();
		
		for(EducationalRegistration student: educationalRegistrationByStatus) {			
			educationalRegistrationModels.add(buildEducationalRegistrationModel(student));
		}
		
		educationalRegistrationCollectionModel.setEducationalRegistrationModels(educationalRegistrationModels);
		
		return educationalRegistrationCollectionModel;
	}
}
