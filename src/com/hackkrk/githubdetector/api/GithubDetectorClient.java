package com.hackkrk.githubdetector.api;

import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class GithubDetectorClient {

  private static GithubDetectorClient instance = null;
  private static Context sContext;

  public static GithubDetectorClient getInstance(Context context) {
    if (instance == null) {
      instance = new GithubDetectorClient();
    }
    sContext = context;
    return instance;
  }

  /**
   * 
   * @param loginName
   * @param password
   * @return token
   * @throws JSONException
   */
  public String login(String loginName, String password) throws JSONException {
    JsonClient client = JsonClient.getInstance();

    JSONObject jsonBody = new JSONObject();
    jsonBody.put("login", loginName);
    jsonBody.put("password", password);

    String body = jsonBody.toString();

    try {
      return client.create(null, Configuration.getServerURL(sContext) + "/login", body);
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public void checkIn(double lat, double lng, String text) {
    JsonClient client = JsonClient.getInstance();
    try {

      String token = getToken();

      JSONObject jsonBody = new JSONObject();
      try {
        jsonBody.put("lat", lat);
        jsonBody.put("lng", lng);
        jsonBody.put("text", text);
        String body = jsonBody.toString();

        client.create(token, Configuration.getServerURL(sContext), body);

      } catch (JSONException e) {
      }
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public List<GitUser> geeks(double lat, double lng, double radius) throws JSONException,
      MalformedURLException {
    JsonClient client = JsonClient.getInstance();

    HttpParams params = new BasicHttpParams();
    params.setDoubleParameter("lat", lat);
    params.setDoubleParameter("lng", lng);
    params.setDoubleParameter("radius", radius);

    String geeksInString = client.read(getToken(), Configuration.getServerURL(sContext),
        params);

    JSONArray userArray = new JSONArray(geeksInString);

    List<GitUser> users = new ArrayList<GitUser>();

    for (int i = 0; i < userArray.length(); i++) {
      users.add(GitUser.fromJson(userArray.getJSONObject(i)));
    }

    return users;
  }

  private String getToken() {
    SharedPreferences defaultSharedPreferences = PreferenceManager
        .getDefaultSharedPreferences(sContext);
    String token = defaultSharedPreferences.getString(Preferences.TOKEN, null);
    return token;
  }
}
