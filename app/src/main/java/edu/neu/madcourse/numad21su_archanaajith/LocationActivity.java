package edu.neu.madcourse.numad21su_archanaajith;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class LocationActivity extends AppCompatActivity {

    private static final int REQUEST_LOCATION_PERMISSION = 1;
    LocationManager location;
    TextView latitudeTextView;
    TextView longitudeTextView;
    TextView notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        latitudeTextView=findViewById(R.id.latitude);
        longitudeTextView=findViewById(R.id.longitude);
        notification=findViewById(R.id.notification);


    }
    public void onClickGetLocation(View view) {

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        location = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if(!location.isProviderEnabled(location.GPS_PROVIDER)){
            Snackbar.make(view, "Please switch on GPS to continue using the feature.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        else
            getCurrentLocation();

    }
    public class GPSListener implements LocationListener {
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

    private void getCurrentLocation(){
        if (ActivityCompat.checkSelfPermission(LocationActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(LocationActivity.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
        else{
            Location GPS = location.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location networkLocation = location.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Location passiveLocation = location.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            if (GPS != null){
                double latitude = GPS.getLatitude();
                double longitude = GPS.getLongitude();
                String latitudeText = "Latitude: " + latitude + "";
                String longitudeText = "Longitude: " + longitude + "";
                latitudeTextView.setText(latitudeText);
                longitudeTextView.setText(longitudeText);
            }
            if (networkLocation != null){
                double latitude = networkLocation.getLatitude();
                double longitude = networkLocation.getLongitude();
                String latitudeText = "Latitude: " + latitude + "";
                String longitudeText = "Longitude: " + longitude + "";
                latitudeTextView.setText(latitudeText);
                longitudeTextView.setText(longitudeText);
            }
            if (passiveLocation != null){
                double latitude = passiveLocation.getLatitude();
                double longitude = passiveLocation.getLongitude();
                String latitudeText = "Latitude: " + latitude + "";
                String longitudeText = "Longitude: " + longitude + "";
                latitudeTextView.setText(latitudeText);
                longitudeTextView.setText(longitudeText);
            }
            else{
                Snackbar.make(notification, "GPS is starting . Please wait a moment", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
                location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 20 * 1000, 0, new GPSListener());
                location.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 20 * 1000, 0, new GPSListener());
            }
        }
    }
}