/**
 * 
 */
package com.progesco.pedagogy.model;

/**
 * @author emile.camara
 *
 */
public class GroupModel {
    private Long id;
    private String label;
    private Long classroomId;
    private Long schoolYear;
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
	/**
	 * @return the schoolYear
	 */
	public Long getSchoolYear() {
		return schoolYear;
	}
	/**
	 * @param schoolYear the schoolYear to set
	 */
	public void setSchoolYear(Long schoolYear) {
		this.schoolYear = schoolYear;
	}
	
}
