/**
 * 
 */
package com.progesco.student.model;

import java.util.List;

/**
 * @author emile.camara
 *
 */
public class StudentCollectionModel {
    private List<Integer> totalItems;
    private List<StudentModel> studentModels;
	/**
	 * @return the totalItems
	 */
	public List<Integer> getTotalItems() {
		return totalItems;
	}
	
	/**
	 * @param pageNumbers the totalItems to set
	 */
	public void setTotalItems(List<Integer> pageNumbers) {
		this.totalItems = pageNumbers;
	}
	/**
	 * @return the studentModels
	 */
	public List<StudentModel> getStudentModels() {
		return studentModels;
	}
	/**
	 * @param studentModels the studentModels to set
	 */
	public void setStudentModels(List<StudentModel> studentModels) {
		this.studentModels = studentModels;
	}
    
    
}
