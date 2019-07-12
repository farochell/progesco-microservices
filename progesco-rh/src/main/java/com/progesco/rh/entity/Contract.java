/**
 * 
 */
package com.progesco.rh.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author emile.camara
 *
 */
@Entity
@Table(name = "contract")
public class Contract {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="start_date", nullable=false, columnDefinition="DATE")
	private java.sql.Date startDate;
	
	@Column(name="end_date", nullable=true, columnDefinition="DATE")
	private java.sql.Date endDate;
	
	@Column(name="workplace", nullable=true, length=50)
	private String workplace;
	
	@ManyToOne (cascade=CascadeType.ALL)
	private TypeContract typeOfContract;
	
	@ManyToOne (cascade=CascadeType.ALL)	
	private Employee employee;

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
	 * @return the workplace
	 */
	public String getWorkplace() {
		return workplace;
	}

	/**
	 * @param workplace the workplace to set
	 */
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	/**
	 * @return the typeOfContract
	 */
	public TypeContract getTypeOfContract() {
		return typeOfContract;
	}

	/**
	 * @param typeOfContract the typeOfContract to set
	 */
	public void setTypeOfContract(TypeContract typeOfContract) {
		this.typeOfContract = typeOfContract;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}	
	
}
