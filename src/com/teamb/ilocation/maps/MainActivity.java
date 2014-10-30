package com.teamb.ilocation.maps;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {
  static final LatLng BRIGHTON = new LatLng(50.86484, -0.08146);
  static final LatLng LEWES = new LatLng(50.82253, -0.13716);
  private GoogleMap map;

 /* @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
  }*/
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
        .getMap();
    Marker brighton = map.addMarker(new MarkerOptions().position(BRIGHTON)
        .title("Brighton"));
    Marker lewes = map.addMarker(new MarkerOptions()
        .position(LEWES)
        .title("Lewes")
        .snippet("Lewes is cool")
        .icon(BitmapDescriptorFactory
        		.fromResource(R.drawable.ic_launcher)));

    
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(BRIGHTON, 15));

    // Zoom in, animating the camera.
    map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
  }


} 