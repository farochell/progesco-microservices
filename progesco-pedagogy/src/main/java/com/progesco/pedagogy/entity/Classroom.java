/**
 * 
 */
package com.progesco.pedagogy.entity;

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
@Table(name = "classroom", 
       uniqueConstraints = {
    		   @UniqueConstraint(columnNames = {"label", "department_id", "level_id"})
    		   }
)
public class Classroom {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="label", nullable=false, length=255)
	private String label;
	
	@ManyToOne
	private Department department;
	
	@ManyToOne
	private Level level;

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
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the level
	 */
	public Level getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Level level) {
		this.level = level;
	}
	
	
}
