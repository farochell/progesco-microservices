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
import com.progesco.pedagogy.entity.Level;
import com.progesco.pedagogy.entity.Department;
import com.progesco.pedagogy.exception.ClassroomNotFoundException;
import com.progesco.pedagogy.model.ClassroomModel;
import com.progesco.pedagogy.repository.ClassroomRepository;

/**
 * @author emile
 *
 */
@Service("ClassroomService")
public class ClassroomService {
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private LevelService levelService;
	
	/**
	 * Fonction permettant de construire l'objet classroomModel
	 * @param classroom
	 * @return
	 */
	public ClassroomModel buildClassroomModel(Classroom classroom) {
		ClassroomModel classroomModel = new ClassroomModel();
		classroomModel.setId(classroom.getId());
		classroomModel.setLabel(classroom.getLabel());
		classroomModel.setLevelId(classroom.getLevel().getId());
		classroomModel.setDepartmentId(classroom.getDepartment().getId());
		
		return classroomModel;
	}
	
	/**
	 * This function allows to get all classrooms
	 * @return
	 */
	public List<ClassroomModel> getAllClassrooms(){
		List<Classroom> classrooms = classroomRepository.findAll();
		List<ClassroomModel> classroomModels = new ArrayList<>();
		for(Classroom classroom: classrooms) {
			classroomModels.add(buildClassroomModel(classroom));
		}
		
		return classroomModels;
	}
	
	/**
	 * Add a new classroom
	 * @param classroomModel
	 */
	public ClassroomModel addClassroom(ClassroomModel classroomModel) {
		Optional<Department> department = departmentService.findDepartment(classroomModel.getDepartmentId());
		Optional<Level> level = levelService.findLevel(classroomModel.getLevelId());
		Classroom classroom = new Classroom();
		classroom.setLabel(classroomModel.getLabel());
		classroom.setLevel(level.get());
		classroom.setDepartment(department.get());
		
		classroomRepository.save(classroom);
		
		classroomModel.setId(classroom.getId());
		
		return classroomModel;
	}
	
	/**
	 * Retrieve classroom by ID
	 * @param id
	 * @return
	 */
	public ClassroomModel findClassroom(Long id) {
		Optional<Classroom> classroom = classroomRepository.findById(id);
		
		if(!classroom.isPresent()) {
			throw new ClassroomNotFoundException("Enregistrement non trouvé. ID:" + id);
		}
		
		return  buildClassroomModel(classroom.get());
	}
	
	/**
	 * Update a classroom record
	 * @param classroomModel
	 * @return
	 */
	public ClassroomModel updateClassroom(ClassroomModel classroomModel) {
		Optional<Department> department = departmentService.findDepartment(classroomModel.getDepartmentId());
		Optional<Level> level = levelService.findLevel(classroomModel.getLevelId());
		Optional<Classroom> classroom = classroomRepository.findById(classroomModel.getId());
		classroom.get().setId(classroomModel.getId());
		classroom.get().setLabel(classroomModel.getLabel());
		classroom.get().setDepartment(department.get());
		classroom.get().setLevel(level.get());
		
		classroomRepository.save(classroom.get());
		
		return classroomModel;
	}
	
}
