package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MenuExercise extends AppCompatActivity {

    FloatingActionButton btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransform);
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
                btnChanger.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_red_dark)));
                return true;

            case R.id.mItemChangeSize:
                btnChanger.setSize(FloatingActionButton.SIZE_AUTO);
                return true;

            case R.id.mItemChangeIcon:
                btnChanger.setImageResource(R.drawable.ic_android);
                btnChanger.setImageResource(R.drawable.baseline_airline_seat_flat_24);

                return true;

            case R.id.mItemChangeText:
                btnChanger.setContentDescription("Changed");
                return true;

            case R.id.mItemChangeVisibility:
                btnChanger.hide();
                return true;

            case R.id.mItemReset:
                btnChanger.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_blue_dark)));
                btnChanger.setSize(FloatingActionButton.SIZE_NORMAL);
                btnChanger.setImageResource(R.drawable.baseline_accessibility);
                btnChanger.setContentDescription("Add");
                btnChanger.show();
                return true;

            case R.id.mItemExit:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
