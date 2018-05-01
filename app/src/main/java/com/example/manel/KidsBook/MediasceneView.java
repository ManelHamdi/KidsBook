package com.example.manel.KidsBook;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.manel.KidsBook.Adapter.MediasceneAdapter;

public class MediasceneView extends AppCompatActivity {
    private Context context;
    private ViewPager viewPager;
    private ConstraintLayout constraintLayout;
    private int idCnt;

    private MediasceneAdapter mediasceneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediascene_view);
        context = getApplicationContext();

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Bundle extras = getIntent().getExtras();
        idCnt = Integer.parseInt(extras.getString("idConte"));

        mediasceneAdapter = new MediasceneAdapter(this,idCnt);
        viewPager.setAdapter(mediasceneAdapter);
    }
}
