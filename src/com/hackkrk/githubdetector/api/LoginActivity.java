package com.hackkrk.githubdetector.api;

import com.hackkrk.githubdetector.R;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_login);

    final EditText login = (EditText) findViewById(R.id.et_login);
    final EditText password = (EditText) findViewById(R.id.et_password);

    Button loginButton = (Button) findViewById(R.id.bn_login);

    loginButton.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {

        new LoginTask()
            .execute(login.getText().toString(), password.getText().toString());

      }
    });

  }

  class LoginTask extends AsyncTask<String, Void, String> {

    @Override
    protected void onPreExecute() {
      // TODO Auto-generated method stub
      super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

      GithubDetectorClient githubDetectorClient = GithubDetectorClient
          .getInstance(getApplicationContext());
      String loginResult = null;
      try {
        loginResult = githubDetectorClient.login(params[0], params[1]);

        JSONObject loginResultObject = new JSONObject(loginResult);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        Editor editor = prefs.edit();

        editor.putString(Preferences.TOKEN, loginResultObject.getString("token"));
        editor.putString(Preferences.GRAVATAR_URL,
            loginResultObject.getString("avatar_url"));

        editor.commit();
        return loginResultObject.toString();

      } catch (JSONException e) {
        e.printStackTrace();
      } finally {

      }
      return null;
    }

    @Override
    protected void onPostExecute(String result) {
      super.onPostExecute(result);
      Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
    }

  }

}
