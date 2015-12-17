package acct.rest.client;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import acct.rest.model.AdmittedStudent;
import acct.rest.model.ClassSchedule;
import acct.rest.model.Response;
import acct.rest.server.JsonResponse;
import acct.rest.server.ResponseModelState;

public class AdmittedStudentsApiClient extends AbstractApiClient<AdmittedStudent> {

	private int numberOfTrials=0;
	private final int maxTrials=3;
	
	public AdmittedStudentsApiClient(String username, String password,
			String url, String function) {
		super(username, password, url, function);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AdmittedStudent> httpGet() {
		List<AdmittedStudent> students = new ArrayList<AdmittedStudent>();

		try (CloseableHttpClient httpClient = HttpClientBuilder.create()
				.build()) {
			String token = getToken();
			HttpGet request = new HttpGet(this.url + this.function);
			
			request.addHeader("content-type", "application/json");
			request.addHeader("Authorization", "bearer " + token);
			HttpResponse response = httpClient.execute(request);

			if (response.getStatusLine().getStatusCode() == 401) {
				renewToken();
				httpGet();
			}

			String json = EntityUtils.toString(response.getEntity(), "UTF-8");


			students = new Gson().fromJson(json,
					new TypeToken<List<AdmittedStudent>>() {
					}.getType());
			
			//students.add(studentID);
	

		} catch (URISyntaxException | IOException ex) {
			System.out.println("There was an error: " + ex.getCause());
		}

		return students;
	}

	@Override
	public JsonResponse httpPost(Serializable entity) {
		JsonResponse student = new JsonResponse();;

		try (CloseableHttpClient httpClient = HttpClientBuilder.create()
				.build()) {
			String token = getToken();
			HttpPost request = new HttpPost(this.url + this.function);
			
			
			request.setEntity(new StringEntity(new Gson().toJson(entity)));

			request.addHeader("content-type", "application/json");
			request.addHeader("Authorization", "bearer " + token);
			HttpResponse response = httpClient.execute(request);

			if (response.getStatusLine().getStatusCode() == 401) {
				numberOfTrials++; //increment the number of trials by 1
				renewToken(); //get a new token
				if(this.numberOfTrials>maxTrials) //return null after three trials
					return null;
				httpPost(entity);
			}
			
			String json = EntityUtils.toString(response.getEntity(), "UTF-8");

			System.out.println(json);
			student.setStatus(response.getStatusLine().getStatusCode());
			student.setModel(response.getEntity());

			//ResponseModelState modelState = new Gson().fromJson(json, ResponseModelState.class);

//			if(modelState!=null){
//				student.setModel(modelState.getModelState());
//			}
//			 student = new Gson().fromJson(json,
//					new TypeToken<AdmittedStudent>() {
//					}.getType());
//			
//			

		} catch (URISyntaxException | IOException ex) {
			System.out.println("There was an error: " + ex.getCause());
		}

		return student;
	}



}
