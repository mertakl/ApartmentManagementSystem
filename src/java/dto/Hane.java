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
public class Hane {

    private int id;

    private String adi;

    private String soyadi;

    private String dob;

    private String tc_no;

    private String durum;

    private String cinsiyet;

    private int daire_no;

    private String apartman_no;

    private int daire_id;

    private String telefon;

    private String email;

    private String kan_grubu;

    public int getDaire_id() {
        return daire_id;
    }

    public void setDaire_id(int daire_id) {
        this.daire_id = daire_id;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKan_grubu() {
        return kan_grubu;
    }

    public void setKan_grubu(String kan_grubu) {
        this.kan_grubu = kan_grubu;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTc_no() {
        return tc_no;
    }

    public void setTc_no(String tc_no) {
        this.tc_no = tc_no;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

}
