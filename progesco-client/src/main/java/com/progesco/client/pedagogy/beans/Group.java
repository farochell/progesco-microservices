package com.progesco.client.pedagogy.beans;

/**
 * 
 * @author emile.camara
 *
 */
public class Group {
	private Long id;
	private String label;
	private Long classroomId;
	
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
	 * @return the classroomId
	 */
	public Long getClassroomId() {
		return classroomId;
	}

	/**
	 * @param classroomId the classroomId to set
	 */
	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}	
	
}
