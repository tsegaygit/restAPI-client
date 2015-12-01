package acct.rest.client;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;
import org.apache.commons.jcs.access.exception.CacheException;
import org.apache.commons.jcs.engine.control.CompositeCacheManager;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import acct.rest.model.Response;

public abstract class AbstractApiClient<T> implements WebApiClient<T> {

	private static String TOKEN_KEY = "WEB_API";
	private CacheAccess<String, Response> cache = null;
	private String username;
	private String password;
	protected String url;
	protected String function;
	
	public CacheAccess<String, Response> getCache() {
		return cache;
	}
	
	public AbstractApiClient(String username, String password, String url, String function){
		this.username= username;
		this.password = password;
		this.url=url;
		this.function=function;
		try 
        {
            cache = JCS.getInstance( "default" );
        }
        catch ( Exception e ) 
        {
            System.out.println( String.format( "Problem initializing cache: %s", e.getMessage() ) );
        }
	}
	
	@Override
	public String getToken() throws ClientProtocolException, IOException,
			URISyntaxException {
		String token = null;

		Response t = sessionToken();

		if (t != null) {
			return t.getAccess_token();
		}
		
		t = getNewToken();

		try {
			this.cache.put(TOKEN_KEY, t);
			CompositeCacheManager.getInstance().shutDown();
		} catch (CacheException e) {
			//
			System.out
					.println("Error adding token to cache: " + e.getMessage());
			e.printStackTrace();
		}

		// Response test = (Response)this.cache.get(TOKEN_KEY);

		token = t.getAccess_token();

		System.out.println(token);

		return token;
	}

	@Override
	public Response sessionToken() {
		return (Response) this.cache.get(TOKEN_KEY);
	}

	@Override
	public Response getNewToken() {
		Response res = null;
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost("http://data.acct2day.us/token");
			// Build Name Value Pair Parameters for POST Request.
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("grant_type", "password"));
			nvps.add(new BasicNameValuePair("client_id", "CONSOLE"));
			nvps.add(new BasicNameValuePair("response_type", "token"));

			// Add the Basic Authentication for API Manager Principal and
			// Credentials.
			nvps.add(new BasicNameValuePair("username", username));
			nvps.add(new BasicNameValuePair("password", password));

			request.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));

			HttpResponse response;

			response = client.execute(request);

			String json = EntityUtils.toString(response.getEntity());

			 res = new Gson().fromJson(json, Response.class);

			if (response.getStatusLine().getStatusCode() != 200) {
				System.out.println("Error expecting a redirect but found: "
						+ response.getStatusLine());
				return null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	

	@Override
	public void renewToken() {
this.cache.remove(TOKEN_KEY);
		
		Response res = this.getNewToken();
		this.cache.put(TOKEN_KEY, res);
		
		CompositeCacheManager.getInstance().shutDown();
		
	}

}
