package acct.rest.server;

import java.io.Serializable;

public class ModelState implements Serializable {

	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
