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
public class Daire {

    private int id;

    private int daire_no;

    private int kat;

    private int otopark_id;

    private int daire_oturan_id; //OTURANLARDAN ÇEKİLECEK

    private String daire_oturan_adi; //OTURANLARDAN ÇEKİLECEK

    private String daire_oturan_soyadi;  //OTURANLARDAN ÇEKİLECEK

    private String durum;  //DURUMDAN ÇEKİLECEK

    private String otopark;  //OTOPARKTAN ÇEKİLECEK

    private String apartman_no;  //APARTMANDAN ÇEKİLECEK

    private String daire_tipi;  //DAİRE TİPİNDEN ÇEKİLECEK

    private int daire_tipi_id;

    private int metrekare;

    private int balkon_sayisi;

    public int getMetrekare() {
        return metrekare;
    }

    public void setMetrekare(int metrekare) {
        this.metrekare = metrekare;
    }

    public int getBalkon_sayisi() {
        return balkon_sayisi;
    }

    public void setBalkon_sayisi(int balkon_sayisi) {
        this.balkon_sayisi = balkon_sayisi;
    }

    public int getDaire_tipi_id() {
        return daire_tipi_id;
    }

    public void setDaire_tipi_id(int daire_tipi_id) {
        this.daire_tipi_id = daire_tipi_id;
    }

    public int getOtopark_id() {
        return otopark_id;
    }

    public void setOtopark_id(int otopark_id) {
        this.otopark_id = otopark_id;
    }

    public int getDaire_oturan_id() {
        return daire_oturan_id;
    }

    public void setDaire_oturan_id(int daire_oturan_id) {
        this.daire_oturan_id = daire_oturan_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDaire_no() {
        return daire_no;
    }

    public void setDaire_no(int daire_no) {
        this.daire_no = daire_no;
    }

    public int getKat() {
        return kat;
    }

    public void setKat(int kat) {
        this.kat = kat;
    }

    public String getDaire_oturan_adi() {
        return daire_oturan_adi;
    }

    public void setDaire_oturan_adi(String daire_oturan_adi) {
        this.daire_oturan_adi = daire_oturan_adi;
    }

    public String getDaire_oturan_soyadi() {
        return daire_oturan_soyadi;
    }

    public void setDaire_oturan_soyadi(String daire_oturan_soyadi) {
        this.daire_oturan_soyadi = daire_oturan_soyadi;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getOtopark() {
        return otopark;
    }

    public void setOtopark(String otopark) {
        this.otopark = otopark;
    }

    public String getApartman_no() {
        return apartman_no;
    }

    public void setApartman_no(String apartman_no) {
        this.apartman_no = apartman_no;
    }

    public String getDaire_tipi() {
        return daire_tipi;
    }

    public void setDaire_tipi(String daire_tipi) {
        this.daire_tipi = daire_tipi;
    }

}
