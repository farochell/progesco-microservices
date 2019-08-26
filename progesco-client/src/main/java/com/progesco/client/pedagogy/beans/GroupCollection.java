/**
 * 
 */
package com.progesco.client.pedagogy.beans;

import java.util.List;

/**
 * @author emile.camara
 *
 */
public class GroupCollection {
	private List<Integer> totalItems;
    private List<Group> groupModels;
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
	 * @return the groupModels
	 */
	public List<Group> getGroupModels() {
		return groupModels;
	}
	/**
	 * @param groupModels the groupModels to set
	 */
	public void setGroupModels(List<Group> groupModels) {
		this.groupModels = groupModels;
	}
    
}
