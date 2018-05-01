package com.example.manel.KidsBook.Entities;

import java.util.Collection;

public class Mediascene {
    private int idMediascene;
    private String texte;
    private int numOrdre;
    private byte[] img;
    private byte[] audio;
    private int idConte;
    private Conte conteByIdConte;
    private Collection<Question> questionsByIdMediascene;

    public int getIdMediascene() {
        return idMediascene;
    }

    public void setIdMediascene(int idMediascene) {
        this.idMediascene = idMediascene;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(int numOrdre) {
        this.numOrdre = numOrdre;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public byte[] getAudio() {
        return audio;
    }

    public void setAudio(byte[] audio) {
        this.audio = audio;
    }

    public int getIdConte() {
        return idConte;
    }

    public void setIdConte(int idConte) {
        this.idConte = idConte;
    }

    public Conte getConteByIdConte() {
        return conteByIdConte;
    }

    public void setConteByIdConte(Conte conteByIdConte) {
        this.conteByIdConte = conteByIdConte;
    }

    public Collection<Question> getQuestionsByIdMediascene() {
        return questionsByIdMediascene;
    }

    public void setQuestionsByIdMediascene(Collection<Question> questionsByIdMediascene) {
        this.questionsByIdMediascene = questionsByIdMediascene;
    }
}
