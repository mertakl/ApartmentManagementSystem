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
public class Site {

    private String adi;

    private String adres;

    private int blok_sayi;

    private int daire_sayi;

    private String telefon;

    private String fax;

    private String yetkili_adi;

    private String yetkili_soyadi;

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getYetkili_adi() {
        return yetkili_adi;
    }

    public void setYetkili_adi(String yetkili_adi) {
        this.yetkili_adi = yetkili_adi;
    }

    public String getYetkili_soyadi() {
        return yetkili_soyadi;
    }

    public void setYetkili_soyadi(String yetkili_soyadi) {
        this.yetkili_soyadi = yetkili_soyadi;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getBlok_sayi() {
        return blok_sayi;
    }

    public void setBlok_sayi(int blok_sayi) {
        this.blok_sayi = blok_sayi;
    }

    public int getDaire_sayi() {
        return daire_sayi;
    }

    public void setDaire_sayi(int daire_sayi) {
        this.daire_sayi = daire_sayi;
    }

}
