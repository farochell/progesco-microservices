/**
 * 
 */
package com.progesco.pedagogy.model;

import java.util.List;

/**
 * @author emile.camara
 *
 */
public class GroupModelCollection {
	private List<Integer> totalItems;
	private List<GroupModel> groupModels;
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
	public List<GroupModel> getGroupModels() {
		return groupModels;
	}
	/**
	 * @param groupModels the groupModels to set
	 */
	public void setGroupModels(List<GroupModel> groupModels) {
		this.groupModels = groupModels;
	}
	
	
}
