package com.example.manel.KidsBook.Model;


import android.content.Context;
import android.os.AsyncTask;

import com.example.manel.KidsBook.Entities.Question;

public class ListQuestion extends AsyncTask<Void, Void, Question> {

    private int idConte;
    private int idMs;
    private Context context;

    public ListQuestion(int idConte, int idMs, Context context) {
        this.idConte = idConte;
        this.idMs = idMs;
        this.context = context;
    }

    @Override
    public Question doInBackground(Void... voids) {
        Question question;
        QuestionMOD questionMOD = new QuestionMOD(context, idConte, idMs);
        question = questionMOD.quest();
        return question;
    }

    @Override
    protected void onPostExecute(Question question) {
        super.onPostExecute(question);
    }
}
