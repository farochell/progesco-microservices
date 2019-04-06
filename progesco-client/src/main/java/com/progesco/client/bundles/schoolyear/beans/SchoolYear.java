/**
 * 
 */
package com.progesco.client.bundles.schoolyear.beans;

/**
 * @author emile
 *
 */
public class SchoolYear {
	private long id;
	private String label;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private boolean isActive;
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
	 * @return the startDate
	 */
	public java.sql.Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public java.sql.Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
