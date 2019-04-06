/**
 * 
 */
package com.progesco.schoolYear.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.schoolYear.model.SchoolYear;

/**
 * @author emile
 *
 */
@Repository
public interface SchoolYearRepository extends JpaRepository<SchoolYear, Long>{

}
