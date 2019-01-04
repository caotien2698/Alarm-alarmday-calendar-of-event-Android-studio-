package com.example.caoviet.timetableapp.Main;



public class Week {

    private String Ten;
    private String Noidung;
    private int Hinh;

    public Week(String ten, String noidung, int hinh) {
        Ten = ten;
        Noidung = noidung;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String noidung) {
        Noidung = noidung;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
