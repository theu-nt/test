package com.example.onmad;

public class sinhvien {
    String tensv,quequan;
    int masv,namsinh,namhoc;
    public sinhvien(){}

    public sinhvien(int masv, String tensv, String quequan, int namsinh, int namhoc) {
        this.masv = masv;
        this.tensv = tensv;
        this.quequan = quequan;
        this.namsinh = namsinh;
        this.namhoc = namhoc;
    }
    public sinhvien( String tensv, String quequan, int namsinh, int namhoc) {
        this.tensv = tensv;
        this.quequan = quequan;
        this.namsinh = namsinh;
        this.namhoc = namhoc;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public int getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(int namhoc) {
        this.namhoc = namhoc;
    }
    public String toObject(){
        return masv+"      "+tensv+"      "+quequan+"      "+namsinh+"      "+namhoc;
    }

}
