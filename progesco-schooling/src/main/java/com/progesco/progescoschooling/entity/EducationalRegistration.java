/**
 * 
 */
package com.progesco.progescoschooling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

/**
 * @author emile.camara
 *
 */
@Entity
@Table(name = "educational_registration")
public class EducationalRegistration {
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
	@Column(name="created_at", nullable=false, columnDefinition="DATETIME")
	private java.sql.Date createdAt;
	
	@Column(name="status", nullable=false)
	private Integer status;

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
	public java.sql.Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(java.sql.Date createdAt) {
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
	
	
}
