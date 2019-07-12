/**
 * 
 */
package com.progesco.rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.rh.entity.Contract;

/**
 * @author emile.camara
 *
 */
@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

}
