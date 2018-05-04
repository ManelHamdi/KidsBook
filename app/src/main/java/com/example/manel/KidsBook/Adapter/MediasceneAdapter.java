package com.example.manel.KidsBook.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manel.KidsBook.Entities.Mediascene;
import com.example.manel.KidsBook.Model.ListMediascene;
import com.example.manel.KidsBook.R;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

public class MediasceneAdapter extends PagerAdapter implements TextToSpeech.OnInitListener {
    private Context context;
    private LayoutInflater layoutInflater;
    private int idCnt;
    private int idms;
    TextView textMs;
    private TextToSpeech textToSpeech;
    private Mediascene[] listMs;

    public MediasceneAdapter(Context context, int idCnt, TextToSpeech textToSpeech) {
        this.context = context;
        this.idCnt = idCnt;
        this.textToSpeech = textToSpeech;
    }

    public Mediascene[] getlistMs() {
        listMs = new ListMediascene(idCnt, context).doInBackground();
        return listMs;
    }

    @Override
    public int getCount() {
        int count = 0;
        //Log.e("tablengthidla",""+idCnt);
        try {
            count = getlistMs().length;
        } catch (Exception e) {
            Log.e("erreur in adapter", "" + e);
            Toast.makeText(context, "Something went wrong, Verify your connexion", Toast.LENGTH_LONG).show();
            Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();
        }
        return count;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        textToSpeech = new TextToSpeech(context, this);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.mediascene_list, container, false);
        TextView txtid = view.findViewById(R.id.idMs);
        textMs = view.findViewById(R.id.textMs);
        ImageView imgMs = view.findViewById(R.id.imgMs);

        txtid.setText(String.valueOf(getlistMs()[position].getIdMediascene()));
        //txtid.setText(""+1);
        idms = getlistMs()[position].getIdMediascene();
        textMs.setText(getlistMs()[position].getTexte());
        speakout();
        byte[] img = getlistMs()[position].getImg();
        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50 / 100, new ByteArrayOutputStream());
        imgMs.setImageBitmap(bitmap);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
        //super.destroyItem(container, position, object);
    }

    public int getIdms() {
        return idms;
    }

    @Override
    public void onInit(int status) {
        if (status != TextToSpeech.ERROR) {
            textToSpeech.setLanguage(Locale.FRANCE);
            speakout();
        }
    }

    private void speakout() {
        String txt = textMs.getText().toString();
        textToSpeech.speak(txt, TextToSpeech.QUEUE_FLUSH, null);
    }
}
