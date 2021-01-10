package com.example.binusezyfood;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng jakarta = new LatLng(-6.21462, 106.84513);
        mMap.addMarker(new MarkerOptions().position(jakarta).title("Marker in Jakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jakarta));

        LatLng bogor = new LatLng(-6.59444, 106.78917);
        mMap.addMarker(new MarkerOptions().position(bogor).title("Marker in bogor"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bogor));

        LatLng depok = new LatLng(-6.4, 106.81861);
        mMap.addMarker(new MarkerOptions().position(depok).title("Marker in depok"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(depok));

        LatLng tangerang = new LatLng(-6.17806, 106.63);
        mMap.addMarker(new MarkerOptions().position(tangerang).title("Marker in tangerang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tangerang));

        LatLng bekasi = new LatLng(-6.2349, 106.9896);
        mMap.addMarker(new MarkerOptions().position(bekasi).title("Marker in bekasi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bekasi));
    }
}