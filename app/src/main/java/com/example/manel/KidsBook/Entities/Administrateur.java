package com.example.manel.KidsBook.Entities;

import java.util.Collection;

public class Administrateur {
    private int idAdmin;
    private String nom;
    private String prenom;
    private String password;
    private String email;
    private Collection<Conte> contesByIdAdmin;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Conte> getContesByIdAdmin() {
        return contesByIdAdmin;
    }

    public void setContesByIdAdmin(Collection<Conte> contesByIdAdmin) {
        this.contesByIdAdmin = contesByIdAdmin;
    }
}
