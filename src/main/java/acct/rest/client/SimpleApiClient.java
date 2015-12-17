package acct.rest.client;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.jcs.access.CacheAccess;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import acct.rest.model.ClassSchedule;
import acct.rest.model.Response;
import acct.rest.server.JsonResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SimpleApiClient extends AbstractApiClient<ClassSchedule> {

	public SimpleApiClient(String username, String password, String url,
			String function) {
		super(username, password, url, function);
	}

	public List<ClassSchedule> httpGet() {
		List<ClassSchedule> schedules = new ArrayList<ClassSchedule>();

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

			Type type = new TypeToken<List<ClassSchedule>>() {
			}.getType();

			schedules = new Gson().fromJson(json, type);

		} catch (URISyntaxException | IOException ex) {
			System.out.println("There was an error: " + ex.getCause());
		}

		return schedules;

	}

	@Override
	public JsonResponse httpPost(Serializable entity) {
		//
		throw new UnsupportedOperationException();
	}

}
