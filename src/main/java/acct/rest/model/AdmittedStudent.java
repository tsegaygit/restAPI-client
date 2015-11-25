package acct.rest.model;

import java.io.Serializable;
import java.util.List;

public class AdmittedStudent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String applicantId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String homePhone;
	private String cellPhone;
	private String ssn;
	private String citizenship;
	private String countryOfBirth;
	private String ethnicity;
	private String sevisNumber;
	private long dateCreated;
	private long dob;
	private String gender;
	private String studentType;
	private String dateEnrolled;
	private String programOfStudy;
	private String term;
	private String accountState;
	private List<HighSchool> listOfHighSchools;
	private List<Institute> listOfInstitutes;
	private List<Address> listOfAddresses;
	private Agent agent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getSevisNumber() {
		return sevisNumber;
	}

	public void setSevisNumber(String sevisNumber) {
		this.sevisNumber = sevisNumber;
	}

	public long getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(long dateCreated) {
		this.dateCreated = dateCreated;
	}

	public long getDob() {
		return dob;
	}

	public void setDob(long dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public String getDateEnrolled() {
		return dateEnrolled;
	}

	public void setDateEnrolled(String dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}

	public String getProgramOfStudy() {
		return programOfStudy;
	}

	public void setProgramOfStudy(String programOfStudy) {
		this.programOfStudy = programOfStudy;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getAccountState() {
		return accountState;
	}

	public void setAccountState(String accountState) {
		this.accountState = accountState;
	}

	public List<HighSchool> getListOfHighSchools() {
		return listOfHighSchools;
	}

	public void setListOfHighSchools(List<HighSchool> listOfHighSchools) {
		this.listOfHighSchools = listOfHighSchools;
	}

	public List<Institute> getListOfInstitutes() {
		return listOfInstitutes;
	}

	public void setListOfInstitutes(List<Institute> listOfInstitutes) {
		this.listOfInstitutes = listOfInstitutes;
	}

	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
