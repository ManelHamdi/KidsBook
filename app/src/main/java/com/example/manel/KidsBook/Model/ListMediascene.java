package com.example.manel.KidsBook.Model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.manel.KidsBook.Entities.Mediascene;

public class ListMediascene extends AsyncTask<Void, Void, Mediascene[]> {
    private  int idConte;
    private  Context context;

    public ListMediascene(int idConte, Context context) {
        this.idConte = idConte;
        this.context = context;
    }

    @Override
    public Mediascene[] doInBackground(Void... voids) {
        Mediascene[] mediascenes;
        MediasceneMOD mediasceneMOD = new MediasceneMOD(context);
        mediascenes = mediasceneMOD.listMeds(idConte);
        //Log.e("tablengthidl",""+idConte);
        //Toast.makeText(context, "do in background length "+mediascenes.length , Toast.LENGTH_LONG).show();
        return mediascenes;
    }

    @Override
    protected void onPostExecute(Mediascene[] mediascenes) {
        super.onPostExecute(mediascenes);
    }
}
