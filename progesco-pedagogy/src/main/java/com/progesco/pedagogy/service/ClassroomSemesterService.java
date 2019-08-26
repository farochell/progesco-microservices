/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Classroom;
import com.progesco.pedagogy.entity.ClassroomSemester;
import com.progesco.pedagogy.entity.Speciality;
import com.progesco.pedagogy.model.ClassroomSemesterModel;
import com.progesco.pedagogy.repository.ClassroomSemesterRepository;

/**
 * @author emile.camara
 *
 */
@Service("ClassroomSemesterService")
public class ClassroomSemesterService {
	@Autowired
	private ClassroomSemesterRepository classroomSemesterRepository;

	@Autowired
	private ClassroomService classroomService;

	@Autowired
	private SpecialityService specialityService;

	/**
	 * Allow to build a Classroom model
	 * @param classroomSemester
	 * @return
	 */
	private ClassroomSemesterModel buildClassroomSemesterModel(ClassroomSemester classroomSemester) {
		ClassroomSemesterModel classroomSemesterModel = new ClassroomSemesterModel();
		classroomSemesterModel.setId(classroomSemester.getId());
		classroomSemesterModel.setClassroom(classroomSemester.getClassroom().getId());
		classroomSemesterModel.setLabel(classroomSemester.getLabel());
		classroomSemesterModel.setSpeciality(classroomSemester.getSpeciality().getId());

		return classroomSemesterModel;
	}

	/**
	 * Allow to build a Classroom entity
	 * @param classroomSemesterModel
	 * @return
	 */
	private ClassroomSemester buildClassroomSemester(ClassroomSemesterModel classroomSemesterModel) {
		ClassroomSemester classroomSemester = null;
		if(Long.valueOf(classroomSemesterModel.getId())!=null) {			
			Optional<ClassroomSemester> classroomSemesterOptional = classroomSemesterRepository.findById(classroomSemesterModel.getId());
			classroomSemester = classroomSemesterOptional.get();
		} else {
			classroomSemester = new ClassroomSemester();
		}

		Optional<Classroom> classroom = classroomService.findClassroom(classroomSemesterModel.getClassroom());
		Optional<Speciality> speciality = specialityService.findSpeciality(classroomSemesterModel.getSpeciality());
		classroomSemester.setId(classroomSemesterModel.getId());
		classroomSemester.setClassroom(classroom.get());
		classroomSemester.setLabel(classroomSemesterModel.getLabel());
		classroomSemester.setSpeciality(speciality.get());

		return classroomSemester;
	}
	
	/**
	 * Return all classroomSemesters
	 * @return
	 */
	public List<ClassroomSemesterModel> getAllClassroomSemesters() {
		List<ClassroomSemesterModel> classroomSemesterModels = new ArrayList<>();
		
		List<ClassroomSemester> classroomSemesters = classroomSemesterRepository.findAll();
		for(ClassroomSemester classroomSemester: classroomSemesters) {
			classroomSemesterModels.add(buildClassroomSemesterModel(classroomSemester));
		}
		
		return classroomSemesterModels;
	}
	
	/**
	 * Return all semesters of given classroom ID
	 * @param id
	 * @return
	 */
	public List<ClassroomSemesterModel> getAllClassroomSemestersByClassroom(Long id) {
		List<ClassroomSemesterModel> classroomSemesterModels = new ArrayList<>();
		Optional<Classroom> classroom = classroomService.findClassroom(id);
		List<ClassroomSemester> classroomSemesters = classroomSemesterRepository.findByClassroom(classroom.get());
		for(ClassroomSemester classroomSemester: classroomSemesters) {
			classroomSemesterModels.add(buildClassroomSemesterModel(classroomSemester));
		}
		
		return classroomSemesterModels;
	}

	/**
	 * Allow to add a new ClassroomSemester
	 * @param classroomSemesterModel
	 * @return
	 */
	public ClassroomSemesterModel addClassroomSemester(ClassroomSemesterModel classroomSemesterModel) {
		ClassroomSemester classroomSemester = buildClassroomSemester(classroomSemesterModel);

		classroomSemesterRepository.save(classroomSemester);
		classroomSemesterModel.setId(classroomSemester.getId());

		return classroomSemesterModel;

	}

	/**
	 * Allow to update a ClassroomSemester entity
	 * @param classroomSemesterModel
	 * @return
	 */
	public ClassroomSemesterModel updateClassroomSemester(ClassroomSemesterModel classroomSemesterModel) {
		ClassroomSemester classroomSemester = buildClassroomSemester(classroomSemesterModel);

		classroomSemesterRepository.save(classroomSemester);

		return classroomSemesterModel;

	}

	/**
	 * Return the classroomSemester by Id
	 * @param id
	 * @return
	 */
	public Optional<ClassroomSemester> findClassroomSemester(Long id) {
		return classroomSemesterRepository.findById(id);
	}

}
