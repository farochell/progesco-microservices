/**
 * 
 */
package com.progesco.schoolYear.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.schoolYear.entity.SchoolYear;
import com.progesco.schoolYear.entity.Semester;

/**
 * @author emile
 *
 */
@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
	 List<Semester> findBySchoolyear(SchoolYear schoolYear);
}
