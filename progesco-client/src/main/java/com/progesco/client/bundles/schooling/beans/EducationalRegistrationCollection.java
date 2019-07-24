/**
 * 
 */
package com.progesco.client.bundles.schooling.beans;

import java.util.List;

/**
 * @author emile.camara
 *
 */
public class EducationalRegistrationCollection {
	private List<Integer> totalItems;
    private List<EducationalRegistration> educationalRegistrationModels;
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
	public List<EducationalRegistration> getEducationalRegistrationModels() {
		return educationalRegistrationModels;
	}
	/**
	 * @param educationalRegistrationModels the educationalRegistrationModels to set
	 */
	public void setEducationalRegistrationModels(List<EducationalRegistration> educationalRegistrationModels) {
		this.educationalRegistrationModels = educationalRegistrationModels;
	}
    
    
}
