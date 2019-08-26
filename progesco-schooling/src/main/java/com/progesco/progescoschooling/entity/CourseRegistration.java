/**
 * 
 */
package com.progesco.progescoschooling.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author emile.camara
 *
 */
@Entity
@Table(name = "course_registration",
uniqueConstraints=
    @UniqueConstraint(columnNames={"schoolyear_id", "student_id", "course_id"})
)
@EntityListeners(AuditingEntityListener.class)
public class CourseRegistration {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="schoolyear_id", nullable=false)
	private long schoolYear;
	
	@Column(name="student_id", nullable=false)
	private long student;
	
	@Column(name="course_id", nullable=false)
	private long course;
	
	@Column(name="classroom_id", nullable=false)
	private long classroom;
	
	@CreatedDate
	@Column(name="created_at", nullable=true)
	private Date createdAt;
	
	@LastModifiedDate
	@Column(name="updated_at", nullable=true)
	private Date updatedAt;

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
	 * @return the schoolYear
	 */
	public long getSchoolYear() {
		return schoolYear;
	}

	/**
	 * @param schoolYear the schoolYear to set
	 */
	public void setSchoolYear(long schoolYear) {
		this.schoolYear = schoolYear;
	}

	/**
	 * @return the student
	 */
	public long getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(long student) {
		this.student = student;
	}

	/**
	 * @return the course
	 */
	public long getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(long course) {
		this.course = course;
	}

	/**
	 * @return the classroom
	 */
	public long getClassroom() {
		return classroom;
	}

	/**
	 * @param classroom the classroom to set
	 */
	public void setClassroom(long classroom) {
		this.classroom = classroom;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
