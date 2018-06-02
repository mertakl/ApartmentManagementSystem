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
public class Apartman {

    private int id;

    private String apartman_no;

    private int daire_sayisi;

    private int kat_sayisi;

    private int asansör_sayisi;

    private int oturan_sayisi;

    public int getOturan_sayisi() {
        return oturan_sayisi;
    }

    public void setOturan_sayisi(int oturan_sayisi) {
        this.oturan_sayisi = oturan_sayisi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApartman_no() {
        return apartman_no;
    }

    public void setApartman_no(String apartman_no) {
        this.apartman_no = apartman_no;
    }

    public int getDaire_sayisi() {
        return daire_sayisi;
    }

    public void setDaire_sayisi(int daire_sayisi) {
        this.daire_sayisi = daire_sayisi;
    }

    public int getKat_sayisi() {
        return kat_sayisi;
    }

    public void setKat_sayisi(int kat_sayisi) {
        this.kat_sayisi = kat_sayisi;
    }

    public int getAsansör_sayisi() {
        return asansör_sayisi;
    }

    public void setAsansör_sayisi(int asansör_sayisi) {
        this.asansör_sayisi = asansör_sayisi;
    }

}
