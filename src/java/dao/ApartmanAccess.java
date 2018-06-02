/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Apartman;
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
public class ApartmanAccess extends Database {

    public List<Apartman> getApartman() throws SQLException {
        List<Apartman> apartmanList = new ArrayList<Apartman>();
        PreparedStatement stmt = connection.prepareStatement("select apt.ID, apt.APARTMAN_NO, apt.DAIRE_SAYISI, apt.KAT_SAYISI, apt.ASANSOR_SAYISI, count(DAIRE_ID) AS OTURAN_SAYISI FROM DAIRE_OTURAN do \n"
                + "RIGHT JOIN DAIRE d ON do.daire_id = d.id \n"
                + "RIGHT JOIN APARTMAN apt on apt.ID = d.APARTMAN_ID\n"
                + "GROUP BY apt.ID,APARTMAN_NO,DAIRE_SAYISI,KAT_SAYISI,ASANSOR_SAYISI ORDER BY APARTMAN_NO ASC");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Apartman aptObj = new Apartman();
                aptObj.setId(rs.getInt("ID"));
                aptObj.setApartman_no(rs.getString("APARTMAN_NO"));
                aptObj.setDaire_sayisi(rs.getInt("DAIRE_SAYISI"));
                aptObj.setKat_sayisi(rs.getInt("KAT_SAYISI"));
                aptObj.setAsansör_sayisi(rs.getInt("ASANSOR_SAYISI"));
                aptObj.setOturan_sayisi(rs.getInt("OTURAN_SAYISI"));
                apartmanList.add(aptObj);
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
        return apartmanList;
    }

    public boolean updateApartman(List<Apartman> aList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "UPDATE APARTMAN SET APARTMAN_NO = ?, DAIRE_SAYISI = ?, KAT_SAYISI = ?, ASANSOR_SAYISI = ? WHERE ID = ?");
            Iterator<Apartman> it = aList.iterator();

            while (it.hasNext()) {

                Apartman a = it.next();
                stmt.setString(1, a.getApartman_no());
                stmt.setInt(2, a.getDaire_sayisi());
                stmt.setInt(3, a.getKat_sayisi());
                stmt.setInt(4, a.getAsansör_sayisi());
                stmt.setInt(5, a.getId());

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

        }

        return true;
    }

    public boolean saveApartman(List<Apartman> aList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "INSERT INTO APARTMAN (APARTMAN_NO, DAIRE_SAYISI, KAT_SAYISI, ASANSOR_SAYISI) VALUES (?,?,?,?)");
            Iterator<Apartman> it = aList.iterator();

            while (it.hasNext()) {

                Apartman a = it.next();
                stmt.setString(1, a.getApartman_no());
                stmt.setInt(2, a.getDaire_sayisi());
                stmt.setInt(3, a.getKat_sayisi());
                stmt.setInt(4, a.getAsansör_sayisi());

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

    public boolean deleteApartman(List<Apartman> aList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "DELETE FROM APARTMAN WHERE ID = ?");
            Iterator<Apartman> it = aList.iterator();

            while (it.hasNext()) {

                Apartman a = it.next();

                stmt.setInt(1, a.getId());

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

        }

        return true;

    }

}
