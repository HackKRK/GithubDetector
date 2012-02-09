package com.hackkrk.githubdetector.api;

import java.util.Date;
import java.net.URL;

public class GitUser {
  public String login;
  public float lat;
  public float lng;
  public URL avatar;
  public Date date;
//  public 
  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }
  public float getLat() {
    return lat;
  }
  public void setLat(float lat) {
    this.lat = lat;
  }
  public float getLng() {
    return lng;
  }
  public void setLng(float lng) {
    this.lng = lng;
  }
  public URL getAvatar() {
    return avatar;
  }
  public void setAvatar(URL avatar) {
    this.avatar = avatar;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
}
