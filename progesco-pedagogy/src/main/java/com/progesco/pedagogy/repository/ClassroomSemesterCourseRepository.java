/**
 * 
 */
package com.progesco.pedagogy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.pedagogy.entity.ClassroomSemester;
import com.progesco.pedagogy.entity.ClassroomSemesterCourse;
import com.progesco.pedagogy.entity.Course;

/**
 * @author emile.camara
 *
 */
@Repository
public interface ClassroomSemesterCourseRepository extends JpaRepository<ClassroomSemesterCourse, Long> {
   List<ClassroomSemesterCourse> findByClassroomSemester(ClassroomSemester classroomSemester);
   List<ClassroomSemesterCourse> findByCourse(Course course);
}
