package com.hackkrk.githubdetector.api;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.net.MalformedURLException;
import java.net.URL;

public class GitUser {
  public String login;
  public double lat;
  public double lng;
  public URL avatar;
  public Date date;
//  public 
  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }
  public double getLat() {
    return lat;
  }
  public void setLat(double lat) {
    this.lat = lat;
  }
  public double getLng() {
    return lng;
  }
  public void setLng(double lng) {
    this.lng = lng;
  }
  public URL getAvatar() {
    return avatar;
  }
  public void setAvatar(String avatarUrl) throws MalformedURLException {
    this.avatar = new URL(avatarUrl);
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Long date) {
    this.date = new Date(date * 1000);
  }
  
  public static GitUser fromJson(JSONObject jsonGitUser) throws JSONException, MalformedURLException {
    
    GitUser user = new GitUser();
    user.setLogin(jsonGitUser.getString("login"));
    user.setLat(jsonGitUser.getDouble("lat"));
    user.setLng(jsonGitUser.getDouble("lng"));
    user.setAvatar(jsonGitUser.getString("avatar"));
    user.setDate(jsonGitUser.getLong("date"));
    
    return null;
  }
  
  
}
