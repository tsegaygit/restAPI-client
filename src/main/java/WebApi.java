import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import acct.rest.client.AdmittedStudentsApiClient;
import acct.rest.client.SimpleApiClient;
import acct.rest.client.WebApiClient;
import acct.rest.model.AdmittedStudent;
import acct.rest.model.ClassSchedule;


public class WebApi {
	
	public static void main(String[] args) {
//		WebApiClient<ClassSchedule> api = new SimpleApiClient("tsegay", "Tsegay","http://data.acct2day.us/api/", "classschedules");
//		List<ClassSchedule> schedules = api.httpGet();
//		
//		System.out.println("total class schedules: "+schedules.size());
//		for(ClassSchedule schedule : schedules){
//			//System.out.println(schedule.getCourseCode());
//		}
		
		Timestamp stamp = new Timestamp(Long.parseLong("1417496400000"));
		  Date date = new Date(stamp.getTime());
		  //System.out.println(date);
		
		System.out.println("post student");
		
		WebApiClient<String> studentsApi = new AdmittedStudentsApiClient("tsegay", "Tsegay","http://data.acct2day.us/api/", "students");
		List<String> students = studentsApi.httpGet();
		for(String student : students){
			System.out.println(student);
		}
	}	
}
