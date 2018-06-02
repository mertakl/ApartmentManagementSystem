/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Apartman;
import dto.Hane;
import dto.Misafir;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author makel
 */
public class HaneAccess extends Database {

    public List<Hane> getOturan() throws SQLException {

        List<Hane> haneList = new ArrayList<Hane>();
        PreparedStatement stmt = connection.prepareStatement("SELECT do.ID\n"
                + "  , do.ADI\n"
                + "  , do.SOYADI\n"
                + "  , do.DOGUM_TARIH\n"
                + "  , do.TC_NO\n"
                + "  , do.TELEFON , do.EMAIL, do.KAN_GRUBU\n"
                + "  , d.ADI AS DURUM_ADI\n"
                + "  , do.CINSIYET\n"
                + "  , da.DAIRE_NO \n"
                + "  ,apt.APARTMAN_NO\n"
                + "  FROM DAIRE_OTURAN do\n"
                + "INNER JOIN DURUM d on d.ID = do.DURUM\n"
                + "INNER JOIN DAIRE da on da.ID = do.DAIRE_ID\n"
                + "INNER JOIN APARTMAN apt on apt.ID = da.APARTMAN_ID");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Hane hObj = new Hane();
                hObj.setId(rs.getInt("ID"));
                hObj.setAdi(rs.getString("ADI"));
                hObj.setSoyadi(rs.getString("SOYADI"));
                hObj.setDob(rs.getString("DOGUM_TARIH"));
                hObj.setTc_no(rs.getString("TC_NO"));
                hObj.setTelefon(rs.getString("TELEFON"));
                hObj.setEmail(rs.getString("EMAIL"));
                hObj.setKan_grubu(rs.getString("KAN_GRUBU"));
                hObj.setDurum(rs.getString("DURUM_ADI"));
                hObj.setCinsiyet(rs.getString("CINSIYET"));
                hObj.setDaire_no(rs.getInt("DAIRE_NO"));
                hObj.setApartman_no(rs.getString("APARTMAN_NO"));
                haneList.add(hObj);
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
        return haneList;

    }

    public List<Hane> getHaneApartman(String daire_no, String apartman_no) throws SQLException {

        List<Hane> haneList = new ArrayList<Hane>();
        PreparedStatement stmt = connection.prepareStatement("SELECT do.ID\n"
                + "    , do.ADI\n"
                + "  , do.SOYADI\n"
                + "    , do.DOGUM_TARIH\n"
                + "    , do.TC_NO\n"
                + "  , do.TELEFON , do.EMAIL, do.KAN_GRUBU\n"
                + "  , d.ADI AS DURUM_ADI\n"
                + "  , do.CINSIYET\n"
                + "  , da.DAIRE_NO \n"
                + "  ,apt.APARTMAN_NO\n"
                + "  FROM DAIRE_OTURAN do\n"
                + "INNER JOIN DURUM d on d.ID = do.DURUM\n"
                + "INNER JOIN DAIRE da on da.ID = do.DAIRE_ID\n"
                + "INNER JOIN APARTMAN apt on apt.ID = da.APARTMAN_ID  where DAIRE_NO = '"+daire_no+"' and APARTMAN_NO = '"+apartman_no+"'");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Hane hObj = new Hane();
                hObj.setId(rs.getInt("ID"));
                hObj.setAdi(rs.getString("ADI"));
                hObj.setSoyadi(rs.getString("SOYADI"));
                hObj.setDob(rs.getString("DOGUM_TARIH"));
                hObj.setTc_no(rs.getString("TC_NO"));
                hObj.setTelefon(rs.getString("TELEFON"));
                hObj.setEmail(rs.getString("EMAIL"));
                hObj.setKan_grubu(rs.getString("KAN_GRUBU"));
                hObj.setDurum(rs.getString("DURUM_ADI"));
                hObj.setCinsiyet(rs.getString("CINSIYET"));
                hObj.setDaire_no(rs.getInt("DAIRE_NO"));
                hObj.setApartman_no(rs.getString("APARTMAN_NO"));
                haneList.add(hObj);
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
        return haneList;

    }

//    public List<Hane> getKisiler() throws SQLException {
//
//        List<Hane> haneList = new ArrayList<Hane>();
//        PreparedStatement stmt = connection.prepareStatement("SELECT ID, ADI, SOYADI FROM DAIRE_OTURAN");
//        ResultSet rs = stmt.executeQuery();
//        try {
//            while (rs.next()) {
//                Hane hObj = new Hane();
//                hObj.setId(rs.getInt("ID"));
//                hObj.setAdi(rs.getString("ADI"));
//                hObj.setSoyadi(rs.getString("SOYADI"));
//                haneList.add(hObj);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException logOrIgnore) {
//                }
//            }
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException logOrIgnore) {
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException logOrIgnore) {
//                }
//            }
//        }
//        return haneList;
//
//    }
//    public int oturanAra(List<Hane> hList) {
//
//        Iterator<Hane> it = hList.iterator();
//
//        Hane h = it.next();
//
//        PreparedStatement pst = null;
//
//        ResultSet rs = null;
//
////        System.out.println("Daire no " + h.getDaire_no());
////
////        System.out.println("Apartman no " + h.getApartman_no());
//        int daire_id = 0;
//
//        try {
//            pst = connection.prepareStatement("SELECT ID FROM DAIRE WHERE APARTMAN_ID = '" + h.getApartman_no() + "' AND DAIRE_NO = '" + h.getDaire_no() + "'");
//
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//                daire_id = rs.getInt("ID");
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(HaneAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return daire_id;
//
//    }
    public boolean saveOturan(List<Hane> hList) {

//        int daire_id = oturanAra(hList);
//        System.out.println(daire_id);
        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "INSERT INTO DAIRE_OTURAN (ADI, SOYADI, DOGUM_TARIH, TC_NO, DURUM, CINSIYET, DAIRE_ID, TELEFON, EMAIL, KAN_GRUBU) VALUES (?,?,?,?,?,?,?,?,?,?)");

            Iterator<Hane> it = hList.iterator();

            while (it.hasNext()) {

                Hane h = it.next();

                stmt.setString(1, h.getAdi());

                stmt.setString(2, h.getSoyadi());

                stmt.setString(3, h.getDob());

                stmt.setString(4, h.getTc_no());

                stmt.setInt(5, Integer.parseInt(h.getDurum()));

                stmt.setString(6, h.getCinsiyet());

                stmt.setInt(7, h.getDaire_id());

                stmt.setString(8, h.getTelefon());

                stmt.setString(9, h.getEmail());

                stmt.setString(10, h.getKan_grubu());

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
        }

    }

//    public boolean idGuncelle(List<Hane> hList) {
//
//        int daire_id = oturanAra(hList);
//
//        PreparedStatement stmt = null;
//
//        ResultSet rs = null;
//
//        try {
//            stmt = connection.prepareStatement(
//                    "UPDATE DAIRE SET DAIRE_NO = ? APARTMAN_ID = ? WHERE ID = ?");
//            
//             Iterator<Hane> it = hList.iterator();
//
//            while (it.hasNext()) {
//
//                Hane h = it.next();
//
//                stmt.setInt(1, h.getDaire_no());
//
//                stmt.setInt(2, Integer.parseInt(h.getApartman_no()));
//
//                stmt.setInt(3, daire_id);
//
//                stmt.addBatch();
//            }
//
//            stmt.executeBatch();
//
//            stmt.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(HaneAccess.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return true;
//    }
    public boolean updateOturan(List<Hane> hList) {

        //      int daire_id = oturanAra(hList);
        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "UPDATE DAIRE_OTURAN SET ADI = ?, SOYADI = ?, DOGUM_TARIH = ?, TC_NO = ?, DURUM = ?, CINSIYET = ?, DAIRE_ID = ?, TELEFON = ?, EMAIL = ?, KAN_GRUBU = ?  WHERE ID = ?");
            Iterator<Hane> it = hList.iterator();

            while (it.hasNext()) {

                Hane h = it.next();

                stmt.setString(1, h.getAdi());

                stmt.setString(2, h.getSoyadi());

                stmt.setString(3, h.getDob());

                stmt.setString(4, h.getTc_no());

                stmt.setInt(5, Integer.parseInt(h.getDurum()));

                stmt.setString(6, h.getCinsiyet());
                
                stmt.setInt(7, h.getDaire_id());

                stmt.setString(8, h.getTelefon());

                stmt.setString(9, h.getEmail());

                stmt.setString(10, h.getKan_grubu());

                stmt.setInt(11, h.getId());

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

    public boolean deleteOturan(List<Hane> hList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "DELETE FROM DAIRE_OTURAN WHERE ID = ?");
            Iterator<Hane> it = hList.iterator();

            while (it.hasNext()) {

                Hane h = it.next();

                stmt.setInt(1, h.getId());

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

    public List<Hane> getDaireApartman() throws SQLException {

        List<Hane> haneList = new ArrayList<Hane>();
        PreparedStatement stmt = connection.prepareStatement("SELECT d.ID, d.DAIRE_NO, a.APARTMAN_NO FROM DAIRE d INNER JOIN APARTMAN a ON d.APARTMAN_ID = a.ID");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Hane hObj = new Hane();
                hObj.setId(rs.getInt("ID"));
                hObj.setDaire_no(rs.getInt("DAIRE_NO"));
                hObj.setApartman_no(rs.getString("APARTMAN_NO"));
                haneList.add(hObj);
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
        return haneList;

    }

}
