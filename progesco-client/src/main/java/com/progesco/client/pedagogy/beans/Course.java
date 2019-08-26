/**
 * 
 */
package com.progesco.client.pedagogy.beans;

/**
 * @author emile
 *
 */
public class Course {
	private Long id;
	private String label;
	private String registrationNumber;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	
}
