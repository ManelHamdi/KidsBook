package com.example.manel.KidsBook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.manel.KidsBook.Entities.Reponse;
import com.example.manel.KidsBook.Model.ListReponse;

import java.util.Locale;

public class QuestionView extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private RadioButton prop1, prop2, prop3;
    private TextView txtTitre;
    private String curentpage, idMs, idConte, correcteprop, rrr, fin;
    private String reponse = "no reponse";
    private int idQs, s, count = 0;
    private ImageView img, btnnextq, btnendq;
    private ListReponse listReponse;
    private Context context;
    private Reponse rep;
    private SharedPreferences preferences;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_view);
        context = getApplicationContext();

        textToSpeech = new TextToSpeech(this, this);

        btnnextq = findViewById(R.id.btnNextq);
        btnendq = findViewById(R.id.btnEndq);

        prop1 = findViewById(R.id.prop1);
        prop2 = findViewById(R.id.prop2);
        prop3 = findViewById(R.id.prop3);

        txtTitre = findViewById(R.id.titreQues);

        img = findViewById(R.id.imgQues);

        prop1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (prop1.isChecked()) {
                    reponse = "proposition1";
                }
            }
        });

        prop2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (prop2.isChecked()) {
                    reponse = "proposition2";
                }
            }
        });

        prop3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (prop3.isChecked()) {
                    reponse = "proposition3";
                }
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            curentpage = bundle.getString("curentpage");
            idConte = bundle.getString("idConte");
            idMs = bundle.getString("idMs");
            idQs = bundle.getInt("idQs");
            fin = bundle.getString("end");
            if (fin.equals("fin")) {
                btnnextq.setVisibility(View.GONE);
                btnendq.setVisibility(View.VISIBLE);
            }
            s = bundle.getInt("nbrs");
            count = bundle.getInt("count");

            txtTitre.setText(bundle.getString("titre"));

            textToSpeech.speak(bundle.getString("titre"), TextToSpeech.QUEUE_FLUSH, null);

            byte[] imgb = bundle.getByteArray("img");
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgb, 0, imgb.length);
            img.setImageBitmap(bitmap);

            listReponse = new ListReponse(context, idQs);
            rep = listReponse.doInBackground();

            prop1.setText(rep.getTexteReponse1());
            prop2.setText(rep.getTexteReponse2());
            prop3.setText(rep.getTexteReponse3());
            correcteprop = rep.getCorrecte();
        }
        speakout();
    }

    public void Send(View view) {
        if (reponse.equals(rep.getCorrecte())) {
            s += 1;
            rrr = "ui";
        } else {
            rrr = "nn";
        }
        preferences = getSharedPreferences("Scoreresult", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("prop", s);
        editor.putInt("count", count + 1);
        editor.commit();

        Intent intent = new Intent(this, MediascenelView.class);
        intent.putExtra("reponse", "" + rrr);
        intent.putExtra("nbrs", s);
        intent.putExtra("count", count + 1);
        intent.putExtra("idConte", idConte);
        intent.putExtra("curentpage", curentpage + 1);
        intent.putExtra("idMs", idMs);
        startActivity(intent);
    }

    public void Endq(View view) {
        if (reponse.equals(rep.getCorrecte())) {
            s += 1;
            rrr = "ui";
        } else {
            rrr = "nn";
        }
        preferences = getSharedPreferences("Scoreresult", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("prop", s);
        editor.putInt("count", count + 1);
        editor.commit();

        Intent intent = new Intent(getApplicationContext(), Score.class);
        startActivity(intent);
    }

    @Override
    public void onInit(int status) {
        if (status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.FRANCE);
            speakout();
        }
    }

    private void speakout() {
        String txt = txtTitre.getText().toString();
        textToSpeech.speak(txt, TextToSpeech.QUEUE_FLUSH, null);
    }
}
