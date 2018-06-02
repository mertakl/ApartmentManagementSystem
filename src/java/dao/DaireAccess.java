/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Daire;
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
public class DaireAccess extends Database {

    public List<Daire> getDaire() throws SQLException {
        List<Daire> daireList = new ArrayList<Daire>();
        PreparedStatement stmt = connection.prepareStatement("SELECT d.ID, d.DAIRE_NO, do.ADI, do.SOYADI, do.ID AS DAIRE_OTURAN_ID, d.KATI, du.ADI AS DURUM, o.KODU,\n"
                + "apt.APARTMAN_NO, dt.TİPİ\n"
                + "FROM DAIRE d\n"
                + "INNER JOIN DAIRE_OTURAN do ON d.ID = do.DAIRE_ID \n"
                + "INNER JOIN DURUM du ON du.ID = d.DURUM \n"
                + "INNER JOIN OTOPARK o ON o.ID = d.OTOPARK_ID\n"
                + "INNER JOIN APARTMAN apt ON apt.ID = d.APARTMAN_ID \n"
                + "INNER JOIN DAIRE_TIPI dt ON dt.ID = d.DAIRE_TIPI_ID ");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Daire dObj = new Daire();
                dObj.setId(rs.getInt("ID"));
                dObj.setDaire_no(rs.getInt("DAIRE_NO"));
                dObj.setKat(rs.getInt("KATI"));
                dObj.setDaire_oturan_adi(rs.getString("ADI"));
                dObj.setDaire_oturan_soyadi(rs.getString("SOYADI"));
                dObj.setDaire_oturan_id(rs.getInt("DAIRE_OTURAN_ID"));
                dObj.setDurum(rs.getString("DURUM"));
                dObj.setOtopark(rs.getString("KODU"));
                dObj.setApartman_no(rs.getString("APARTMAN_NO"));
                dObj.setDaire_tipi(rs.getString("TİPİ"));
                daireList.add(dObj);
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

        return daireList;

    }

    public List<Daire> getDaireler() throws SQLException {
        List<Daire> daireList = new ArrayList<Daire>();
        PreparedStatement stmt = connection.prepareStatement("SELECT d.ID, d.DAIRE_NO, d.KATI, d.METREKARE, d.BALKON_SAYISI, du.ADI AS DURUM, o.KODU,\n"
                + "                apt.APARTMAN_NO, dt.TİPİ\n"
                + "                FROM DAIRE d\n"
                + "                INNER JOIN DURUM du ON du.ID = d.DURUM \n"
                + "                INNER JOIN OTOPARK o ON o.ID = d.OTOPARK_ID\n"
                + "                INNER JOIN APARTMAN apt ON apt.ID = d.APARTMAN_ID\n"
                + "                INNER JOIN DAIRE_TIPI dt ON dt.ID = d.DAIRE_TIPI_ID ");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Daire dObj = new Daire();
                dObj.setId(rs.getInt("ID"));
                dObj.setDaire_no(rs.getInt("DAIRE_NO"));
                dObj.setKat(rs.getInt("KATI"));
                dObj.setMetrekare(rs.getInt("METREKARE"));
                dObj.setBalkon_sayisi(rs.getInt("BALKON_SAYISI"));
                dObj.setDurum(rs.getString("DURUM"));
                dObj.setOtopark(rs.getString("KODU"));
                dObj.setApartman_no(rs.getString("APARTMAN_NO"));
                dObj.setDaire_tipi(rs.getString("TİPİ"));
                daireList.add(dObj);
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

        return daireList;

    }

    public boolean updateDaire(List<Daire> dList) throws SQLException {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "UPDATE DAIRE SET DAIRE_NO = ?, KATI = ?, METREKARE = ?, BALKON_SAYISI = ?, DURUM = ?, OTOPARK_ID = ?, APARTMAN_ID = ?, DAIRE_TIPI_ID = ?  WHERE ID = ?");
            Iterator<Daire> it = dList.iterator();

            while (it.hasNext()) {

                Daire d = it.next();

//                System.out.println(d.getDaire_no());
//                
//                System.out.println(d.getKat());
//                
//                System.out.println(d.getDurum());
//                
//                System.out.println(d.getDaire_no());
//                
//                System.out.println(d.getDaire_no());
//                
//                System.out.println(d.getDaire_no());
                stmt.setInt(1, d.getDaire_no());

                stmt.setInt(2, d.getKat());

                stmt.setInt(3, d.getMetrekare());

                stmt.setInt(4, d.getBalkon_sayisi());

                stmt.setInt(5, Integer.parseInt(d.getDurum()));

                stmt.setInt(6, Integer.parseInt(d.getOtopark()));

                stmt.setInt(7, Integer.parseInt(d.getApartman_no()));

                stmt.setInt(8, Integer.parseInt(d.getDaire_tipi()));

                stmt.setInt(9, d.getId());

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

    public List<Daire> getOtopark() throws SQLException {

        List<Daire> daireList = new ArrayList<Daire>();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM OTOPARK");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Daire dObj = new Daire();

                dObj.setOtopark_id(rs.getInt("ID"));

                dObj.setOtopark(rs.getString("KODU"));

                daireList.add(dObj);
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
        }
        return daireList;

    }

    public List<Daire> getTipi() throws SQLException {

        List<Daire> daireList = new ArrayList<Daire>();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM DAIRE_TIPI");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Daire dObj = new Daire();

                dObj.setDaire_tipi_id(rs.getInt("ID"));

                dObj.setDaire_tipi(rs.getString("TİPİ"));

                daireList.add(dObj);
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
        }
        return daireList;

    }

    public boolean insertDaire(List<Daire> dList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "INSERT INTO DAIRE (DAIRE_NO, KATI, DURUM, OTOPARK_ID, APARTMAN_ID, DAIRE_TIPI_ID, METREKARE, BALKON_SAYISI) VALUES (?,?,?,?,?,?,?,?)");
            Iterator<Daire> it = dList.iterator();

            while (it.hasNext()) {

                Daire d = it.next();

                stmt.setInt(1, d.getDaire_no());

                stmt.setInt(2, d.getKat());

                stmt.setInt(3, Integer.parseInt(d.getDurum()));

                stmt.setInt(4, Integer.parseInt(d.getOtopark()));

                stmt.setInt(5, Integer.parseInt(d.getApartman_no()));

                stmt.setInt(6, Integer.parseInt(d.getDaire_tipi()));

                stmt.setInt(7, d.getMetrekare());

                stmt.setInt(8, d.getBalkon_sayisi());

                stmt.addBatch();
            }

            stmt.executeBatch();

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
        }

        return true;

    }

}
