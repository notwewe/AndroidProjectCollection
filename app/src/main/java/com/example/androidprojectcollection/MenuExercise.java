package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;
    int defaultColor; // Variable to store the default color

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransform);

        // Set the background color of the button to black
        btnChanger.setBackgroundColor(getResources().getColor(android.R.color.black));

        // Store the default color
        defaultColor = getResources().getColor(android.R.color.black);

        // Set initial click listener for the button
        btnChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a toast when the button is clicked
                Toast.makeText(MenuExercise.this, "Button clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menuexerise, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mItemChangeColor:
                // Change color to red
                btnChanger.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_dark)));
                return true;

            case R.id.mItemChangeSize:
                // Change size to 200dp
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();
                params.width = 200;
                params.height = 200;
                btnChanger.setLayoutParams(params);

                // Set constraints to keep the button centered horizontally and vertically
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) findViewById(R.id.conslayout)); // Replace conslayout with the actual ID of your ConstraintLayout
                constraintSet.centerHorizontally(R.id.btnTransform, ConstraintSet.PARENT_ID);
                constraintSet.centerVertically(R.id.btnTransform, ConstraintSet.PARENT_ID);
                constraintSet.applyTo((ConstraintLayout) findViewById(R.id.conslayout)); // Replace conslayout with the actual ID of your ConstraintLayout

                return true;


            case R.id.mItemChangeText:
                // Change text to "Changed"
                btnChanger.setText("Changed");
                return true;

            case R.id.mItemChangeVisibility:
                // Toggle visibility
                if (btnChanger.getVisibility() == View.VISIBLE) {
                    btnChanger.setVisibility(View.INVISIBLE);
                } else {
                    btnChanger.setVisibility(View.VISIBLE);
                }
                return true;

            case R.id.mItemReset:
                // Reset to default appearance
                btnChanger.setBackgroundTintList(ColorStateList.valueOf(defaultColor)); // Reset color to default
                btnChanger.setText("Button"); // Reset text to default
                btnChanger.setVisibility(View.VISIBLE); // Reset visibility to default
                return true;


            case R.id.mItemExit:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
