package acct.rest.model;

import java.io.Serializable;

public class Institute implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String country;
	private String state;
	private String zip;
	private String city;
	private String programOfStudy;
	private String levelOfStudy;
	private long graduationDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProgramOfStudy() {
		return programOfStudy;
	}

	public void setProgramOfStudy(String programOfStudy) {
		this.programOfStudy = programOfStudy;
	}

	public String getLevelOfStudy() {
		return levelOfStudy;
	}

	public void setLevelOfStudy(String levelOfStudy) {
		this.levelOfStudy = levelOfStudy;
	}

	public long getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(long graduationDate) {
		this.graduationDate = graduationDate;
	}

}
