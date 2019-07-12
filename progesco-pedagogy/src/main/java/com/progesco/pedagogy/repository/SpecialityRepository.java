/**
 * 
 */
package com.progesco.pedagogy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.pedagogy.entity.Speciality;

/**
 * @author emile
 *
 */
@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

}
