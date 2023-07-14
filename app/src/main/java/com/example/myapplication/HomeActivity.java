package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentContainerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.FirebaseApp;
import com.google.android.gms.maps.SupportMapFragment;

public class HomeActivity extends AppCompatActivity  {


    CardView clothingCard;
    CardView donation;
    CardView about;
    CardView payment;
    LinearLayout mapview;

    private GoogleMap googleMap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        clothingCard = findViewById(R.id.book_pooja);
        donation = findViewById(R.id.donate);
        about = findViewById(R.id.about);
        payment = findViewById(R.id.payment);
        mapview = findViewById(R.id.row2);
        String email = getIntent().getStringExtra("email");
        mapview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleMaps();
            }
        });


        clothingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, bookPooja.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, donation.class);
                intent.putExtra("email", email);
                startActivity(intent);

            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, about.class);
                startActivity(intent);
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, history.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }


    private void openGoogleMaps() {
        // Get the latitude and longitude of the desired location
        double latitude = 12.718408;
        double longitude = 74.884628;

        // Create a URI with the location coordinates
        String uri = "geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude;

        // Create an intent with the URI
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));

        // Set the package to ensure only Google Maps handles the intent
        intent.setPackage("com.google.android.apps.maps");

        // Attempt to start the activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Google Maps app is not installed, handle the error or prompt the user to install it
            Toast.makeText(this, "Google Maps app is not installed", Toast.LENGTH_SHORT).show();
        }
    }

}
