package com.example.manel.KidsBook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.manel.KidsBook.Adapter.MediascenelAdapter;
import com.example.manel.KidsBook.Entities.Question;
import com.example.manel.KidsBook.Model.ListQuestion;

import java.util.Locale;

public class MediascenelView extends AppCompatActivity {
    private Context context;
    private ViewPager viewPager;
    private Question question;
    private ConstraintLayout constraintLayout;
    private int idCnt, idms, lengthms, currentPage, selectedpagepos, s, count, numpagerecieve;
    private String end = "";
    private MediascenelAdapter mediascenelAdapter;
    private ImageView btnNext, btnBack, btnNextq, btnLast;
    private Intent i;
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            testm(position);
            if (position == lengthms - 1) {
                end = "fin";
            }
            selectedpagepos = position;
            if (position == 0) {
                btnBack.setVisibility(View.GONE);
            } else {
                btnBack.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private TextToSpeech textToSpeech;

    private String getedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediascene_view);
        context = getApplicationContext();
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.FRANCE);
                }
            }
        });
        i = new Intent(context, QuestionView.class);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            getedit = bundle.getString("reponse");
            s = bundle.getInt("nbrs");
            count = bundle.getInt("count");
            String n = bundle.getString("curentpage");
            if (getedit != null) {
                numpagerecieve = Integer.parseInt(n);
                //Toast.makeText(context, "numpagerecieve : " + numpagerecieve, Toast.LENGTH_SHORT).show();
            }
            //Toast.makeText(context, "recived ms view : " + getedit, Toast.LENGTH_SHORT).show();
        }

        btnNext = findViewById(R.id.btnNext);
        btnNextq = findViewById(R.id.btnNextq);
        btnBack = findViewById(R.id.btnBack);
        btnLast = findViewById(R.id.btnLast);

        viewPager = findViewById(R.id.viewPager);

        Bundle extras = getIntent().getExtras();
        idCnt = Integer.parseInt(extras.getString("idConte"));
        idms = Integer.parseInt(extras.getString("idMs"));

        mediascenelAdapter = new MediascenelAdapter(this, textToSpeech, idCnt, idms);
        //Log.e("lenghtimsl", "" + mediascenelAdapter.getCount() + " idms " + idms);
        viewPager.setAdapter(mediascenelAdapter);
        lengthms = mediascenelAdapter.getCount();

        viewPager.addOnPageChangeListener(viewListener);
        MsQs();
    }

    public void testm(int position) {
        ListQuestion lstqs = new ListQuestion(idCnt, mediascenelAdapter.getIdms(), context);
        question = lstqs.doInBackground();

        try {
            if (!question.getTitre().isEmpty()) {
                btnNextq.setVisibility(View.VISIBLE);
                clickaftertest(mediascenelAdapter.getIdms(), question.getIdQuestion(), question.getTitre(), question.getImage());
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            btnNextq.setVisibility(View.GONE);
            if (position == lengthms - 1) {
                btnNext.setVisibility(View.GONE);
                btnLast.setVisibility(View.VISIBLE);
                btnLast.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Score.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    public void clickaftertest(final int idm, final int idqs, final String titre, final byte[] img) {
        btnNextq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("anser1133", "" + s);
                i.putExtra("curentpage", "" + selectedpagepos);
                i.putExtra("idConte", "" + idCnt);
                i.putExtra("idMs", "" + idm);
                i.putExtra("reponse", getedit);
                i.putExtra("nbrs", s);
                i.putExtra("count", count);
                i.putExtra("helloq", "after1");
                i.putExtra("titre", titre);
                i.putExtra("img", img);
                i.putExtra("idQs", idqs);
                i.putExtra("end", end);
                startActivity(i);
            }
        });
    }

    public void MsQs() {
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

    public void score() {

    }

}

