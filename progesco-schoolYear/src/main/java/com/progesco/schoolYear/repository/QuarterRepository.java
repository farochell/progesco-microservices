/**
 * 
 */
package com.progesco.schoolYear.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.schoolYear.model.Quarter;

/**
 * @author emile
 *
 */
@Repository
public interface QuarterRepository extends JpaRepository<Quarter, Long> {

}
