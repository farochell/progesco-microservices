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
 * @author emile.camara
 *
 */
@Entity
@Table(name = "classroom_semester_course",
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"classroom_semester_id", "course_id"})
	)
@EntityListeners(AuditingEntityListener.class)
public class ClassroomSemesterCourse {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ManyToOne (cascade=CascadeType.ALL)
	private ClassroomSemester classroomSemester;
	
	@ManyToOne (cascade=CascadeType.ALL)
	private Course course;
	
	@Column(name="nb_hours", nullable=false)
	private int nbHours;
	
	@Column(name="credit", nullable=false)
	private Float credit;

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
	 * @return the classroomSemester
	 */
	public ClassroomSemester getClassroomSemester() {
		return classroomSemester;
	}

	/**
	 * @param classroomSemester the classroomSemester to set
	 */
	public void setClassroomSemester(ClassroomSemester classroomSemester) {
		this.classroomSemester = classroomSemester;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the nbHours
	 */
	public int getNbHours() {
		return nbHours;
	}

	/**
	 * @param nbHours the nbHours to set
	 */
	public void setNbHours(int nbHours) {
		this.nbHours = nbHours;
	}

	/**
	 * @return the credit
	 */
	public Float getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(Float credit) {
		this.credit = credit;
	}
}
