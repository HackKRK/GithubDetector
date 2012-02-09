package com.hackkrk.githubdetector.api;

import java.net.MalformedURLException;

public class Configuration {
  public static String getServerURL() throws MalformedURLException
  {
    return "http://10.0.1.74:8080/com.hackkrk.githubdetector/rest/gd";
  }
}
