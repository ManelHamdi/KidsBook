package com.example.manel.KidsBook.Entities;

import java.util.Collection;

public class Conte {
    private int idConte;
    private String titre;
    private byte[] imgconte;
    private int idAdmin;
    private Administrateur administrateurByIdAdmin;
    private Collection<Mediascene> mediascenesByIdConte;
    private Collection<Question> questionsByIdConte;

    public int getIdConte() {
        return idConte;
    }

    public void setIdConte(int idConte) {
        this.idConte = idConte;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public byte[] getImgconte() {
        return imgconte;
    }

    public void setImgconte(byte[] imgconte) {
        this.imgconte = imgconte;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    public Administrateur getAdministrateurByIdAdmin() {
        return administrateurByIdAdmin;
    }

    public void setAdministrateurByIdAdmin(Administrateur administrateurByIdAdmin) {
        this.administrateurByIdAdmin = administrateurByIdAdmin;
    }

   public Collection<Mediascene> getMediascenesByIdConte() {
        return mediascenesByIdConte;
    }

    public void setMediascenesByIdConte(Collection<Mediascene> mediascenesByIdConte) {
        this.mediascenesByIdConte = mediascenesByIdConte;
    }

    public Collection<Question> getQuestionsByIdConte() {
        return questionsByIdConte;
    }

    public void setQuestionsByIdConte(Collection<Question> questionsByIdConte) {
        this.questionsByIdConte = questionsByIdConte;
    }
}
