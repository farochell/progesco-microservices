/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Course;
import com.progesco.pedagogy.entity.Speciality;
import com.progesco.pedagogy.exception.CourseNotFoundException;
import com.progesco.pedagogy.model.CourseModel;
import com.progesco.pedagogy.repository.CourseRepository;

/**
 * @author emile
 *
 */
@Service("CourseService")
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SpecialityService specialityService;
	
	/**
	 * Fonction permettant de construire l'objet courseModel
	 * @param course
	 * @return
	 */
	public CourseModel buildCourseModel(Course course) {
		CourseModel courseModel = new CourseModel();
		courseModel.setId(course.getId());
		courseModel.setLabel(course.getLabel());
		courseModel.setRegistrationNumber(course.getRegistrationNumber());
		courseModel.setSpecialityId(course.getSpeciality().getId());
		
		return courseModel;
	}
	
	/**
	 * Return all courses
	 * @return
	 */
	public List<CourseModel> getAllCourses() {
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
	 */
	public CourseModel addCourse(CourseModel courseModel) {
		Optional<Speciality> speciality = specialityService.findSpeciality(courseModel.getSpecialityId());
		Course course = new Course();
		course.setLabel(courseModel.getLabel());
		course.setRegistrationNumber(courseModel.getRegistrationNumber());
		course.setSpeciality(speciality.get());
		courseRepository.save(course);
		
		courseModel.setId(course.getId());
		
		return courseModel;
	}
	
	/**
	 * Retrieve course by ID
	 * @param id
	 * @return
	 */
	public CourseModel findCourse(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		
		if(!course.isPresent()) {
			throw new CourseNotFoundException("Enregistrement non trouvé. ID:" + id);
		}
		
		return  buildCourseModel(course.get());
	}
	
	/**
	 * Update a course record
	 * @param courseModel
	 * @return
	 */
	public CourseModel updateCourse(CourseModel courseModel) {
		Optional<Speciality> speciality = specialityService.findSpeciality(courseModel.getSpecialityId());
		Course course = new Course();
		course.setId(courseModel.getId());
		course.setLabel(courseModel.getLabel());
		course.setRegistrationNumber(courseModel.getRegistrationNumber());
		course.setSpeciality(speciality.get());
		
		courseRepository.save(course);
		
		return courseModel;
	}
}
