/**
 * 
 */
package com.progesco.rh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author emile.camara
 *
 */
@Entity
@Table(name = "employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="last_name", nullable=false, length=100)
	private String lastName;
	
	@Column(name="first_name", nullable=false, length=100)
	private String firstName;
	
	@Column(name="birth_date", nullable=false, columnDefinition="DATE")
	private java.sql.Date birthDate;
	
	@Column(name="place_of_birth", nullable=false, length=100)
	private String placeOfBirth;
	
	@Column(name="registration_number", nullable=false, length=10)
	private String registrationNumber;
	
	@Column(name="email", nullable=true, length=100)
	private String email;
	
	@Column(name="main_phone", nullable=true, length=10)
	private String mainPhone;
	
	@Column(name="second_phone", nullable=true, length=10)
	private String secondPhone;
	
	@Column(name="nationality", nullable=true, length=20)
	private String nationality;
	
	@Column(name="marital_status", nullable=false, length=10)
	private String maritalStatus;
	
	@Column(name="gender", nullable=false, length=2)
	private String gender;
	
	@Column(name="nb_child", nullable=false, length=2)
	private Integer nbChild;

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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the birthDate
	 */
	public java.sql.Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the placeOfBirth
	 */
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	/**
	 * @param placeOfBirth the placeOfBirth to set
	 */
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mainPhone
	 */
	public String getMainPhone() {
		return mainPhone;
	}

	/**
	 * @param mainPhone the mainPhone to set
	 */
	public void setMainPhone(String mainPhone) {
		this.mainPhone = mainPhone;
	}

	/**
	 * @return the secondPhone
	 */
	public String getSecondPhone() {
		return secondPhone;
	}

	/**
	 * @param secondPhone the secondPhone to set
	 */
	public void setSecondPhone(String secondPhone) {
		this.secondPhone = secondPhone;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the maritalStatus
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the nbChild
	 */
	public Integer getNbChild() {
		return nbChild;
	}

	/**
	 * @param nbChild the nbChild to set
	 */
	public void setNbChild(Integer nbChild) {
		this.nbChild = nbChild;
	}
	
	
}
