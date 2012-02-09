package com.hackkrk.githubdetector;

import com.hackkrk.githubdetector.api.LoginActivity;
import com.hackkrk.githubdetector.api.Preferences;
import com.hackkrk.githubdetector.location.LocationService;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class GithubDetectorActivity extends Activity {
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    Intent intent = new Intent(this, LoginActivity.class);

    if (getBackend() == null) {
      final String[] items = { "J2ee", "Ruby", "Python", "Node.js" };

      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.setTitle("Pick a backend");
      builder.setItems(items, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int item) {
          SharedPreferences defaultSharedPreferences = PreferenceManager
              .getDefaultSharedPreferences(getApplicationContext());
          Editor editor = defaultSharedPreferences.edit();
          editor.putString(Preferences.BACKEND, items[item]);
        }
      });
      AlertDialog alert = builder.create();
      alert.show();
    }

    startActivity(intent);
    startService(new Intent(this, LocationService.class));
  }

  private String getBackend() {
    SharedPreferences defaultSharedPreferences = PreferenceManager
        .getDefaultSharedPreferences(this);
    String token = defaultSharedPreferences.getString(Preferences.BACKEND, null);
    return token;
  }
}