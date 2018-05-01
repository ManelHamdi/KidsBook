package com.example.manel.KidsBook.Model;

import android.content.Context;
import android.os.AsyncTask;

import com.example.manel.KidsBook.Entities.Mediascene;

public class ListMediascenel extends AsyncTask<Void, Void, Mediascene[]> {

    private int idConte;
    private int idMs;
    private Context context;

    public ListMediascenel(int idConte, int idMs, Context context) {
        this.idConte = idConte;
        this.idMs = idMs;
        this.context = context;
    }

    @Override
    public Mediascene[] doInBackground(Void... voids) {
        Mediascene[] mediascenes;
        MediasceneMOD mediasceneMOD = new MediasceneMOD(context);
        mediascenes = mediasceneMOD.listMedsl(idConte, idMs);
        return mediascenes;
    }

    @Override
    protected void onPostExecute(Mediascene[] mediascenes) {
        super.onPostExecute(mediascenes);
    }
}
