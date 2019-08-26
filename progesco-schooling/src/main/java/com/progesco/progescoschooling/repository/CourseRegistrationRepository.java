/**
 * 
 */
package com.progesco.progescoschooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.progescoschooling.entity.CourseRegistration;

/**
 * @author emile.camara
 *
 */
@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {

}
