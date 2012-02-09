package com.hackkrk.githubdetector.api;

import java.net.MalformedURLException;

public class Configuration {
  public static java.net.URL getServerURL() throws MalformedURLException
  {
    return new java.net.URL("http://itdet.com");
  }
}
