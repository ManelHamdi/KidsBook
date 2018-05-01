package com.example.manel.KidsBook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.manel.KidsBook.Adapter.MediasceneAdapter;

public class MediasceneView extends AppCompatActivity {
    private Context context;
    private ViewPager viewPager;
    private ConstraintLayout constraintLayout;
    private int idCnt;
    private MediasceneAdapter mediasceneAdapter;
    int numpagerecieve;
    private ImageView btnNext, btnBack;
    private int currentPage;
    private int lengthms;
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (position == 0) {
                btnBack.setVisibility(View.GONE);
            } else if (position == lengthms) {
                btnNext.setVisibility(View.GONE);
            } else {
                btnBack.setVisibility(View.VISIBLE);
            }
            currentPage = position;
            if (position == 1) {
                final int curent = position;
                //Toast.makeText(context,"id : "+idCnt, Toast.LENGTH_SHORT).show();
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, QuestionView.class);
                        intent.putExtra("curentpage", "" + curent);
                        intent.putExtra("idConte", "" + idCnt);
                        intent.putExtra("idMs", "" + mediasceneAdapter.getIdms());
                        startActivity(intent);
                    }
                });
                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(currentPage - 1);
                    }
                });
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private String getedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediascene_view);
        context = getApplicationContext();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            getedit = bundle.getString("edit");
            String n = bundle.getString("curentpage");
            if (getedit != null) {
                numpagerecieve = Integer.parseInt(n);
                Toast.makeText(context, "numpagerecieve : " + numpagerecieve, Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(context, "recived ms view : " + getedit, Toast.LENGTH_SHORT).show();
        }

        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        viewPager = findViewById(R.id.viewPager);

        Bundle extras = getIntent().getExtras();
        idCnt = Integer.parseInt(extras.getString("idConte"));

        mediasceneAdapter = new MediasceneAdapter(this,idCnt);
        viewPager.setAdapter(mediasceneAdapter);
        lengthms = mediasceneAdapter.getCount();

        //Toast.makeText(context,"length page : "+lengthms, Toast.LENGTH_SHORT).show();

        viewPager.addOnPageChangeListener(viewListener);

        MsQs();
    }

    public void MsQs() {
        if (currentPage == 1) {
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, QuestionView.class);
                    intent.putExtra("helloq", "after1");
                    startActivity(intent);
                }
            });
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(currentPage - 1);
                }
            });
        } else {
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(currentPage + 1);
                }
            });
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(currentPage - 1);
                }
            });
        }
    }
}

