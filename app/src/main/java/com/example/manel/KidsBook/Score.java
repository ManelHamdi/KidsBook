package com.example.manel.KidsBook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Score extends AppCompatActivity {

    SharedPreferences preferences;
    private GifImageView gifscoreBravo, gifscoreMoyenne, gifscoreNotGood;
    private TextView txtScore;
    private int prop, count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        preferences = getSharedPreferences("Scoreresult", MODE_PRIVATE);
        prop = preferences.getInt("prop", 0);
        count = preferences.getInt("count", 0);
        //Toast.makeText(getApplicationContext(), "input : " + prop + " count : " + count, Toast.LENGTH_SHORT).show();

        txtScore = findViewById(R.id.txtScore);
        gifscoreBravo = findViewById(R.id.gifscoreBravo);
        gifscoreMoyenne = findViewById(R.id.gifscoreMoyenne);
        gifscoreNotGood = findViewById(R.id.gifscoreNotGood);

        double c = count * 100;
        double s = prop * 100;
        double cc = c / 3;
        double ss = s / 3;
        int scor = (int) ss;
        if (ss > cc / 2) {
            gifscoreBravo.setVisibility(View.VISIBLE);
        } else if (ss < cc / 2) {
            gifscoreNotGood.setVisibility(View.VISIBLE);
        } else {
            gifscoreMoyenne.setVisibility(View.VISIBLE);
        }

        //Toast.makeText(getApplicationContext(), "score : " + scor +" cc "+cc, Toast.LENGTH_SHORT).show();

        txtScore.setText(scor + " % ");
    }

    public void goHome(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("prop");
        editor.remove("count");
        editor.commit();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
