package edu.neu.madcourse.numad21su_archanaajith;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.snackbar.Snackbar;

import android.os.Bundle;

public class Location extends AppCompatActivity {


    public class LocationActivity extends AppCompatActivity {
        private static final int REQUEST_LOCATION_PERMISSION = 1;
        LocationManager location;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_location);

        }

        public void onClickGetLocation(View view) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
            location = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            if(!location.isProviderEnabled(location.GPS_PROVIDER)){
                Snackbar.make(view, "Please make sure that GPS Location is turned on", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
            else
                getLocation();

        }

        private void getLocation(){
            if (ActivityCompat.checkSelfPermission(LocationActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(LocationActivity.this,
                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
            }
            else{
                TextView locationView = findViewById(R.id.displayLocation);
                Location GPS = location.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                Location networkLocation = location.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                Location passiveLocation = location.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
                if (GPS != null){
                    double latitude = GPS.getLatitude();
                    double longitude = GPS.getLongitude();
                    String locationText = "Latitude: " + latitude + ", Longitude: " + longitude;
                    locationView.setText(locationText);
                }
                if (networkLocation != null){
                    double latitude = networkLocation.getLatitude();
                    double longitude = networkLocation.getLongitude();
                    String locationText = "Latitude: " + latitude + ", Longitude: " + longitude;
                    locationView.setText(locationText);
                }
                if (passiveLocation != null){
                    double latitude = passiveLocation.getLatitude();
                    double longitude = passiveLocation.getLongitude();
                    String locationText = "Latitude: " + latitude + ", Longitude: " + longitude;
                    locationView.setText(locationText);
                }
                else{
                    Snackbar.make(locationView, "Starting GPS. Please try again", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 20 * 1000, 0, new Listener());
                    location.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 20 * 1000, 0, new Listener());
                }
            }
        }

        public class Listener implements LocationListener{
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }
        }
    }}