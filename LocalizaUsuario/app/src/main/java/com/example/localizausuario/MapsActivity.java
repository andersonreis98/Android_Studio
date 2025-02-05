package com.example.localizausuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.localizausuario.databinding.ActivityMapsBinding;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private LocationManager locationManager;
    private LocationListener locationListener;

    private String[] permissoes = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Valida permições
        Permissoes.validarPermissoes(permissoes, this, 1);


        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //        Cria o objeto location manager para que identifique a localização do usuario
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                Log.d("localizacao","onLocation:"+location.toString());

                Double latutude = location.getLatitude();
                Double longitude = location.getLongitude();
                mMap.clear();
                // Add a marker in Sydney and move the camera
                LatLng localizacaousuario = new LatLng(latutude, longitude);
                mMap.addMarker(new MarkerOptions().position(localizacaousuario).title("Meu Local"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localizacaousuario,15));


//                Geocoding processo de transformar um endereço em uma localização com latitude e longitude

//                Reverse Geocoding - transforma longitude e latitude em um endereço

                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                try {
//                    Geocoding
//                    List<Address> listaEndereco = geocoder.getFromLocation(latutude,longitude,1);

//                    Reverse Geocoding
                    String enderecoTexto = "Avenida Paulista, 1374 - Bela Vista, São Paulo - SP";
                    List<Address> listaEndereco = geocoder.getFromLocationName(enderecoTexto,1);
                if (listaEndereco !=null &&listaEndereco.size()>0){
                    Address endereco = listaEndereco.get(0);
                    Log.d("local", "onLocationChanged"+endereco.toString());
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0,
                    0,
                    locationListener
            );
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int permissaoResultado : grantResults) {
            if (permissaoResultado == PackageManager.PERMISSION_DENIED) {
//              Alerts o usuario que a permissão foi negada
                alertaValidacaoPermissao();
            } else if (permissaoResultado == PackageManager.PERMISSION_GRANTED) {
                //              Alerts o usuario que a permissão foi permitida

//                1 - Provedor de localização
//                2 - tempo minimo entre atualizações de localização
//                3 - distancia minima entre atualização de localização
//                4 - Location Listner para recebermos as atualizações
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            0,
                            0,
                            locationListener
                    );
                }
            }
        }
    }

    public void alertaValidacaoPermissao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Para utilizar o app é necessario aceitar as permissões");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}