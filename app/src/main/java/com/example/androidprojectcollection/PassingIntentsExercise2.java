package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        TextView tFName = findViewById(R.id.txtPI2FName);
        TextView tLName = findViewById(R.id.txtPI2LName);
        TextView tGender = findViewById(R.id.txtPI2Gender);
        TextView tBDate = findViewById(R.id.txtPI2BDate);
        TextView tPNum = findViewById(R.id.txtPI2Number);
        TextView tEmail = findViewById(R.id.txtPI2Email);
        TextView tAddress = findViewById(R.id.txtPI2Address);
        TextView tCity = findViewById(R.id.txtPI2City);
        TextView tState = findViewById(R.id.txtPI2State);
        TextView tCountry = findViewById(R.id.txtPI2Country);
        TextView tPostalCode = findViewById(R.id.txtPI2PostalCode);

        Intent intent = getIntent();
        String fName = intent.getStringExtra("fname_key");
        String lName = intent.getStringExtra("lname_key");
        String gender = intent.getStringExtra("gender_key");
        String bDate = intent.getStringExtra("bdate_key");
        String pNum = intent.getStringExtra("pnum_key");
        String email = intent.getStringExtra("eadd_key");
        String address = intent.getStringExtra("address_key");
        String city = intent.getStringExtra("city_key");
        String state = intent.getStringExtra("state_key");
        String country = intent.getStringExtra("country_key");
        String postalCode = intent.getStringExtra("postal_code_key");

        tFName.setText(fName);
        tLName.setText(lName);
        tGender.setText(gender);
        tBDate.setText(bDate);
        tPNum.setText(pNum);
        tEmail.setText(email);
        tAddress.setText(address);
        tCity.setText(city);
        tState.setText(state);
        tCountry.setText(country);
        tPostalCode.setText(postalCode);

        Button returnButton = findViewById(R.id.btnPI2Return);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent(PassingIntentsExercise2.this, PassingIntentsExercise.class);
                startActivity(returnIntent);
                finish();
            }
        });
    }
}
