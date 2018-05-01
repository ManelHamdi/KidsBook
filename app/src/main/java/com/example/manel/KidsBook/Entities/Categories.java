package com.example.manel.KidsBook.Entities;

import java.util.Collection;

public class Categories {
    private int idCategories;
    private String typeCategories;
    private Collection<Question> questionsByIdCategories;

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }

    public String getTypeCategories() {
        return typeCategories;
    }

    public void setTypeCategories(String typeCategories) {
        this.typeCategories = typeCategories;
    }

    public Collection<Question> getQuestionsByIdCategories() {
        return questionsByIdCategories;
    }

    public void setQuestionsByIdCategories(Collection<Question> questionsByIdCategories) {
        this.questionsByIdCategories = questionsByIdCategories;
    }
}
