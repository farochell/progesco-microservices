/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.progesco.pedagogy.exception.CourseForbiddenException;
import com.progesco.pedagogy.utils.Constant;
import com.progesco.pedagogy.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Course;
import com.progesco.pedagogy.exception.CourseNotFoundException;
import com.progesco.pedagogy.model.CourseModel;
import com.progesco.pedagogy.repository.CourseRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile
 *
 */
@Service("CourseService")
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Value("${app.jwtSecret}")
	private String jwtSecret;
	
	/**
	 * This function allows to build Course model
	 * @param course
	 * @return
	 */
	public CourseModel buildCourseModel(Course course) {
		CourseModel courseModel = new CourseModel();
		courseModel.setId(course.getId());
		courseModel.setLabel(course.getLabel());
		courseModel.setRegistrationNumber(course.getRegistrationNumber());
		
		return courseModel;
	}

	/**
	 * Return all courses
	 * @param request
	 * @return
	 */
	public List<CourseModel> getAllCourses(HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_COURSE_VIEW, this.jwtSecret)) {
			throw new CourseForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		List<Course> courses = courseRepository.findAll();
		List<CourseModel> courseModels = new ArrayList<>();
		for (Course course: courses) {			
			courseModels.add(buildCourseModel(course));
		}
		
		return courseModels;
	}

	/**
	 * Add a new course
	 * @param courseModel
	 * @param request
	 * @return
	 */
	public CourseModel addCourse(CourseModel courseModel, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_COURSE_ADD, this.jwtSecret)) {
			throw new CourseForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		Course course = new Course();
		course.setLabel(courseModel.getLabel());
		course.setRegistrationNumber(courseModel.getRegistrationNumber());
		courseRepository.save(course);
		
		courseModel.setId(course.getId());
		
		return courseModel;
	}
	
	/**
	 * Retrieve course by ID
	 * @param id
	 * @return
	 */
	public Optional<Course> findCourse(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		
		if(!course.isPresent()) {
			throw new CourseNotFoundException("Enregistrement non trouvé. ID:" + id);
		}
		
		return  course;
	}
	
	/**
	 * Update a course record
	 * @param courseModel
	 * @return
	 */
	public CourseModel updateCourse(CourseModel courseModel, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request, Constant.ROLE_COURSE_UPD, this.jwtSecret)) {
			throw new CourseForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
		Course course = new Course();
		course.setId(courseModel.getId());
		course.setLabel(courseModel.getLabel());
		course.setRegistrationNumber(courseModel.getRegistrationNumber());
		
		courseRepository.save(course);
		
		return courseModel;
	}
}
