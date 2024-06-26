package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button layout, button, calc, match, passintent, menu, maps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layout = (Button) findViewById(R.id.btnlayout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent out = new Intent(MainActivity.this, LayoutExercise.class);
                startActivity(out);
            }
        });

        maps = (Button) findViewById(R.id.btnMap);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent out = new Intent(MainActivity.this, OpeningMaps.class);
                startActivity(out);
            }
        });

        passintent = (Button) findViewById(R.id.btnIntent);
        passintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent out = new Intent(MainActivity.this, PassingIntentsExercise.class);
                startActivity(out);
            }
        });

        menu = (Button) findViewById(R.id.btnMenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent out = new Intent(MainActivity.this, MenuExercise.class);
                startActivity(out);
            }
        });

        match = (Button) findViewById(R.id.btnMatch);
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent out = new Intent(MainActivity.this, Match3Main.class);
                startActivity(out);
            }
        });

        button = (Button) findViewById(R.id.btnButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buttonExercise = new Intent(MainActivity.this, ButtonExercise.class);
                startActivity(buttonExercise);
            }
        });

        calc = (Button) findViewById(R.id.btnCalc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CalculatorExercise = new Intent(MainActivity.this, CalculatorExercise.class);
                startActivity(CalculatorExercise);
            }
        });
    }
}