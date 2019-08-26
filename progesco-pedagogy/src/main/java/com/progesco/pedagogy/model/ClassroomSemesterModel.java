/**
 * 
 */
package com.progesco.pedagogy.model;

/**
 * @author emile.camara
 *
 */
public class ClassroomSemesterModel {
	private long id;
	private long classroom;
    private long speciality;
    private String label;
    
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
	 * @return the speciality
	 */
	public long getSpeciality() {
		return speciality;
	}
	/**
	 * @param speciality the speciality to set
	 */
	public void setSpeciality(long speciality) {
		this.speciality = speciality;
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
}
