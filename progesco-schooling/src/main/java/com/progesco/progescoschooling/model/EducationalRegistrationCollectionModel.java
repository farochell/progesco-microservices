/**
 * 
 */
package com.progesco.progescoschooling.model;

import java.util.List;

/**
 * @author emile.camara
 *
 */
public class EducationalRegistrationCollectionModel {
	private List<Integer> totalItems;
    private List<EducationalRegistrationModel> educationalRegistrationModels;
    
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
	 * @return the educationalRegistrationModels
	 */
	public List<EducationalRegistrationModel> getEducationalRegistrationModels() {
		return educationalRegistrationModels;
	}
	
	/**
	 * @param educationalRegistrationModels the educationalRegistrationModels to set
	 */
	public void setEducationalRegistrationModels(List<EducationalRegistrationModel> educationalRegistrationModels) {
		this.educationalRegistrationModels = educationalRegistrationModels;
	}
    
}
