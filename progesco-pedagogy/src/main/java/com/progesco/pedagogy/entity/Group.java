/**
 * 
 */
package com.progesco.pedagogy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author emile.camara
 *
 */
@Entity
@Table(name = "group_tb", 
       uniqueConstraints = {
    		   @UniqueConstraint(columnNames = {"label"})
    		   }
)
@EntityListeners(AuditingEntityListener.class)
public class Group {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="label", nullable=false, length=255)
	private String label;
	
	@ManyToOne
	private Classroom classroom;
	
	@Column(name="schoolyear_id", nullable=false)
	private long schoolYear;
	
	@Column(name="capacity", nullable=false)
	private long capacity;
	
	@CreatedDate
	@Column(name="created_at", nullable=true)
	private Date createdAt;
	
	@LastModifiedDate
	@Column(name="updated_at", nullable=true)
	private Date updatedAt;


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
	 * @return the classroom
	 */
	public Classroom getClassroom() {
		return classroom;
	}

	/**
	 * @param classroom the classroom to set
	 */
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the schoolYear
	 */
	public long getSchoolYear() {
		return schoolYear;
	}

	/**
	 * @param schoolYear the schoolYear to set
	 */
	public void setSchoolYear(long schoolYear) {
		this.schoolYear = schoolYear;
	}

	/**
	 * @return the capacity
	 */
	public long getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

}
