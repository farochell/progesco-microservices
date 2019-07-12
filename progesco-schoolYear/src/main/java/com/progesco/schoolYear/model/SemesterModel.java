/**
 * 
 */
package com.progesco.schoolYear.model;

/**
 * @author emile
 *
 */
public class SemesterModel {
	private long id;
	private String label;
	private Integer rankid;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private int level;
	private long schoolyearId;
	
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
	 * @return the rankid
	 */
	public Integer getRankid() {
		return rankid;
	}
	
	/**
	 * @param rankid the rankid to set
	 */
	public void setRankid(Integer rankid) {
		this.rankid = rankid;
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
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * @return the schoolyearId
	 */
	public long getSchoolyearId() {
		return schoolyearId;
	}
	
	/**
	 * @param schoolyearId the schoolyearId to set
	 */
	public void setSchoolyearId(long schoolyearId) {
		this.schoolyearId = schoolyearId;
	}
	
	
}
