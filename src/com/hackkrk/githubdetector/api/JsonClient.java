package com.hackkrk.githubdetector.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URL;

public class JsonClient {

  private static JsonClient instance = null;
  
  public static JsonClient getInstance()
  {
   if (instance==null)
     instance = new JsonClient();
   return instance;
  }
  
  private HttpClient client;

  private HttpClient getHttpClient() {
    if (client == null) {
      client = new DefaultHttpClient();
    }
    return client;
  }

  public String create(String token, URL url, String body) {

    HttpPost post = new HttpPost(url.toString());
    
    HttpClient httpClient = getHttpClient();
    
    try {
      HttpResponse execute = httpClient.execute(post);
      return EntityUtils.toString(execute.getEntity());

    } catch (ClientProtocolException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }

    return null;

  } // POST

  void read(String token, URL url) {
  } //GET

  void update(String token, URL url) {
  } // PUT

  void delete(String token, URL url) {
  } // DELETE

}
