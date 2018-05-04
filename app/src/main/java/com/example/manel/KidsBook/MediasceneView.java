package com.example.manel.KidsBook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.manel.KidsBook.Adapter.MediasceneAdapter;
import com.example.manel.KidsBook.Entities.Question;
import com.example.manel.KidsBook.Model.ListQuestion;

import java.util.Locale;

public class MediasceneView extends AppCompatActivity {
    private Context context;
    private ViewPager viewPager;
    private ConstraintLayout constraintLayout;
    private int idCnt, numpagerecieve, lengthms, selectedpagepos;
    private MediasceneAdapter mediasceneAdapter;
    private ImageView btnNext, btnBack, btnNextq, btnLast;
    private int currentPage = -2;
    private Question question;
    Intent i;
    private String getedit;
    String end = "";
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
            String n = bundle.getString("curentpage");
            if (getedit != null) {
                numpagerecieve = Integer.parseInt(n);
                // Toast.makeText(context, "numpagerecieve : " + numpagerecieve, Toast.LENGTH_SHORT).show();
            }
            // Toast.makeText(context, "recived ms view : " + getedit, Toast.LENGTH_SHORT).show();
        }

        btnNext = findViewById(R.id.btnNext);
        btnNextq = findViewById(R.id.btnNextq);
        btnBack = findViewById(R.id.btnBack);
        btnLast = findViewById(R.id.btnLast);

        viewPager = findViewById(R.id.viewPager);


        Bundle extras = getIntent().getExtras();
        idCnt = Integer.parseInt(extras.getString("idConte"));

        mediasceneAdapter = new MediasceneAdapter(this, idCnt, textToSpeech);
        viewPager.setAdapter(mediasceneAdapter);
        lengthms = mediasceneAdapter.getCount();

        viewPager.addOnPageChangeListener(viewListener);

        MsQs();
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

    public void testm(int position) {
        ListQuestion lstqs = new ListQuestion(idCnt, mediasceneAdapter.getIdms(), context);
        question = lstqs.doInBackground();

        try {
            if (!question.getTitre().isEmpty()) {
                btnNextq.setVisibility(View.VISIBLE);
                clickaftertest(mediasceneAdapter.getIdms(), question.getIdQuestion(), question.getTitre(), question.getImage());
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
                i.putExtra("curentpage", "" + selectedpagepos);
                i.putExtra("idConte", "" + idCnt);
                i.putExtra("idMs", "" + idm);
                i.putExtra("reponse", getedit);
                i.putExtra("helloq", "after1");
                i.putExtra("titre", titre);
                i.putExtra("img", img);
                i.putExtra("idQs", idqs);
                i.putExtra("end", end);
                startActivity(i);
            }
        });
    }

    public void DontSpeak(View view) {
    }

    public void yesSpeak(View view) {
    }
}
