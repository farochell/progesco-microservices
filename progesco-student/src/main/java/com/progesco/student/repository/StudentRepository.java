/**
 * 
 */
package com.progesco.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.student.model.Student;

/**
 * @author emile
 *
 */

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {

}
