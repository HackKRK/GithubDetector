package com.hackkrk.githubdetector.api;

import com.hackkrk.githubdetector.R;

import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;
import java.net.URL;

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
        
        new LoginTask().execute(login.getText().toString(), password.getText().toString());
        
      }
    });
    
  }
  
  class LoginTask extends AsyncTask<String, Void, Void> {

    @Override
    protected void onPreExecute() {
      // TODO Auto-generated method stub
      super.onPreExecute();
    }
    
    @Override
    protected Void doInBackground(String... params) {
      
       // TODO Auto-generated method stub
      return null;
    }
    
    @Override
    protected void onPostExecute(Void result) {
      // TODO Auto-generated method stub
      super.onPostExecute(result);
    }
    
  }

}
