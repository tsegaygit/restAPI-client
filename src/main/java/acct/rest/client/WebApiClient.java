package acct.rest.client;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.commons.jcs.access.CacheAccess;
import org.apache.http.client.ClientProtocolException;

import acct.rest.model.Response;

public interface WebApiClient<T> {

	// get token
	public String getToken() throws ClientProtocolException, IOException,
			URISyntaxException;

	public Response sessionToken();

	public Response getNewToken();

	public List<T> httpGet();

	public T httpPost(Serializable entity);
	
	public void renewToken();
	
	public CacheAccess<String, Response> getCache();
}
