package com.example.onmad;

public class sinhvienLop {
    int ma,masv,malop,kyhoc,sotinchi;
    public sinhvienLop(){

    }

    public sinhvienLop(int ma, int masv, int malop, int kyhoc, int sotinchi) {
        this.ma = ma;
        this.masv = masv;
        this.malop = malop;
        this.kyhoc = kyhoc;
        this.sotinchi = sotinchi;
    }

    public sinhvienLop(int masv, int malop, int sotinchi, int kyhoc) {
        this.masv = masv;
        this.malop = malop;
        this.kyhoc = kyhoc;
        this.sotinchi = sotinchi;
    }
    public String toObject(){
        return masv+"      "+malop+"      "+sotinchi+"      "+kyhoc;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public int getMalop() {
        return malop;
    }

    public void setMalop(int malop) {
        this.malop = malop;
    }

    public int getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(int kyhoc) {
        this.kyhoc = kyhoc;
    }

    public int getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(int sotinchi) {
        this.sotinchi = sotinchi;
    }
}
