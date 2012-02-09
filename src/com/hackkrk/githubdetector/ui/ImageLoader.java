package com.hackkrk.githubdetector.ui;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class ImageLoader {
	
	private static final String TAG = "IMAGE_LOADER";
	
	public ImageLoader() {
		
	}
	
	public Bitmap loadImage(URL imageUrl) {
		try {
			HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
			conn.setDoInput(true);
			conn.connect();
			InputStream is = conn.getInputStream();
			
			return BitmapFactory.decodeStream(is);
		
		} catch (MalformedURLException e) {
			Log.i(TAG, "Malformed url");
		} catch (IOException e) {
			Log.i(TAG, "Error while loading gravatar.");
		}
		
		return null;
	}
	
}