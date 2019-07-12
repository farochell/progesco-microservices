/**
 * 
 */
package com.progesco.rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.rh.entity.TypeContract;

/**
 * @author emile.camara
 *
 */
@Repository
public interface TypeContractRepository extends JpaRepository<TypeContract, Long> {

}
