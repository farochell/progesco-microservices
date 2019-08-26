/**
 * 
 */
package com.progesco.pedagogy.model;

/**
 * @author emile.camara
 *
 */
public class ClassroomSemesterCourseModel {
	private long id;
	private long classroomSemester;
    private Float credit;
    private int nbHours;
    private long course;
    
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
	 * @return the classroomSemester
	 */
	public long getClassroomSemester() {
		return classroomSemester;
	}
	
	/**
	 * @param classroomSemester the classroomSemester to set
	 */
	public void setClassroomSemester(long classroomSemester) {
		this.classroomSemester = classroomSemester;
	}
	
	/**
	 * @return the credit
	 */
	public Float getCredit() {
		return credit;
	}
	
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(Float credit) {
		this.credit = credit;
	}
	
	/**
	 * @return the nbHours
	 */
	public int getNbHours() {
		return nbHours;
	}
	
	/**
	 * @param nbHours the nbHours to set
	 */
	public void setNbHours(int nbHours) {
		this.nbHours = nbHours;
	}

	/**
	 * @return the course
	 */
	public long getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(long course) {
		this.course = course;
	}
	
	
	
}
