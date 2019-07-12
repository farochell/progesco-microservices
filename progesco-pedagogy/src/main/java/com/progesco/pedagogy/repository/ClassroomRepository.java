/**
 * 
 */
package com.progesco.pedagogy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.pedagogy.entity.Classroom;

/**
 * @author emile
 *
 */
@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
