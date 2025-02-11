/**
 * 
 */
package com.progesco.schoolYear.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.progesco.schoolYear.entity.SchoolYear;

/**
 * @author emile
 *
 */
@Repository
public interface SchoolYearRepository extends JpaRepository<SchoolYear, Long> {
	@Query("SELECT u FROM SchoolYear u WHERE u.isActive=1")
	Optional<SchoolYear> findOneByIsActive();
}
