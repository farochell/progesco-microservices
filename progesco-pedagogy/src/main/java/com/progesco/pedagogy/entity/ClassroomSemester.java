/**
 * 
 */
package com.progesco.pedagogy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Cette table de définir les semestres de chaque classe
 * Par exemple: L1 
 * @author emile.camara
 *
 */
@Entity
@Table(name = "classroom_semester",
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"classroom_id", "label", "speciality_id"})
	)
@EntityListeners(AuditingEntityListener.class)
public class ClassroomSemester {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ManyToOne
	private Classroom classroom;
	
	@Column(name="label", nullable=false, length=255)
	private String label;
	
	@ManyToOne
	private Speciality speciality;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the classroom
	 */
	public Classroom getClassroom() {
		return classroom;
	}

	/**
	 * @param classroom the classroom to set
	 */
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the speciality
	 */
	public Speciality getSpeciality() {
		return speciality;
	}

	/**
	 * @param speciality the speciality to set
	 */
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	
	
}
