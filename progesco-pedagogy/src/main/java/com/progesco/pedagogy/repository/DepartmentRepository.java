/**
 * 
 */
package com.progesco.pedagogy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.pedagogy.entity.Department;

/**
 * @author emile
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
