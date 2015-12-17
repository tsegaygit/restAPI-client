package acct.rest.client;
import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import acct.rest.model.AdmittedStudent;
import acct.rest.model.ClassSchedule;
import acct.rest.server.JsonResponse;

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
		AdmittedStudentsApiClient studentsApi = new AdmittedStudentsApiClient("tsegay", "Tsegay","http://data.acct2day.us/api/", "students");
		
		
		logger.info("post student");
		assertNotNull(studentsApi.getCache());
		logger.info("running assertions ... ");
		
		///create fully initialized and validated student object
		AdmittedStudent entity = new AdmittedStudent();
		entity.setId(1);
		
		////////////////////////////////////// Sample code //////////////////////////////////////
		
		JsonResponse student = studentsApi.httpPost(entity);
		
		//check for status code to see if the request was successful
		if(student.getStatus()==200){
			//request succeed
		}else if(student.getStatus()==400){
			//request failed with validation errors
			
		}else if (student.getStatus()==401){
			//unauthorized access, 
		}
		
        //////////////////////////////////////Sample code //////////////////////////////////////
		assertNotNull(student);
		
		logger.info("New student created : "+student.getStatus());
		
	}
}
