package com.example.sengkham.ltc_app;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ServiceActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocationManager locationManager;
    private Criteria criteria;
    private double latADouble, lngADouble, updateLatADouble,updateLngADouble;
    private  String[] loginStrings;
    private TextView textView;
    private EditText editText;
    private ImageView imageView,takePhotImageView;
    String nameString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
        textView = (TextView) findViewById(R.id.textView5);
      //   = (EditText) findViewById(R.id.editText5);
         // Setup
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        loginStrings = getIntent().getStringArrayExtra("Login");


        textView.setText(loginStrings[1]);
        editText = (EditText) findViewById(R.id.editText5);
        imageView = (ImageView) findViewById(R.id.imageView2);
        takePhotImageView = (ImageView) findViewById(R.id.imageView4);




        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    } // Main Method


    public void clickSave(View view) {

        nameString = editText.getText().toString();
        //nameString = editText.getText().toString().trim();

        //Check Space
        if (nameString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert(ServiceActivity.this,
                    getResources().getString(R.string.title_have_space),
                    getResources().getString(R.string.message_have_space),
                    R.drawable.doremon48);
            myAlert.myDiglog();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        latADouble =17.9710201;
        lngADouble = 102.5740478;

        Location networkLocation = myFindLocation(LocationManager.NETWORK_PROVIDER);
        if(networkLocation != null){
            latADouble = networkLocation.getLatitude();
            lngADouble = networkLocation.getLongitude();
        }

        Location gpsLocation = myFindLocation(LocationManager.GPS_PROVIDER);
        if (gpsLocation != null) {
            latADouble = gpsLocation.getLatitude();
            lngADouble = gpsLocation.getLongitude();
        }


    } // onResume

    @Override
    protected void onStop() {
        super.onStop();
        locationManager.removeUpdates(locationListener);
    }

    public Location myFindLocation(String strProvider) {

        Location location = null;

        if (locationManager.isProviderEnabled(strProvider)) {

                locationManager.requestLocationUpdates(strProvider,1000,10,locationListener);
                location = locationManager.getLastKnownLocation(strProvider);


        }


        return location;
    }

    public LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            latADouble = location.getLatitude();
            lngADouble = location.getLongitude();

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng latLng = new LatLng(latADouble,lngADouble);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
        // Add a marker in Sydney and move the camera

        myAddMaker(latADouble,lngADouble);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.clear();
                myAddMaker(latLng.latitude, latLng.longitude);
            }
        });

    } // on Map

    private void myAddMaker(double latADouble, double lngADouble) {

        LatLng latLng = new LatLng(latADouble, lngADouble);
        mMap.addMarker(new MarkerOptions().position(latLng));

    }
} // Man Class
