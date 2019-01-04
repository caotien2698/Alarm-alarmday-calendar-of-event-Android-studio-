package com.example.caoviet.timetableapp.Main;

public class Subject {
    private int IdSubject;
    private String Subject_name;
    private String Subject_time;
    private String Subject_day;

    public Subject(int idSubject, String subject_name, String subject_time,String subject_day) {
        IdSubject = idSubject;
        Subject_name = subject_name;
        Subject_time = subject_time;
        Subject_day=subject_day;
    }

    public int getIdSubject() {
        return IdSubject;
    }

    public void setIdSubject(int idSubject) {
        IdSubject = idSubject;
    }

    public String getSubject_name() {
        return Subject_name;
    }

    public void setSubject_name(String subject_name) {
        Subject_name = subject_name;
    }

    public String getSubject_time() {
        return Subject_time;
    }

    public void setSubject_time(String subject_time) {
        Subject_time = subject_time;
    }
    public String getSubject_day(){
        return Subject_day;
    }

    public void setSubject_day(String subject_day) {
        Subject_day = subject_day;
    }
}
