package com.example.sdkgooglemaps;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.sdkgooglemaps.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
//      Altera tipo de mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


//        Adicionar evento de click
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                Double longitude = latLng.longitude;
                Double latitude = latLng.latitude;
                LatLng ibirapuera = new LatLng(-23.587153578721413, -46.66252411716394);

//                Toast.makeText(getApplicationContext(), "LATITUDE: " + latitude + "LONGITUDE:" + longitude, Toast.LENGTH_SHORT).show();

//                Adicionar Linhas ao mapa
                PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.add(ibirapuera);
                polylineOptions.add( latLng );
                polylineOptions.color(Color.BLUE);
                polylineOptions.width(20);

                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Parque Ibirapuera")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icone_loja))
                        .snippet("Click Ibirapuera")
                );
            }
        });

        //        Adicionar evento de click longo
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Double longitude = latLng.longitude;
                Double latitude = latLng.latitude;

                Toast.makeText(getApplicationContext(), "LATITUDE: " + latitude + "LONGITUDE:" + longitude, Toast.LENGTH_SHORT).show();

                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Parque Ibirapuera")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icone_carro_roxo_48px))
                        .snippet("Click Ibirapuera"));
            }
        });

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng ibirapuera = new LatLng(-23.587153578721413, -46.66252411716394);
        mMap.addMarker(new MarkerOptions()
                        .position(ibirapuera)
                        .title("Parque Ibirapuera")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icone_carro_roxo_96px))

        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ibirapuera, 18));

////        adiciona circulo ao mapa
//        CircleOptions circleOptions = new CircleOptions();
//        circleOptions.center(ibirapuera);
////        Medida em metros
//        circleOptions.radius(500);
//        circleOptions.fillColor(Color.argb(128,0,51,102));
//        circleOptions.strokeWidth(10);
//        circleOptions.strokeColor(Color.YELLOW);
//        mMap.addCircle(circleOptions);

////        adiciona poligonos ao mapa
//        PolygonOptions polygonOptions = new PolygonOptions();
//        polygonOptions.add(new LatLng(-23.585406, -46.660405));
//        polygonOptions.add(new LatLng(-23.585181, -46.660080));
//        polygonOptions.add(new LatLng(-23.586221, -46.659156));
//        polygonOptions.add(new LatLng(-23.586447, -46.659472));
//        polygonOptions.strokeColor(Color.GREEN);
//        polygonOptions.strokeWidth(10);
//        polygonOptions.fillColor(Color.argb(128,255, 153, 0));
//        mMap.addPolygon( polygonOptions );

    }
}