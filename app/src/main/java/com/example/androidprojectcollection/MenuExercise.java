package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;
    int defaultColor; // Variable to store the default color
    int originalWidth, originalHeight; // Variables to store the original width and height
    Drawable originalBackground; // Variable to store the original background drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransform);

        // Set the background color of the button to black
        btnChanger.setBackgroundColor(getResources().getColor(android.R.color.black));

        // Store the default color
        defaultColor = getResources().getColor(android.R.color.black);
        originalBackground = btnChanger.getBackground();


        // Add a layout listener to capture the original size after layout
        btnChanger.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // Retrieve the original width and height
                originalWidth = btnChanger.getWidth();
                originalHeight = btnChanger.getHeight();

                // Remove the listener to avoid multiple calls
                btnChanger.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

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
                // Cycle through different colors
                int[] colors = {
                        android.R.color.holo_red_dark,
                        android.R.color.holo_orange_dark,
                        android.R.color.holo_blue_bright
                };
                int currentColor = btnChanger.getBackgroundTintList().getDefaultColor();
                int nextColor = colors[0]; // Default to the first color
                for (int i = 0; i < colors.length; i++) {
                    if (currentColor == getResources().getColor(colors[i])) {
                        // Get the next color in the array
                        nextColor = colors[(i + 1) % colors.length];
                        break;
                    }
                }
                btnChanger.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(nextColor)));
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

            case R.id.mItemChangeSquare:
                // Change shape to square
                btnChanger.setBackgroundResource(R.drawable.square);
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
                btnChanger.setBackground(originalBackground); // Reset background to original
                btnChanger.setBackgroundTintList(ColorStateList.valueOf(defaultColor)); // Reset color to default
                btnChanger.setText("Button"); // Reset text to default
                btnChanger.setVisibility(View.VISIBLE); // Reset visibility to default

                // Reset size to original dimensions
                ConstraintLayout.LayoutParams defaultParams = (ConstraintLayout.LayoutParams) btnChanger.getLayoutParams();
                defaultParams.width = originalWidth;
                defaultParams.height = originalHeight;
                btnChanger.setLayoutParams(defaultParams);

                // Set constraints to keep the button centered horizontally and vertically
                ConstraintSet resetConstraintSet = new ConstraintSet();
                resetConstraintSet.clone((ConstraintLayout) findViewById(R.id.conslayout)); // Replace conslayout with the actual ID of your ConstraintLayout
                resetConstraintSet.centerHorizontally(R.id.btnTransform, ConstraintSet.PARENT_ID);
                resetConstraintSet.centerVertically(R.id.btnTransform, ConstraintSet.PARENT_ID);
                resetConstraintSet.applyTo((ConstraintLayout) findViewById(R.id.conslayout)); // Replace conslayout with the actual ID of your ConstraintLayout

                return true;

            case R.id.mItemExit:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
