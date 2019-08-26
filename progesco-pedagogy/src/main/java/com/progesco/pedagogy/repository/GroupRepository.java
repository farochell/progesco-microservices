/**
 * 
 */
package com.progesco.pedagogy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.pedagogy.entity.Classroom;
import com.progesco.pedagogy.entity.Group;

/**
 * @author emile.camara
 *
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
   List<Group> findByClassroom(Classroom classroom);
}
