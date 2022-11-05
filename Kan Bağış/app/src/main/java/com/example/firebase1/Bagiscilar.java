package com.example.firebase1;

public class Bagiscilar {

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getKan() {
        return kan;
    }

    public void setKan(String kan) {
        this.kan = kan;
    }

    public String getTelefon() { return telefon; }

    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getSehir() {
        return sehir;
    }
    public void setSehir(String sehir) {
        this.sehir = sehir;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id,isim, yas, kan,telefon,sehir;


    public Bagiscilar(String id,String isim, String yas, String kan, String telefon, String sehir)
    {
        this.id=id;
        this.isim=isim;
        this.yas=yas;
        this.kan=kan;
        this.telefon=telefon;
        this.sehir=sehir;
    }

}
