package com.example.manel.KidsBook.Model;

import android.content.Context;
import android.os.AsyncTask;

import com.example.manel.KidsBook.Entities.Reponse;

public class ListReponse extends AsyncTask<Void, Void, Reponse> {

    private int idQs;
    private Context context;

    public ListReponse(Context context, int idQs) {
        this.context = context;
        this.idQs = idQs;
    }

    @Override
    public Reponse doInBackground(Void... voids) {
        Reponse reponse;
        ReponseMOD reponseMOD = new ReponseMOD(context, idQs);
        reponse = reponseMOD.rep();
        return reponse;
    }

    @Override
    protected void onPostExecute(Reponse reponse) {
        super.onPostExecute(reponse);
    }
}
