package com.example.caoviet.timetableapp.Main;

public class Documents {
    private int IdDocuments;
    private String Text;

    public Documents(int idDocuments, String text) {
        IdDocuments = idDocuments;
        Text = text;
    }

    public int getIdDocuments() {
        return IdDocuments;
    }

    public void setIdDocuments(int idDocuments) {
        IdDocuments = idDocuments;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
