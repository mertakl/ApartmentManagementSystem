/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author makel
 */
public class Misafir {

    private int id;

    private String adi;

    private String soyadi;

    private String gtar;

    private String gsaat;

    private String ctar;

    private String csaat;

    private int daire_no;

    private String apartman_no;

    private String plaka;

    private String telefon;

    public String getCtar() {
        return ctar;
    }

    public void setCtar(String ctar) {
        this.ctar = ctar;
    }

    public String getCsaat() {
        return csaat;
    }

    public void setCsaat(String csaat) {
        this.csaat = csaat;
    }

    public String getGsaat() {
        return gsaat;
    }

    public void setGsaat(String gsaat) {
        this.gsaat = gsaat;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getGtar() {
        return gtar;
    }

    public void setGtar(String gtar) {
        this.gtar = gtar;
    }

    public int getDaire_no() {
        return daire_no;
    }

    public void setDaire_no(int daire_no) {
        this.daire_no = daire_no;
    }

    public String getApartman_no() {
        return apartman_no;
    }

    public void setApartman_no(String apartman_no) {
        this.apartman_no = apartman_no;
    }

}
