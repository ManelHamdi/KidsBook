package com.example.manel.KidsBook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuestionView extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private String recievet;
    private String idConte;
    private String idMs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_view);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            recievet = bundle.getString("curentpage");
            idConte = bundle.getString("idConte");
            idMs = bundle.getString("idMs");
            Toast.makeText(getApplicationContext(), "recived ms view : " + recievet + "idCnt " + idConte, Toast.LENGTH_SHORT).show();
        }
    }

    public void Send(View view) {
        Intent intent = new Intent(this, MediascenelView.class);
        intent.putExtra("edit", editText.getText().toString());
        intent.putExtra("idConte", idConte);
        intent.putExtra("curentpage", recievet);
        intent.putExtra("idMs", idMs);
        startActivity(intent);
    }
}
