package com.halanx.tript.userapp;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Tript on 02-02-2017.
 */

public class GPSTracker extends Service implements LocationListener{

    private final Context context;
    boolean isGPSEnabled = false;
    boolean canGetLocation = false;
    boolean isNetworkEnabled = true;

    Location location;

    double Lat, Long;

    private static final long MIN_DIST = 5;
    private static final long MIN_TIME = 1000;

    protected LocationManager locationManager;

    public GPSTracker(Context context){
        this.context = context;
        getLocation();
    }

    public Location getLocation(){
        try{
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);

            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if(!isGPSEnabled && !isNetworkEnabled){

            }else{
                this.canGetLocation = true;

                if(isNetworkEnabled){
                    try {
                        locationManager.requestLocationUpdates(
                                LocationManager.NETWORK_PROVIDER,
                                MIN_TIME,
                                MIN_DIST, this);

                    }
                    catch (SecurityException e ){
                        e.printStackTrace();
                    }
                }
                if(locationManager != null){
                    try{
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    } catch (SecurityException e) {e.printStackTrace();}

                    if(location != null){
                        Lat = location.getLatitude();
                        Long = location.getLongitude();
                    }
                }

                if (isGPSEnabled){
                    if (location == null){
                        try {
                            locationManager.requestLocationUpdates(
                                    LocationManager.GPS_PROVIDER,
                                    MIN_TIME, MIN_DIST,
                                    this);
                            if (locationManager!=null){
                                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                                if (location != null){
                                    Lat = location.getLatitude();
                                    Long = location.getLongitude();
                                }
                            }
                        }catch (SecurityException e){e.printStackTrace();}


                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return location;
    }

    public void stopUsingGPS(){
        if(locationManager!= null){
            try{
                locationManager.removeUpdates(GPSTracker.this);
            } catch (SecurityException e){e.printStackTrace();}
        }
    }

    public double getLatitude(){
        if(location != null){
            Lat = location.getLatitude();
        }
        return Lat;
    }

    public double getLongitude(){
        if(location != null){
            Long = location.getLongitude();
        }
        return Long;
    }

    public boolean canGetLocation(){
        return this.canGetLocation;
    }

    /*public void showSettingsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.set
    }*/

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

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
}
