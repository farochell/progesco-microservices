/**
 * 
 */
package com.progesco.schoolYear.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author emile
 *
 */
@Entity
@Table(name = "semester",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"label", "level", "schoolyear_id"})}
)
public class Semester {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="label", nullable=false, length=20)
	private String label;
	
	@Column(name="rankid")
	private Integer rankid;
	
	@Column(name="start_date", nullable=false, columnDefinition="DATE")
	private java.sql.Date startDate;
	
	@Column(name="end_date", nullable=false, columnDefinition="DATE")
	private java.sql.Date endDate;
	
	@Column(name="level", nullable=false)
	private int level;
	
	@ManyToOne (cascade=CascadeType.ALL)	
	private SchoolYear schoolyear;

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
	 * @return the schoolyear
	 */
	public SchoolYear getSchoolyear() {
		return schoolyear;
	}

	/**
	 * @param schoolyear the schoolyear to set
	 */
	public void setSchoolyear(SchoolYear schoolyear) {
		this.schoolyear = schoolyear;
	}	
	
	@Override
	public String toString() {
		return this.label;
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
	
}
