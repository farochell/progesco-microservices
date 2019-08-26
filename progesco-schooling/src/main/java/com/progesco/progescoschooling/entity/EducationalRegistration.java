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
@Table(name = "educational_registration",
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"schoolyear_id", "student_id"})
	)
@EntityListeners(AuditingEntityListener.class)
public class EducationalRegistration {
	public static final Integer STATUS_INIT   = 1;
	public static final Integer STATUS_VALID  = 2;
	public static final Integer STATUS_REPORT = 3;
	public static final Integer STATUS_ABD    = 4;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="schoolyear_id", nullable=false)
	private long schoolYear;
	
	@Column(name="classroom_id", nullable=false)
	private long classroom;
	
	@Column(name="student_id", nullable=false)
	private long student;
	
	@Column(name="session_id", nullable=false)
	private long session;
	
	@Column(name="registration_number", nullable=true, length=20)
	private String registrationNumber;
	
	@CreatedDate
	@Column(name="created_at", nullable=true)
	private Date createdAt;
	
	@Column(name="status", nullable=true)
	private Integer status;
	
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
	 * @return the session
	 */
	public long getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(long session) {
		this.session = session;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
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
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
	
	/**
	 * Default constructor
	 */
	public EducationalRegistration() {
		this.status = EducationalRegistration.STATUS_INIT;
	}
	
}
