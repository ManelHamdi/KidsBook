package com.example.manel.KidsBook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.manel.KidsBook.Model.ListQuestion;

public class QuestionView extends AppCompatActivity {
    private RadioButton prop1, prop2, prop3;
    private String curentpage;
    private String idConte;
    private String idMs;
    private String reponse = "no reponse";
    private ImageView btnNextq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_view);

        prop1 = (RadioButton) findViewById(R.id.prop1);
        prop2 = (RadioButton) findViewById(R.id.prop2);
        prop3 = (RadioButton) findViewById(R.id.prop3);

        btnNextq = (ImageView) findViewById(R.id.btnNextq);

        prop1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(prop1.isChecked()){
                    reponse = prop1.getText().toString();
                }
            }
        });

        prop2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(prop2.isChecked()){
                    reponse = prop2.getText().toString();
                }
            }
        });

        prop3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(prop3.isChecked()){
                    reponse = prop3.getText().toString();
                }
            }
        });

        //button = findViewById(R.id.button);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            curentpage = bundle.getString("curentpage");
            idConte = bundle.getString("idConte");
            idMs = bundle.getString("idMs");
            Toast.makeText(getApplicationContext(), "recived ms view : " + curentpage + "idCnt " + idConte, Toast.LENGTH_SHORT).show();
        }
    }

    public void Send(View view) {
        Intent intent = new Intent(this, MediascenelView.class);
        intent.putExtra("reponse", reponse);
        intent.putExtra("idConte", idConte);
        intent.putExtra("curentpage", curentpage+1);
        intent.putExtra("idMs", idMs);
        startActivity(intent);
    }
}
