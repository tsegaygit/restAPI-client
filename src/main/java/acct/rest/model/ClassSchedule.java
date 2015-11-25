package acct.rest.model;

import java.io.Serializable;

public class ClassSchedule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int enrollment;
	private int scheduleID;
	private String courseCode;
	private String courseName;

	public int getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}

	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
