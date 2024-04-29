package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class OpeningMaps extends AppCompatActivity {

    ConstraintLayout bg;

    ImageButton btnFalls, btnRiga, btnNaald, btnIlovik, btnBungsberg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_maps);
        btnFalls = findViewById(R.id.btnFalls);
        btnRiga = findViewById(R.id.btnRiga);
        btnNaald = findViewById(R.id.btnNaald);
        btnIlovik = findViewById(R.id.btnIlovik);
        btnBungsberg = findViewById(R.id.btnBungsberg);
        bg = findViewById(R.id.bg);
        btnRiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:56.94912714898426, 24.104726611242192"));
                startActivity(intent);


                bg.setBackgroundResource(R.drawable.riga);


            }
        });
        btnIlovik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:44.45220054692651, 14.551034911419556"));
                startActivity(intent);
                bg.setBackgroundResource(R.drawable.ilovik);
            }
        });
        btnNaald.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:52.22794704837843, 5.946078868688031"));
                startActivity(intent);
                bg.setBackgroundResource(R.drawable.naald);
            }
        });
        btnBungsberg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:54.20897186378926, 10.728892753438577"));
                startActivity(intent);
                bg.setBackgroundResource(R.drawable.bungsberg);
            }
        });
        btnFalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:44.9827330775182, -93.25537389706382"));
                startActivity(intent);
                bg.setBackgroundResource(R.drawable.falls);
            }
        });
    }



}