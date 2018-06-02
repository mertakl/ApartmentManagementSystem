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
public class Tesis {

    private int id;

    private String adi;

    private String soyadi;

    private int uye_id;

    private int daire_no;

    private int uyelik_ucret;

    private String durum;

    private String apartman_no;

    public int getUye_id() {
        return uye_id;
    }

    public void setUye_id(int uye_id) {
        this.uye_id = uye_id;
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

    public int getDaire_no() {
        return daire_no;
    }

    public void setDaire_no(int daire_no) {
        this.daire_no = daire_no;
    }

    public int getUyelik_ucret() {
        return uyelik_ucret;
    }

    public void setUyelik_ucret(int uyelik_ucret) {
        this.uyelik_ucret = uyelik_ucret;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

}
