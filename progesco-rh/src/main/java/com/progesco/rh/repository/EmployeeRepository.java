package com.progesco.rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.rh.entity.Employee;

/**
 * 
 * @author emile.camara
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
