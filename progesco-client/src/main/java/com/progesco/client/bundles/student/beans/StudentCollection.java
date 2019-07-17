/**
 * 
 */
package com.progesco.client.bundles.student.beans;

import java.util.List;

/**
 * @author emile.camara
 *
 */
public class StudentCollection {
	private List<Integer> totalItems;
    private List<Student> studentModels;
	/**
	 * @return the totalItems
	 */
	public List<Integer> getTotalItems() {
		return totalItems;
	}
	/**
	 * @param totalItems the totalItems to set
	 */
	public void setTotalItems(List<Integer> totalItems) {
		this.totalItems = totalItems;
	}
	/**
	 * @return the students
	 */
	public List<Student> getStudentModels() {
		return studentModels;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudentModels(List<Student> studentModels) {
		this.studentModels = studentModels;
	}
	
}
