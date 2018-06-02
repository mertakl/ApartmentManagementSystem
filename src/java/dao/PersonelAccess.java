/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Personel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author makel
 */
public class PersonelAccess extends Database {

    public List<Personel> getPersonel() throws SQLException {
        List<Personel> personelList = new ArrayList<Personel>();
        PreparedStatement stmt = connection.prepareStatement("SELECT h.ID, h.ADI, h.SOYADI, h.TELEFON, h.ADRES, h.DOGUM_TARIH, h.TC_NO, h.BRUT_MAAS, d.ADI AS DURUM_ADI, apt.APARTMAN_NO\n"
                + "FROM HIZMETLI h\n"
                + "INNER JOIN DURUM d ON d.ID = h.DURUM \n"
                + "INNER JOIN APARTMAN apt ON apt.ID = h.APARTMAN_ID");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Personel pObj = new Personel();
                pObj.setId(rs.getInt("ID"));
                pObj.setAdi(rs.getString("ADI"));
                pObj.setSoyadi(rs.getString("SOYADI"));
                pObj.setTelefon(rs.getString("TELEFON"));
                pObj.setAdres(rs.getString("ADRES"));
                pObj.setDogum_tarih(rs.getString("DOGUM_TARIH"));
                pObj.setTc_no(rs.getString("TC_NO"));
                pObj.setBrut_maas(rs.getInt("BRUT_MAAS"));
                pObj.setDurum(rs.getString("DURUM_ADI"));
                pObj.setApartman_no(rs.getString("APARTMAN_NO"));
                personelList.add(pObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (connection != null) {

            }
        }
        return personelList;
    }

    public List<Personel> getPersonelById(String aptno) throws SQLException {

        List<Personel> personelList = new ArrayList<Personel>();
        PreparedStatement stmt = connection.prepareStatement("SELECT h.ID, h.ADI, h.SOYADI, h.TELEFON, h.ADRES, h.DOGUM_TARIH, h.TC_NO, h.BRUT_MAAS, d.ADI AS DURUM_ADI, apt.APARTMAN_NO\n" +
"                FROM HIZMETLI h\n" +
"                INNER JOIN DURUM d ON d.ID = h.DURUM \n" +
"                INNER JOIN APARTMAN apt ON apt.ID = h.APARTMAN_ID WHERE apt.APARTMAN_NO = '"+aptno+"'");
        
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Personel pObj = new Personel();
                pObj.setId(rs.getInt("ID"));
                pObj.setAdi(rs.getString("ADI"));
                pObj.setSoyadi(rs.getString("SOYADI"));
                pObj.setTelefon(rs.getString("TELEFON"));
                pObj.setAdres(rs.getString("ADRES"));
                pObj.setDogum_tarih(rs.getString("DOGUM_TARIH"));
                pObj.setTc_no(rs.getString("TC_NO"));
                pObj.setBrut_maas(rs.getInt("BRUT_MAAS"));
                pObj.setDurum(rs.getString("DURUM_ADI"));
//                pObj.setApartman_no(rs.getString("APARTMAN_NO"));
                personelList.add(pObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (connection != null) {

            }
        }
        return personelList;
    }

    public boolean savePersonel(List<Personel> pList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "INSERT INTO HIZMETLI (ADI, SOYADI, TELEFON, ADRES, DOGUM_TARIH, TC_NO, BRUT_MAAS, DURUM, APARTMAN_ID) VALUES (?,?,?,?,?,?,?,?,?)");

            Iterator<Personel> it = pList.iterator();

            while (it.hasNext()) {

                Personel p = it.next();

                stmt.setString(1, p.getAdi());

                stmt.setString(2, p.getSoyadi());

                stmt.setString(3, p.getTelefon());

                stmt.setString(4, p.getAdres());

                stmt.setString(5, p.getDogum_tarih());

                stmt.setString(6, p.getTc_no());

                stmt.setInt(7, p.getBrut_maas());

                stmt.setInt(8, Integer.parseInt(p.getDurum()));

                stmt.setInt(9, Integer.parseInt(p.getApartman_no()));

                stmt.addBatch();

            }

            stmt.executeBatch();

            return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (connection != null) {

            }
        }

    }

    public boolean updatePersonel(List<Personel> pList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "UPDATE HIZMETLI SET ADI = ?, SOYADI = ?, TELEFON = ?, ADRES = ?, DOGUM_TARIH = ?, TC_NO = ?, BRUT_MAAS = ?, DURUM = ?, APARTMAN_ID = ? WHERE ID = ?");
            Iterator<Personel> it = pList.iterator();

            while (it.hasNext()) {

                Personel p = it.next();

                stmt.setString(1, p.getAdi());
                stmt.setString(2, p.getSoyadi());
                stmt.setString(3, p.getTelefon());
                stmt.setString(4, p.getAdres());
                stmt.setString(5, p.getDogum_tarih());
                stmt.setString(6, p.getTc_no());
                stmt.setInt(7, p.getBrut_maas());
                stmt.setInt(8, Integer.parseInt(p.getDurum()));
                stmt.setInt(9, Integer.parseInt(p.getApartman_no()));
                stmt.setInt(10, p.getId());

                stmt.addBatch();
            }

            stmt.executeBatch();

            stmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return false;

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (connection != null) {

            }
        }

        return true;
    }

    public boolean deleteApartman(List<Personel> pList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "DELETE FROM HIZMETLI WHERE ID = ?");
            Iterator<Personel> it = pList.iterator();

            while (it.hasNext()) {

                Personel p = it.next();

                stmt.setInt(1, p.getId());

                stmt.addBatch();
            }

            stmt.executeBatch();

            stmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            return false;

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (connection != null) {

            }
        }

        return true;

    }

}
