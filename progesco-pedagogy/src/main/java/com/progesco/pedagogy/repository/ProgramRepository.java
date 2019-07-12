/**
 * 
 */
package com.progesco.pedagogy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.pedagogy.entity.Program;

/**
 * @author emile
 *
 */
@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

}
