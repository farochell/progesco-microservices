/**
 * 
 */
package com.progesco.pedagogy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.pedagogy.entity.Session;

/**
 * @author emile.camara
 *
 */
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

}
