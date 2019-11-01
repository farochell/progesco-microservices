/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.progesco.pedagogy.exception.ClassroomForbiddenException;
import com.progesco.pedagogy.utils.Constant;
import com.progesco.pedagogy.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Classroom;
import com.progesco.pedagogy.entity.Level;
import com.progesco.pedagogy.entity.Department;
import com.progesco.pedagogy.exception.ClassroomNotFoundException;
import com.progesco.pedagogy.model.ClassroomModel;
import com.progesco.pedagogy.repository.ClassroomRepository;

import javax.servlet.http.HttpServletRequest;

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

	@Value("${app.jwtSecret}")
	private String jwtSecret;

	
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
	 * @param request
	 * @return
	 */
	public List<ClassroomModel> getAllClassrooms(HttpServletRequest request){
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_CLASSROOM_VIEW, this.jwtSecret)) {
			throw new ClassroomForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
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
	 * @param request
	 */
	public ClassroomModel addClassroom(ClassroomModel classroomModel, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_CLASSROOM_ADD, this.jwtSecret)) {
			throw new ClassroomForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		Optional<Department> department = departmentService.findDepartment(classroomModel.getDepartmentId());
		Optional<Level> level = levelService.findLevel(classroomModel.getLevelId());
		Classroom classroom = new Classroom();
		classroom.setLabel(level.get().getLabel() + " - " + department.get().getLabel());
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
	public Optional<Classroom> findClassroom(Long id) {
		Optional<Classroom> classroom = classroomRepository.findById(id);
		
		if(!classroom.isPresent()) {
			throw new ClassroomNotFoundException("Enregistrement non trouvé. ID:" + id);
		}
		
		return classroom;
	}

	/**
	 * Update a classroom record
	 * @param classroomModel
	 * @param request
	 * @return
	 */
	public ClassroomModel updateClassroom(ClassroomModel classroomModel, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_CLASSROOM_UPD, this.jwtSecret)) {
			throw new ClassroomForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		Optional<Department> department = departmentService.findDepartment(classroomModel.getDepartmentId());
		Optional<Level> level = levelService.findLevel(classroomModel.getLevelId());
		Optional<Classroom> classroom = classroomRepository.findById(classroomModel.getId());
		classroom.get().setId(classroomModel.getId());
		classroom.get().setLabel(level.get().getLabel() + " - " + department.get().getLabel() );
		classroom.get().setDepartment(department.get());
		classroom.get().setLevel(level.get());
		
		classroomRepository.save(classroom.get());
		
		return classroomModel;
	}
	
}
