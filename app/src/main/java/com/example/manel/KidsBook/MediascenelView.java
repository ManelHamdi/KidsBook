package com.example.manel.KidsBook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.manel.KidsBook.Adapter.MediascenelAdapter;
import com.example.manel.KidsBook.Entities.Question;
import com.example.manel.KidsBook.Model.ListQuestion;

public class MediascenelView extends AppCompatActivity {
    int numpagerecieve;
    private Context context;
    private ViewPager viewPager;
    private Question question;
    private ConstraintLayout constraintLayout;
    private int idCnt;
    private int idms;
    private MediascenelAdapter mediascenelAdapter;
    private ImageView btnNext, btnBack;
    private int currentPage;
    private int lengthms;
    private Intent i;
    private int selectedpagepos;

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            testm(position);
            /*selectedpagepos = position;
            if (position == 0) {
                btnBack.setVisibility(View.GONE);
            } else if (position == lengthms-1) {
                //btnNext.setVisibility(View.GONE);
            } else {
                btnBack.setVisibility(View.VISIBLE);
            }*/
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

        i = new Intent(context, QuestionView.class);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            getedit = bundle.getString("reponse");
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
        idms = Integer.parseInt(extras.getString("idMs"));

        mediascenelAdapter = new MediascenelAdapter(this, idCnt, idms);
        Log.e("lenghtimsl", "" + mediascenelAdapter.getCount() + " idms " + idms);
        viewPager.setAdapter(mediascenelAdapter);
        lengthms = mediascenelAdapter.getCount();

        viewPager.addOnPageChangeListener(viewListener);

        MsQs();
    }

    public void MsQs() {
        Log.e("curentqqqqb", "" + currentPage);
        if (currentPage != -2) {
            currentPage -= 1;
            Log.e("curentqqqqa", "" + currentPage);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*viewPager.setCurrentItem(currentPage + 1);
                    Log.e("qqqqqqq",""+question);*/
                    //Intent i = new Intent(context, QuestionView.class);
                    i.putExtra("curentpage", "" + selectedpagepos);
                    i.putExtra("idConte", "" + idCnt);
                    i.putExtra("idMs", "" + mediascenelAdapter.getIdms());
                    i.putExtra("helloq", "after1");
                    startActivity(i);
                }
            });
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(selectedpagepos - 1);
                }
            });
        } else {
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(selectedpagepos + 1);
                }
            });
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(selectedpagepos - 1);
                }
            });
        }
    }

    public void testm(int position) {
        ListQuestion lstqs = new ListQuestion(idCnt, mediascenelAdapter.getIdms(), context);
        question = lstqs.doInBackground();

        try {
            if (!question.getTitre().isEmpty()) {
                Log.e("hhhhhh", "hihihi");
                Log.e("hhhhhh", "hihihi" + mediascenelAdapter.getIdms());
                btnNext.setVisibility(View.VISIBLE);
                clickaftertest(mediascenelAdapter.getIdms(), question.getTitre());
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            Log.e("hhhhhheeeeeeeeeeee", "hihihieeeeeeeeeeee");
            Log.e("hhhhhheeeeeeeeeeee", "hihihieeeeeeeeeeee" + mediascenelAdapter.getIdms());
            btnNext.setVisibility(View.GONE);
        }
    }

    public void clickaftertest(final int idm, String titre) {
        final int idd = idm;
        final String titr = titre;
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("curentpage", "" + selectedpagepos);
                i.putExtra("idConte", "" + idCnt);
                i.putExtra("idMs", "" + idd);
                i.putExtra("helloq", "after1");
                i.putExtra("titre", titr);
                startActivity(i);
            }
        });
    }
}

