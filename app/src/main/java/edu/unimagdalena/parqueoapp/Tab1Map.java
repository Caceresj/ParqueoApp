package edu.unimagdalena.parqueoapp;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Tab1Map extends Fragment implements OnMapReadyCallback {
    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;
    private int id;
    private String nombre;
    private double longitud,latitud;
    private int costo;
    private int numeroiter;
    private ArrayTab1 arrayTab1s;
    private ArrayList<ArrayTab1> arrayTab1= new ArrayList<ArrayTab1>();
    @Override
    public void onCreate(Bundle savedInstanceStateState){
        super.onCreate(savedInstanceStateState);
        if(getArguments() != null){
            numeroiter = getArguments().getInt("termina");
            for(int i=0;i<numeroiter;i++){
                id =getArguments().getInt("id"+(i+1));
                nombre = getArguments().getString("nombre"+(i+1));
                longitud = getArguments().getDouble("lon"+(i+1));
                latitud = getArguments().getDouble("lat"+(i+1));
                costo =getArguments().getInt("costo"+(i+1));
                arrayTab1s = new ArrayTab1(id,nombre,longitud,latitud,costo);
                arrayTab1.add(arrayTab1s);
            }//Log.i("Corone",String.valueOf(id));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.tab1maps,container,false);
        return mView;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = mView.findViewById(R.id.map);
        if (mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        /*MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions())*/
        mGoogleMap = googleMap;

        UiSettings uiSettings = mGoogleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setScrollGesturesEnabled(true);
        uiSettings.setCompassEnabled(true);

        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        mGoogleMap.setMyLocationEnabled(true);
        for(int i=1;i<arrayTab1.size()+1;i++){
            for (ArrayTab1 arryTab1: arrayTab1){
               if(arryTab1.getId() == i){
                   LatLng p1 = new LatLng(arryTab1.getLatitud(), arryTab1.getLongitud());
                   Log.i("jodido"+i,"(" + arryTab1.getLatitud() + "," + arryTab1.getLongitud() + ")");
                   mGoogleMap.addMarker(new MarkerOptions().position(p1).title(arryTab1.getNombre()).snippet("Costo:"+arryTab1.getCosto()));
                   mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p1,5));
               }
            }
        }

    }

}

