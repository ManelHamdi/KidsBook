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

import com.example.manel.KidsBook.Adapter.MediasceneAdapter;
import com.example.manel.KidsBook.Entities.Question;
import com.example.manel.KidsBook.Model.ListQuestion;

public class MediasceneView extends AppCompatActivity {
    private Context context;
    private ViewPager viewPager;
    private ConstraintLayout constraintLayout;
    private int idCnt;
    private MediasceneAdapter mediasceneAdapter;
    int numpagerecieve;
    private ImageView btnNext, btnBack, btnNextq;
    private int currentPage = -2;
    private int lengthms;
    private Question question;
    private int selectedpagepos;
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
        btnNextq = findViewById(R.id.btnNextq);
        btnBack = findViewById(R.id.btnBack);

        viewPager = findViewById(R.id.viewPager);


        Bundle extras = getIntent().getExtras();
        idCnt = Integer.parseInt(extras.getString("idConte"));

        mediasceneAdapter = new MediasceneAdapter(this, idCnt);
        viewPager.setAdapter(mediasceneAdapter);
        lengthms = mediasceneAdapter.getCount();

        //Toast.makeText(context,"length page : "+lengthms, Toast.LENGTH_SHORT).show();


        viewPager.addOnPageChangeListener(viewListener);
        //testm(0);
        //MsQs();
    }

    public void MsQs() {
        /*ListQuestion lstqs = new ListQuestion(idCnt, mediasceneAdapter.getIdms(), context);
        question = lstqs.doInBackground();
        try {
            if (!question.getTitre().isEmpty()) {
                Log.e("hhhhhh","hihihi");
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }

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
            });*/
    }

    public void testm(int position) {
        ListQuestion lstqs = new ListQuestion(idCnt, mediasceneAdapter.getIdms(), context);
        question = lstqs.doInBackground();

        try {
            if (!question.getTitre().isEmpty()) {
                Log.e("hhhhhh", "hihihi");
                Log.e("hhhhhh", "hihihi" + mediasceneAdapter.getIdms());
                btnNextq.setVisibility(View.VISIBLE);
                clickaftertest(mediasceneAdapter.getIdms(), question.getIdQuestion(), question.getTitre(), question.getImage());
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            Log.e("hhhhhheeeeeeeeeeee", "hihihieeeeeeeeeeee");
            Log.e("hhhhhheeeeeeeeeeee", "hihihieeeeeeeeeeee" + mediasceneAdapter.getIdms());
            btnNextq.setVisibility(View.GONE);
        }
    }

    public void clickaftertest(final int idm, final int idqs, final String titre, final byte[] img) {
        btnNextq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("curentpage", "" + selectedpagepos);
                i.putExtra("idConte", "" + idCnt);
                i.putExtra("idMs", "" + idm);
                i.putExtra("reponse", "r");
                i.putExtra("helloq", "after1");
                i.putExtra("titre", titre);
                i.putExtra("img", img);
                i.putExtra("idQs", idqs);
                i.putExtra("end", end);
                startActivity(i);
            }
        });
    }
}
