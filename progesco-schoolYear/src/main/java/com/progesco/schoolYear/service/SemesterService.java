/**
 * 
 */
package com.progesco.schoolYear.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.schoolYear.entity.SchoolYear;
import com.progesco.schoolYear.entity.Semester;
import com.progesco.schoolYear.model.SemesterModel;
import com.progesco.schoolYear.repository.SchoolYearRepository;
import com.progesco.schoolYear.repository.SemesterRepository;

/**
 * @author emile
 *
 */
@Service("SemesterService")
public class SemesterService {
	
	@Autowired
	private SemesterRepository semesterRepository;
	
	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	/**
	 * Build the semester model
	 * @param semester
	 * @return
	 */
	public SemesterModel buildSemesterModel(Semester semester) {
		SemesterModel semesterModel = new SemesterModel();
		semesterModel.setId(semester.getId());
		semesterModel.setEndDate(semester.getEndDate());
		semesterModel.setStartDate(semester.getStartDate());
		semesterModel.setLevel(semester.getLevel());
		semesterModel.setRankid(semester.getRankid());
		semesterModel.setLabel(semester.getLabel());
		
		return semesterModel;
	}
	
	/**
	 * Return the complete list of semesters
	 * @return
	 */
	public List<SemesterModel> getAllSemesters() {
		List<Semester> semesters = semesterRepository.findAll();
		List<SemesterModel> semesterModels = new ArrayList<>();
		for(Semester semester: semesters) {
			semesterModels.add(buildSemesterModel(semester));
		}
		
		return semesterModels;		
	}
	
	/**
	 * Return the list of semesters by schoolYearId given parameter
	 * @param schoolyearId
	 * @return
	 */
	public List<SemesterModel> findSemesterBySchoolyear(Long schoolyearId) {
		Optional<SchoolYear> schoolYear = schoolYearRepository.findById(schoolyearId);
		List<SemesterModel> semesterModels = new ArrayList<>();
		List<Semester> semesters = semesterRepository.findBySchoolyear(schoolYear.get());
		
		for(Semester semester: semesters) {
			semesterModels.add(buildSemesterModel(semester));
		}
		
		return semesterModels;		
	}
	
	/**
	 * Find a semester by Id
	 * @param id
	 * @return
	 */
	public SemesterModel findSemester(Long id) {
		Optional<Semester> semester = semesterRepository.findById(id);
		
		return buildSemesterModel(semester.get());
	}
	
	/**
	 * Allows to add a new semester
	 * @param semesterModel
	 * @return
	 */
	public SemesterModel addSemester(SemesterModel semesterModel) {
		Optional<SchoolYear> schoolYear = schoolYearRepository.findById(semesterModel.getSchoolyearId());
		Semester semester = new Semester();
		semester.setEndDate(semesterModel.getEndDate());
		semester.setStartDate(semesterModel.getStartDate());
		semester.setLabel(semesterModel.getLabel());
		semester.setRankid(semesterModel.getRankid());
		semester.setLevel(semesterModel.getLevel());
		semester.setSchoolyear(schoolYear.get());
		
		semesterRepository.save(semester);
		
		semesterModel.setId(semester.getId());
		
		return semesterModel;
	}
	
	/**
	 * Allows to update a semester
	 * @param semesterModel
	 * @return
	 */
	public SemesterModel updateSemester(SemesterModel semesterModel) {
		Optional<SchoolYear> schoolYear = schoolYearRepository.findById(semesterModel.getSchoolyearId());
		Optional<Semester> semester = semesterRepository.findById(semesterModel.getId());
		semester.get().setEndDate(semesterModel.getEndDate());
		semester.get().setStartDate(semesterModel.getStartDate());
		semester.get().setLabel(semesterModel.getLabel());
		semester.get().setRankid(semesterModel.getRankid());
		semester.get().setLevel(semesterModel.getLevel());
		semester.get().setSchoolyear(schoolYear.get());
		
		semesterRepository.save(semester.get());
		
		semesterModel.setId(semester.get().getId());
		
		return semesterModel;
	}
}
