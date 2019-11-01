/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.progesco.pedagogy.exception.ClassroomSemesterCourseForbiddenException;
import com.progesco.pedagogy.exception.ClassroomSemesterNotFoundException;
import com.progesco.pedagogy.utils.Constant;
import com.progesco.pedagogy.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.ClassroomSemester;
import com.progesco.pedagogy.entity.ClassroomSemesterCourse;
import com.progesco.pedagogy.entity.Course;
import com.progesco.pedagogy.model.ClassroomSemesterCourseModel;
import com.progesco.pedagogy.repository.ClassroomSemesterCourseRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile.camara
 *
 */
@Service("ClassroomSemesterCourseService")
public class ClassroomSemesterCourseService {
	@Autowired
	private ClassroomSemesterCourseRepository classroomSemesterCourseRepository;
	
	@Autowired
	private ClassroomSemesterService classroomSemesterService;
	
	@Autowired
	private CourseService courseService;

	@Value("${app.jwtSecret}")
	private String jwtSecret;
	
	/**
	 * Build a classroomSemesterCourse model
	 * @param classroomSemesterCourse
	 * @return
	 */
	private ClassroomSemesterCourseModel buildClassroomSemesterCourseModel(ClassroomSemesterCourse classroomSemesterCourse) {
		ClassroomSemesterCourseModel classroomSemesterCourseModel = new ClassroomSemesterCourseModel();
		classroomSemesterCourseModel.setId(classroomSemesterCourse.getId());
		classroomSemesterCourseModel.setClassroomSemester(classroomSemesterCourse.getClassroomSemester().getId());
		classroomSemesterCourseModel.setCredit(classroomSemesterCourse.getCredit());
		classroomSemesterCourseModel.setNbHours(classroomSemesterCourse.getNbHours());
		classroomSemesterCourseModel.setCourse(classroomSemesterCourse.getCourse().getId());
		
		return classroomSemesterCourseModel;
	}
	
	/**
	 * Allow to build classroomSemesterCourse entity
	 * @param classroomSemesterCourseModel
	 * @return
	 */
	private ClassroomSemesterCourse buildClassroomSemesterCourse(ClassroomSemesterCourseModel classroomSemesterCourseModel) {
		ClassroomSemesterCourse classroomSemesterCourse = null;
		if(Long.valueOf(classroomSemesterCourseModel.getId()) != null) {
			Optional<ClassroomSemesterCourse> classroomSemesterCourseOptional = classroomSemesterCourseRepository.findById(classroomSemesterCourseModel.getId());
			classroomSemesterCourse = classroomSemesterCourseOptional.get();
		} else {
			classroomSemesterCourse = new ClassroomSemesterCourse();
		}		 
		Optional<ClassroomSemester> classroomSemester = classroomSemesterService.findClassroomSemester(classroomSemesterCourseModel.getClassroomSemester());
		Optional<Course> course = courseService.findCourse(classroomSemesterCourseModel.getCourse());
		classroomSemesterCourse.setId(classroomSemesterCourseModel.getId());
		classroomSemesterCourse.setClassroomSemester(classroomSemester.get());
		classroomSemesterCourse.setCredit(classroomSemesterCourseModel.getCredit());
		classroomSemesterCourse.setCourse(course.get());
		
		return classroomSemesterCourse;
	}
	
	/**
	 * Return all ClassroomSemesterCourse
	 * @param request
	 * @return
	 */
	public List<ClassroomSemesterCourseModel> getAllClassroomSemesterCourses(HttpServletRequest request){
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_CLASSROOM_SEMESTER_COURSE_VIEW, this.jwtSecret)) {
			throw new ClassroomSemesterCourseForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		List<ClassroomSemesterCourseModel> classroomSemesterCourseModels = new ArrayList<>();
		List<ClassroomSemesterCourse> classroomSemesterCourses = classroomSemesterCourseRepository.findAll();
		for(ClassroomSemesterCourse classroomSemesterCourse: classroomSemesterCourses) {
			classroomSemesterCourseModels.add(buildClassroomSemesterCourseModel(classroomSemesterCourse));
		}
		return classroomSemesterCourseModels;
	}
	
	/**
	 * Return all ClassroomSemesterCourse by Course ID
	 * @param id
	 * @param request
	 * @return
	 */
	public List<ClassroomSemesterCourseModel> getAllClassroomSemesterCoursesByCourse(Long id, HttpServletRequest request){
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_CLASSROOM_SEMESTER_COURSE_VIEW, this.jwtSecret)) {
			throw new ClassroomSemesterCourseForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		List<ClassroomSemesterCourseModel> classroomSemesterCourseModels = new ArrayList<>();
		Optional<Course> course = courseService.findCourse(id);
		List<ClassroomSemesterCourse> classroomSemesterCourses = classroomSemesterCourseRepository.findByCourse(course.get());
		for(ClassroomSemesterCourse classroomSemesterCourse: classroomSemesterCourses) {
			classroomSemesterCourseModels.add(buildClassroomSemesterCourseModel(classroomSemesterCourse));
		}
		return classroomSemesterCourseModels;
	}
	
	/**
	 * Return all ClassroomSemesterCourse by ClassroomSemester ID 
	 * @param id
	 * @param request
	 * @return
	 */
	public List<ClassroomSemesterCourseModel> getAllClassroomSemesterCoursesByClassroomSemester(Long id, HttpServletRequest request){
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_CLASSROOM_SEMESTER_COURSE_VIEW, this.jwtSecret)) {
			throw new ClassroomSemesterCourseForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

		List<ClassroomSemesterCourseModel> classroomSemesterCourseModels = new ArrayList<>();
		Optional<ClassroomSemester> classroomSemester = classroomSemesterService.findClassroomSemester(id);
		List<ClassroomSemesterCourse> classroomSemesterCourses = classroomSemesterCourseRepository.findByClassroomSemester(classroomSemester.get());
		for(ClassroomSemesterCourse classroomSemesterCourse: classroomSemesterCourses) {
			classroomSemesterCourseModels.add(buildClassroomSemesterCourseModel(classroomSemesterCourse));
		}
		return classroomSemesterCourseModels;
	}
	
	/**
	 * Allow to add a new classroomSemesterCourse entity
	 * @param classroomSemesterCourseModel
	 * @param request
	 * @return
	 */
	public ClassroomSemesterCourseModel addClassroomSemesterCourse(ClassroomSemesterCourseModel classroomSemesterCourseModel, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_CLASSROOM_SEMESTER_COURSE_ADD, this.jwtSecret)) {
			throw new ClassroomSemesterCourseForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		ClassroomSemesterCourse classroomSemesterCourse = buildClassroomSemesterCourse(classroomSemesterCourseModel);
		
		classroomSemesterCourseRepository.save(classroomSemesterCourse);
		classroomSemesterCourseModel.setId(classroomSemesterCourse.getId());
		
		return classroomSemesterCourseModel;		
	}
	
	/**
	 * Allow to update classroomSemesterCourse entity
	 * @param classroomSemesterCourseModel
	 * @param request
	 * @return
	 */
	public ClassroomSemesterCourseModel updateClassroomSemesterCourse(ClassroomSemesterCourseModel classroomSemesterCourseModel, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_CLASSROOM_SEMESTER_COURSE_UPD, this.jwtSecret)) {
			throw new ClassroomSemesterCourseForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		ClassroomSemesterCourse classroomSemesterCourse = buildClassroomSemesterCourse(classroomSemesterCourseModel);
		classroomSemesterCourseRepository.save(classroomSemesterCourse);
		return classroomSemesterCourseModel;
	}
	
	/**
	 * Retrieve a classroomSemesterCourse entity by given ID
	 * @param id
	 * @return
	 */
	public Optional<ClassroomSemesterCourse> findClassroomSemesterCourse(Long id) {
		return classroomSemesterCourseRepository.findById(id);
	}

	/**
	 * Retrieve a course
	 * @param id
	 * @param request
	 * @return
	 */
	public ClassroomSemesterCourse retrieveCourse(Long id, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_CLASSROOM_SEMESTER_COURSE_VIEW, this.jwtSecret)) {
			throw new ClassroomSemesterCourseForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

		Optional<ClassroomSemesterCourse> course = this.findClassroomSemesterCourse(id);

		if(!course.isPresent()) {
			throw new ClassroomSemesterNotFoundException("Id non touvé: " + id);
		}

		return course.get();

	}
}
