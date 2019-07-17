/**
 * 
 */
package com.progesco.pedagogy.model;

import com.progesco.pedagogy.entity.Course;

/**
 * @author emile
 *
 */
public class CourseModel extends Course {
	private long id;
	private String label;
	private long specialityId;
	private String registrationNumber;
	
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
	 * @return the specialityId
	 */
	public long getSpecialityId() {
		return specialityId;
	}
	/**
	 * @param specialityId the specialityId to set
	 */
	public void setSpecialityId(long specialityId) {
		this.specialityId = specialityId;
	}
	
}
