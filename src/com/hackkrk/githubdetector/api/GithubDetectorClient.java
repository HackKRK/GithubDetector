package com.hackkrk.githubdetector.api;

import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class GithubDetectorClient {
  
  private static GithubDetectorClient instance = null;
  
  public static GithubDetectorClient getInstance()
  {
    if (instance==null)
      instance = new GithubDetectorClient();
    return instance;
  }
  
  /**
   * 
   * @param loginName
   * @param password
   * @return token
   * @throws JSONException 
   */
  public String login(String loginName, String password) throws JSONException
  {
    JsonClient client = JsonClient.getInstance();
    
    JSONObject jsonBody = new JSONObject();
    jsonBody.put("login", loginName);
    jsonBody.put("password", password);
     
    String body  = jsonBody.toString();
    
    try {
      return client.create(null, Configuration.getServerURL(), body);
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public void checkIn(String token, float lng, float lat, String text)
  {
    JsonClient client = JsonClient.getInstance();
       try {
        client.update(token, Configuration.getServerURL());
      } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
  }
  
  public GitUser[] geeks(float lng, float lat, float radius)
  {
    JsonClient client = JsonClient.getInstance();
    return null;  
  }
  
}
