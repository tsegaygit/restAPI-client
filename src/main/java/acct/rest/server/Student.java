package acct.rest.server;

import java.io.Serializable;

public class Student implements Serializable {
	private String[] applicantId;

	public String[] getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String[] applicantId) {
		this.applicantId = applicantId;
	}
}
