package com.example.manel.KidsBook.Model;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

import com.example.manel.KidsBook.Adapter.ConteAdapter;
import com.example.manel.KidsBook.Entities.Conte;
import com.example.manel.KidsBook.R;

import pl.droidsonroids.gif.GifImageView;

public class ListConte extends AsyncTask<Void, Void, Conte[]> {
    Context context;
    RecyclerView.Adapter adapt;
    RecyclerView recView;
    GridLayoutManager grlm;
    GifImageView gifImageView;

    public ListConte(Context context, RecyclerView.Adapter adapt, RecyclerView recView, GridLayoutManager grlm, GifImageView gifImageView) {
        this.context = context;
        this.adapt = adapt;
        this.recView = recView;
        this.grlm = grlm;
        this.gifImageView = gifImageView;
    }

    @Override
    protected Conte[] doInBackground(Void... voids) {
        Conte[] contes;
        ConteMOD conteMOD = new ConteMOD();
        contes = conteMOD.listcnt();
        return contes;
    }

    @Override
    protected void onPostExecute(Conte[] contes) {
        super.onPostExecute(contes);
        try {
            adapt = new ConteAdapter(contes, context);
            recView.setAdapter(adapt);
            recView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onGlobalLayout() {
                    recView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int viewWidth = recView.getMeasuredWidth();
                    float cardViewWidth = context.getResources().getDimension(R.dimen.card_view_width);
                    int newSpanCount = (int) Math.floor(viewWidth / cardViewWidth);
                    grlm.setSpanCount(newSpanCount);
                    grlm.requestLayout();
                }
            });
            gifImageView.setVisibility(View.GONE);
            for (Conte c : contes) {
                Log.i("Conte ", "**************************");
                Log.i("idCnt: ", String.valueOf(c.getIdConte()));
                Log.i("Titre: ", c.getTitre());
            }
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }
    }
}
