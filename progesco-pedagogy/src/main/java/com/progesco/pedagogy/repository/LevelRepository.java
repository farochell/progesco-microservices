/**
 * 
 */
package com.progesco.pedagogy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.pedagogy.entity.Level;

/**
 * @author emile
 *
 */
@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

}
