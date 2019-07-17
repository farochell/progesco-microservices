/**
 * 
 */
package com.progesco.progescoschooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.progescoschooling.entity.EducationalRegistration;

/**
 * @author emile.camara
 *
 */
@Repository
public interface EducationalRegistrationRepository extends JpaRepository<EducationalRegistration, Long> {

}
