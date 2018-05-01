package com.example.manel.KidsBook.Entities;

public class Reponse {
    private int idReponse;
    private String texteReponse1;
    private String texteReponse2;
    private String texteReponse3;
    private String correcte;
    private int idQuestion;
    private Question questionByIdQuestion;

    public int getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public String getTexteReponse1() {
        return texteReponse1;
    }

    public void setTexteReponse1(String texteReponse1) {
        this.texteReponse1 = texteReponse1;
    }

    public String getTexteReponse2() {
        return texteReponse2;
    }

    public void setTexteReponse2(String texteReponse2) {
        this.texteReponse2 = texteReponse2;
    }

    public String getTexteReponse3() {
        return texteReponse3;
    }

    public void setTexteReponse3(String texteReponse3) {
        this.texteReponse3 = texteReponse3;
    }

    public String getCorrecte() {
        return correcte;
    }

    public void setCorrecte(String correcte) {
        this.correcte = correcte;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Question getQuestionByIdQuestion() {
        return questionByIdQuestion;
    }

    public void setQuestionByIdQuestion(Question questionByIdQuestion) {
        this.questionByIdQuestion = questionByIdQuestion;
    }
}
