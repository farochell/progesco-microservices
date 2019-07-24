/**
 * 
 */
package com.progesco.client.bundles.schooling.beans;

/**
 * @author emile.camara
 *
 */
public class EducationalRegistration {
	private long id;
	private long schoolYear;
	private long classroom;
	private long student;
	private long session;
	private String registrationNumber;
	private Integer status;
	private java.sql.Date createdAt;
	
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
	
	
}
