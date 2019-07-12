/**
 * 
 */
package com.progesco.pedagogy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.pedagogy.entity.Course;

/**
 * @author emile
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
