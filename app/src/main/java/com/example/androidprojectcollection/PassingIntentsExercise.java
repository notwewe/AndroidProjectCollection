package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class PassingIntentsExercise extends AppCompatActivity {

    private EditText eFName, eLName, eBDate, eNum, eMail, eAddress, eCity, eState, eCountry, ePostalCode;
    private RadioButton rMale, rFem, rOth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        eFName = findViewById(R.id.extFName);
        eLName = findViewById(R.id.extLName);
        eBDate = findViewById(R.id.extBirthDate);
        eNum = findViewById(R.id.extPhoneNumber);
        eMail = findViewById(R.id.extEmailAddress);
        eAddress = findViewById(R.id.extAddress);
        eCity = findViewById(R.id.extCity);
        eState = findViewById(R.id.extState);
        eCountry = findViewById(R.id.extCountry);
        ePostalCode = findViewById(R.id.extPostalCode);
        rMale = findViewById(R.id.radMale);
        rFem = findViewById(R.id.radFemale);
        rOth = findViewById(R.id.radOthers);

        Button submitButton = findViewById(R.id.btnSubmit);
        Button clearButton = findViewById(R.id.btnClear);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitButtonClick(v);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClearButtonClick(v);
            }
        });
    }

    public void onSubmitButtonClick(View v) {
        onClick(v);
    }

    public void onClearButtonClick(View v) {
        EditText[] editTexts = {eFName, eLName, eBDate, eNum, eMail, eAddress, eCity, eState, eCountry, ePostalCode};

        for (EditText editText : editTexts) {
            editText.getText().clear();
        }

        rMale.setChecked(false);
        rFem.setChecked(false);
        rOth.setChecked(false);
    }



    public void onClick(View v) {
        String fName = eFName.getText().toString();
        String lName = eLName.getText().toString();
        String gender;

        if (rMale.isChecked()) {
            gender = "Male";
        } else if (rFem.isChecked()) {
            gender = "Female";
        } else if (rOth.isChecked()) {
            gender = "Others";
        } else {
            gender = "Unknown";
        }

        String bDate = eBDate.getText().toString();
        String pNumber = eNum.getText().toString();
        String emailAddress = eMail.getText().toString();

        String address = eAddress.getText().toString();
        String city = eCity.getText().toString();
        String state = eState.getText().toString();
        String country = eCountry.getText().toString();
        String postalCode = ePostalCode.getText().toString();

        Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
        intent.putExtra("fname_key", fName);
        intent.putExtra("lname_key", lName);
        intent.putExtra("gender_key", gender);
        intent.putExtra("bdate_key", bDate);
        intent.putExtra("pnum_key", pNumber);
        intent.putExtra("eadd_key", emailAddress);

        intent.putExtra("address_key", address);
        intent.putExtra("city_key", city);
        intent.putExtra("state_key", state);
        intent.putExtra("country_key", country);
        intent.putExtra("postal_code_key", postalCode);

        startActivity(intent);
    }
}
