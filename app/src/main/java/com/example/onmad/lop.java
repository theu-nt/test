package com.example.onmad;

public class lop {
    int malop;
    String tenlop,mota;
    public lop(){

    }

    public lop(int malop, String tenlop, String mota) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.mota = mota;
    }
    public lop( String tenlop, String mota) {
        this.tenlop = tenlop;
        this.mota = mota;
    }
public String toObject(){
        return malop+"        "+tenlop+"        "+mota;
}

    public int getMalop() {
        return malop;
    }

    public void setMalop(int malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
