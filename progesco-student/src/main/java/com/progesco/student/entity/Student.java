/**
 * 
 */
package com.progesco.student.entity;

import javax.persistence.Column;
/**
 * @author emile
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * 
 * @author emile
 *
 */
@Entity
@Table(name = "student")
public class Student {
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
	
	@Column(name="registration_number", nullable=true, length=10)
	private String registrationNumber;
	
	@Column(name="email", nullable=true, length=100)
	private String email;
	
	@Column(name="main_phone", nullable=true, length=10)
	private String mainPhone;
	
	@Column(name="second_phone", nullable=true, length=10)
	private String secondPhone;
	
	@Column(name="father_lastname", nullable=false, length=50)
	private String fatherLastname;
	
	@Column(name="father_firstname", nullable=false, length=50)
	private String fatherFirstname;
	
	@Column(name="mother_lastname", nullable=false, length=50)
	private String motherLastname;
	
	@Column(name="mother_firstname", nullable=false, length=50)
	private String motherFirstname;
	
	@Column(name="father_profession", nullable=false, length=50)
	private String fatherProfession;
	
	@Column(name="mother_profession", nullable=false, length=50)
	private String motherProfession;
	
	@Column(name="marital_status", nullable=false, length=10)
	private String maritalStatus;
	
	@Column(name="gender", nullable=false, length=2)
	private String gender;
	
	@Column(name="guardian_lastname", nullable=false, length=50)
	private String guardianLastname;
	
	@Column(name="guardian_firstname", nullable=false, length=50)
	private String guardianFirstname;
	
	@Column(name="guardian_main_phone", nullable=false, length=10)
	private String guardianMainPhone;
	
	@Column(name="guardian_second_phone", nullable=false, length=10)
	private String guardianSecondPhone;
	
	@Column(name="guardian_address", nullable=false, length=255)
	private String guardianAddress;
	
	@Column(name="nb_child", nullable=false, length=2)
	private Integer nbChild;
	
	@Column(name="address", nullable=false, length=255)
	private String address;
	
	@CreatedDate
	@Column(name="created_at", nullable=false, columnDefinition="DATETIME")
	private java.sql.Date createdAt;	
	
	@LastModifiedDate
	@Column(name="updated_at", nullable=true, columnDefinition="DATETIME")
	private java.sql.Date updatedAt;
	
	@Column(name="created_by", nullable=true, length=50)
	private String createdBy;
	
	@Column(name="modified_by", nullable=true, length=50)
	private String modifiedBy;

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
	 * @return the fatherLastname
	 */
	public String getFatherLastname() {
		return fatherLastname;
	}

	/**
	 * @param fatherLastname the fatherLastname to set
	 */
	public void setFatherLastname(String fatherLastname) {
		this.fatherLastname = fatherLastname;
	}

	/**
	 * @return the fatherFirstname
	 */
	public String getFatherFirstname() {
		return fatherFirstname;
	}

	/**
	 * @param fatherFirstname the fatherFirstname to set
	 */
	public void setFatherFirstname(String fatherFirstname) {
		this.fatherFirstname = fatherFirstname;
	}

	/**
	 * @return the motherLastname
	 */
	public String getMotherLastname() {
		return motherLastname;
	}

	/**
	 * @param motherLastname the motherLastname to set
	 */
	public void setMotherLastname(String motherLastname) {
		this.motherLastname = motherLastname;
	}

	/**
	 * @return the motherFirstname
	 */
	public String getMotherFirstname() {
		return motherFirstname;
	}

	/**
	 * @param motherFirstname the motherFirstname to set
	 */
	public void setMotherFirstname(String motherFirstname) {
		this.motherFirstname = motherFirstname;
	}

	/**
	 * @return the fatherProfession
	 */
	public String getFatherProfession() {
		return fatherProfession;
	}

	/**
	 * @param fatherProfession the fatherProfession to set
	 */
	public void setFatherProfession(String fatherProfession) {
		this.fatherProfession = fatherProfession;
	}

	/**
	 * @return the motherProfession
	 */
	public String getMotherProfession() {
		return motherProfession;
	}

	/**
	 * @param motherProfession the motherProfession to set
	 */
	public void setMotherProfession(String motherProfession) {
		this.motherProfession = motherProfession;
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
	 * @return the guardianLastname
	 */
	public String getGuardianLastname() {
		return guardianLastname;
	}

	/**
	 * @param guardianLastname the guardianLastname to set
	 */
	public void setGuardianLastname(String guardianLastname) {
		this.guardianLastname = guardianLastname;
	}

	/**
	 * @return the guardianFirstname
	 */
	public String getGuardianFirstname() {
		return guardianFirstname;
	}

	/**
	 * @param guardianFirstname the guardianFirstname to set
	 */
	public void setGuardianFirstname(String guardianFirstname) {
		this.guardianFirstname = guardianFirstname;
	}

	/**
	 * @return the guardianMainPhone
	 */
	public String getGuardianMainPhone() {
		return guardianMainPhone;
	}

	/**
	 * @param guardianMainPhone the guardianMainPhone to set
	 */
	public void setGuardianMainPhone(String guardianMainPhone) {
		this.guardianMainPhone = guardianMainPhone;
	}

	/**
	 * @return the guardianSecondPhone
	 */
	public String getGuardianSecondPhone() {
		return guardianSecondPhone;
	}

	/**
	 * @param guardianSecondPhone the guardianSecondPhone to set
	 */
	public void setGuardianSecondPhone(String guardianSecondPhone) {
		this.guardianSecondPhone = guardianSecondPhone;
	}

	/**
	 * @return the guardianAddress
	 */
	public String getGuardianAddress() {
		return guardianAddress;
	}

	/**
	 * @param guardianAddress the guardianAddress to set
	 */
	public void setGuardianAddress(String guardianAddress) {
		this.guardianAddress = guardianAddress;
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

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the createdAt
	 */
	public java.sql.Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(java.sql.Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public java.sql.Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(java.sql.Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	
}
