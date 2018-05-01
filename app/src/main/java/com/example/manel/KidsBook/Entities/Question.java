package com.example.manel.KidsBook.Entities;

import java.util.Collection;

public class Question {
    private int idQuestion;
    private String titre;
    private byte[] image;
    private int idConte;
    private int idCategories;
    private int idMediascene;
    private Conte conteByIdConte;
    private Categories categoriesByIdCategories;
    private Mediascene mediasceneByIdMediascene;
    private Collection<Reponse> reponsesByIdQuestion;

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getIdConte() {
        return idConte;
    }

    public void setIdConte(int idConte) {
        this.idConte = idConte;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    public int getIdMediascene() {
        return idMediascene;
    }

    public void setIdMediascene(int idMediascene) {
        this.idMediascene = idMediascene;
    }

    public Conte getConteByIdConte() {
        return conteByIdConte;
    }

    public void setConteByIdConte(Conte conteByIdConte) {
        this.conteByIdConte = conteByIdConte;
    }

    public Categories getCategoriesByIdCategories() {
        return categoriesByIdCategories;
    }

    public void setCategoriesByIdCategories(Categories categoriesByIdCategories) {
        this.categoriesByIdCategories = categoriesByIdCategories;
    }

    public Mediascene getMediasceneByIdMediascene() {
        return mediasceneByIdMediascene;
    }

    public void setMediasceneByIdMediascene(Mediascene mediasceneByIdMediascene) {
        this.mediasceneByIdMediascene = mediasceneByIdMediascene;
    }

    public Collection<Reponse> getReponsesByIdQuestion() {
        return reponsesByIdQuestion;
    }

    public void setReponsesByIdQuestion(Collection<Reponse> reponsesByIdQuestion) {
        this.reponsesByIdQuestion = reponsesByIdQuestion;
    }
}
