/**
 * 
 */
package com.progesco.pedagogy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progesco.pedagogy.entity.Classroom;
import com.progesco.pedagogy.entity.ClassroomSemester;

/**
 * @author emile.camara
 *
 */
@Repository
public interface ClassroomSemesterRepository extends JpaRepository<ClassroomSemester, Long> {
    List<ClassroomSemester> findByClassroom(Classroom classroom);
}
