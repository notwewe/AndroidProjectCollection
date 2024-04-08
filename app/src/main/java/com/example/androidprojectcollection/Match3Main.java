package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
//import https://chat.openai.com/share/9afdee5f-153a-4946-b5f6-67c3610dd689;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Match3Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match3);

        Button btnOpen = (Button) findViewById(R.id.btnMatch3);

        btnOpen.setOnClickListener(view -> {
            Intent intent = new Intent(Match3Main.this, Match3Activity.class);
            startActivity(intent);
            Toast toast = Toast.makeText(Match3Main.this, "Francis Wedemeyer Dayagro, Match 3", Toast.LENGTH_SHORT);
            toast.show();
        });
    }
}