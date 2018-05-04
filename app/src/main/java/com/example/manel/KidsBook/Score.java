package com.example.manel.KidsBook;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Score extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        preferences = preferences = getSharedPreferences("Scoreresult", MODE_PRIVATE);
        int prop = preferences.getInt("prop", 0);
        Toast.makeText(getApplicationContext(), "input : " + prop, Toast.LENGTH_SHORT).show();
    }
}
