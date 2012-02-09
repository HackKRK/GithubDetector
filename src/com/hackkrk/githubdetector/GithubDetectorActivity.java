package com.hackkrk.githubdetector;

import com.hackkrk.githubdetector.api.LoginActivity;
import com.hackkrk.githubdetector.location.LocationService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GithubDetectorActivity extends Activity {
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
    startService(new Intent(this, LocationService.class));
  }
}