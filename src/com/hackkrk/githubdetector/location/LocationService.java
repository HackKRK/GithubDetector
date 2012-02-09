package com.hackkrk.githubdetector.location;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class LocationService extends Service {

  /**
   * Constant for location updates - one minute - based on
   * requestLocationUpdates docs
   */
  private static final long MINUTE = 60 * 1000;
  public static final String TAG = "LocationService";
  public Location mBestLocation;

  @Override
  public IBinder onBind(Intent intent) {

    LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    LocationListener locationListener = new SimpleLocationListener();
    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5 * MINUTE, 50,
        locationListener);

    return null;
  }

  public class SimpleLocationListener implements LocationListener {

    private static final int TWO_MINUTES = 1000 * 60 * 2;

    @Override
    public void onLocationChanged(Location location) {
      if (mBestLocation == null || isBetterLocation(location, mBestLocation)) {
        Log.d(
            TAG,
            "Current best location: " + location.getLatitude() + " "
                + location.getLongitude());
        Log.d(TAG, "Current best location: " + location.toString());

        mBestLocation = location;

        checkIn(mBestLocation);
      }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    /**
     * Determines whether one Location reading is better than the current
     * Location fix
     * 
     * @param location
     *          The new Location that you want to evaluate
     * @param currentBestLocation
     *          The current Location fix, to which you want to compare the new
     *          one
     */
    protected boolean isBetterLocation(Location location, Location currentBestLocation) {
      if (currentBestLocation == null) {
        // A new location is always better than no location
        return true;
      }

      // Check whether the new location fix is newer or older
      long timeDelta = location.getTime() - currentBestLocation.getTime();
      boolean isSignificantlyNewer = timeDelta > TWO_MINUTES;
      boolean isSignificantlyOlder = timeDelta < -TWO_MINUTES;
      boolean isNewer = timeDelta > 0;

      // If it's been more than two minutes since the current location, use the new location
      // because the user has likely moved
      if (isSignificantlyNewer) {
        return true;
        // If the new location is more than two minutes older, it must be worse
      } else if (isSignificantlyOlder) {
        return false;
      }

      // Check whether the new location fix is more or less accurate
      int accuracyDelta = (int) (location.getAccuracy() - currentBestLocation
          .getAccuracy());
      boolean isLessAccurate = accuracyDelta > 0;
      boolean isMoreAccurate = accuracyDelta < 0;
      boolean isSignificantlyLessAccurate = accuracyDelta > 200;

      // Check if the old and new location are from the same provider
      boolean isFromSameProvider = isSameProvider(location.getProvider(),
          currentBestLocation.getProvider());

      // Determine location quality using a combination of timeliness and accuracy
      if (isMoreAccurate) {
        return true;
      } else if (isNewer && !isLessAccurate) {
        return true;
      } else if (isNewer && !isSignificantlyLessAccurate && isFromSameProvider) {
        return true;
      }
      return false;
    }

    /** Checks whether two providers are the same */
    private boolean isSameProvider(String provider1, String provider2) {
      if (provider1 == null) {
        return provider2 == null;
      }
      return provider1.equals(provider2);
    }

  }

  public void checkIn(Location location) {
    // TODO Auto-generated method stub

  }

}
