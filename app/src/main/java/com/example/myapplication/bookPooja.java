package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bookPooja extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_pooja);
        b1 = findViewById(R.id.shanipooja);
        b2 = findViewById(R.id.karpuraArathi);
        b3 = findViewById(R.id.rudra);
        b4 = findViewById(R.id.ramba);
        b5 = findViewById(R.id.navagraha);
        String email = getIntent().getStringExtra("email");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bookPooja.this, Timing.class);
                intent.putExtra("pooja", "Shani pooja");
                intent.putExtra("Price","50");
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bookPooja.this, Timing.class);
                intent.putExtra("pooja", "Karpura Aranthi");
                intent.putExtra("Price","60");
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bookPooja.this, Timing.class);
                intent.putExtra("pooja", "Rudra abhisheka");
                intent.putExtra("Price","30");
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bookPooja.this, Timing.class);
                intent.putExtra("pooja", "Ramba vivaha");
                intent.putExtra("Price","1000");
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bookPooja.this, Timing.class);
                intent.putExtra("pooja", "Navagraha pooja");
                intent.putExtra("Price","60");
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

    }
}