/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Apartman;
import dto.Daire;
import dto.Misafir;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author makel
 */
public class MisafirAccess extends Database {

    public List<Misafir> getMisafir() throws SQLException {

        List<Misafir> mList = new ArrayList<Misafir>();
        PreparedStatement stmt = connection.prepareStatement("SELECT m.ID\n"
                + "    , m.ADI\n"
                + "	, m.SOYADI\n"
                + "    , m.GTARIH\n"
                + "    , m.GSAAT\n"
                + "    , m.CTARIH\n"
                + "    , m.CSAAT\n"
                + "    , m.TELEFON\n"
                + "    , m.PLAKA\n"
                + "    , d.DAIRE_NO\n"
                + "	, a.APARTMAN_NO\n"
                + "FROM MISAFIR M\n"
                + "INNER JOIN DAIRE d\n"
                + "    on d.ID = m.DAIRE_ID\n"
                + "INNER JOIN APARTMAN a\n"
                + "    on d.APARTMAN_ID = a.ID	\n"
                + "	");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Misafir mObj = new Misafir();
                mObj.setId(rs.getInt("ID"));
                mObj.setAdi(rs.getString("ADI"));
                mObj.setSoyadi(rs.getString("SOYADI"));
                mObj.setGtar(rs.getString("GTARIH"));
                mObj.setGsaat(rs.getString("GSAAT"));
                mObj.setCtar(rs.getString("CTARIH"));
                mObj.setCsaat(rs.getString("CSAAT"));
                mObj.setTelefon(rs.getString("TELEFON"));
                mObj.setPlaka(rs.getString("PLAKA"));
                mObj.setDaire_no(rs.getInt("DAIRE_NO"));
                mObj.setApartman_no(rs.getString("APARTMAN_NO"));
                mList.add(mObj);
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
        return mList;

    }

    public boolean saveMisafir(List<Misafir> mList) {


 //       System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));

 //       System.out.println(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "INSERT INTO MISAFIR (ADI, SOYADI, DAIRE_ID, GTARIH, GSAAT, TELEFON, PLAKA) VALUES (?,?,?,?,?,?,?)");

            Iterator<Misafir> it = mList.iterator();

            while (it.hasNext()) {

                Misafir m = it.next();

                stmt.setString(1, m.getAdi());

                stmt.setString(2, m.getSoyadi());

                stmt.setInt(3, m.getDaire_no());

                stmt.setString(4, new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));

                stmt.setString(5, new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));

                stmt.setString(6, m.getTelefon());

                stmt.setString(7, m.getPlaka());

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

    public List<Apartman> getBlok() throws SQLException {

        List<Apartman> aList = new ArrayList<Apartman>();
        PreparedStatement stmt = connection.prepareStatement("SELECT ID, APARTMAN_NO FROM APARTMAN");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Apartman aObj = new Apartman();
                aObj.setId(rs.getInt("ID"));
                aObj.setApartman_no(rs.getString("APARTMAN_NO"));
                aList.add(aObj);
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
        return aList;
    }

    public List<Daire> getDaire(int apartman_id) throws SQLException {

        List<Daire> dList = new ArrayList<Daire>();
        PreparedStatement stmt = connection.prepareStatement("SELECT ID, DAIRE_NO FROM DAIRE WHERE APARTMAN_ID = '" + apartman_id + "'");

        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Daire dObj = new Daire();
                dObj.setId(rs.getInt("ID"));
                dObj.setDaire_no(rs.getInt("DAIRE_NO"));
                dList.add(dObj);
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
        return dList;

    }

    public boolean deleteMisafir(List<Misafir> mList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "DELETE FROM MISAFIR WHERE ID = ?");
            Iterator<Misafir> it = mList.iterator();

            while (it.hasNext()) {

                Misafir m = it.next();

                stmt.setInt(1, m.getId());

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
    
    public boolean exitMisafir(List<Misafir> mList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "UPDATE MISAFIR SET CTARIH = ?, CSAAT = ? WHERE ID = ?");
            Iterator<Misafir> it = mList.iterator();

            while (it.hasNext()) {

                Misafir m = it.next();

                stmt.setString(1, new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
                
                stmt.setString(2, new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));
                
                stmt.setInt(3, m.getId());

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
