package acct.rest.client;
import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import acct.rest.model.AdmittedStudent;
import acct.rest.model.ClassSchedule;

public class EnrolledStudentTest {

	final Logger logger = Logger.getLogger(EnrolledStudentTest.class.getName());
	
	@Test
	public void ClassSchedulesShouldNotBeZero(){
		//Initialize schedule API client
		WebApiClient<ClassSchedule> scheduleApi = new SimpleApiClient("tsegay", "Tsegay", "http://data.acct2day.us/api/", "classschedules");
		
		//
		List<ClassSchedule> schedules = scheduleApi.httpGet();
		
		assertNotNull(schedules);
		
		logger.info("total class schedules: "+schedules.size());
		
	}
	@Test
	public void EnrolledStudentShouldBeCreated(){
		logger.info("running tests ... ");
		
		logger.info("connecting to "+" http://data.acct2day.us/api/students");
		
		//Initialize the API client, for now you can you my username/password
		WebApiClient<AdmittedStudent> studentsApi = new AdmittedStudentsApiClient("tsegay", "Tsegay","http://data.acct2day.us/api/", "students");
		
		
		logger.info("post student");
		assertNotNull(studentsApi.getCache());
		logger.info("running assertions ... ");
		
		///create fully initialized and validated student object
		AdmittedStudent entity = new AdmittedStudent();
		entity.setId(1);
		
		// Successful responses to this request returns a list/array of studentIDs in (XXX-XX-XXXX) format
		List<AdmittedStudent> student = studentsApi.httpGet();
		
		assertNotNull(student);
		
		logger.info("New student created : "+student.size());
		
	}
}
