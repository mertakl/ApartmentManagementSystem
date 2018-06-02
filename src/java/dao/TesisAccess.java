/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Tesis;
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
public class TesisAccess extends Database {

    public List<Tesis> getTesis() throws SQLException {
        List<Tesis> tList = new ArrayList<Tesis>();
        PreparedStatement stmt = connection.prepareStatement("SELECT \n"
                + "st.ID\n"
                + ",do.ADI\n"
                + ",do.SOYADI\n"
                + ",d.DAIRE_NO\n"
                + ",st.UYELIK_UCRET\n"
                + ",a.APARTMAN_NO\n"
                + ",du.ADI as DURUM\n"
                + "FROM SOSYAL_TESIS st\n"
                + "INNER JOIN DAIRE d ON d.ID = st.DAIRE_ID\n"
                + "INNER JOIN DURUM du ON du.ID = st.DURUM \n"
                + "INNER JOIN APARTMAN a ON d.APARTMAN_ID = a.ID \n"
                + "INNER JOIN DAIRE_OTURAN do ON st.UYE_ID = do.ID ");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Tesis tObj = new Tesis();
                tObj.setId(rs.getInt("ID"));
                tObj.setAdi(rs.getString("ADI"));
                tObj.setSoyadi(rs.getString("SOYADI"));
                tObj.setDaire_no(rs.getInt("DAIRE_NO"));
                tObj.setApartman_no(rs.getString("APARTMAN_NO"));
                tObj.setUyelik_ucret(rs.getInt("UYELIK_UCRET"));
                tObj.setDurum(rs.getString("DURUM"));
                tList.add(tObj);
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
        return tList;
    }

    public boolean saveTesis(List<Tesis> tList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "INSERT INTO SOSYAL_TESIS (DAIRE_ID, UYELIK_UCRET, DURUM, UYE_ID) VALUES (?,?,?,?)");

            Iterator<Tesis> it = tList.iterator();

            while (it.hasNext()) {

                Tesis t = it.next();

                stmt.setInt(1, t.getDaire_no());

                stmt.setInt(2, t.getUyelik_ucret());

                stmt.setInt(3, Integer.parseInt(t.getDurum()));

                stmt.setInt(4, t.getUye_id());

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

    public boolean updateTesis(List<Tesis> tList) {
        
        int daire_id;

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "UPDATE SOSYAL_TESIS SET DAIRE_ID = ?, UYELIK_UCRET = ?, DURUM = ?, UYE_ID = ?  WHERE ID = ?");

            Iterator<Tesis> it = tList.iterator();

            while (it.hasNext()) {

                Tesis t = it.next();

                daire_id = getDaireId(t.getApartman_no(), t.getDaire_no());
                
      //          System.out.println(daire_id);
                
                stmt.setInt(1, daire_id);
                
                stmt.setInt(2, t.getUyelik_ucret());
                
                stmt.setInt(3, Integer.parseInt(t.getDurum()));
                
                stmt.setInt(4, t.getUye_id());
                
                stmt.setInt(5, t.getId());

                stmt.addBatch();

            }

            stmt.executeBatch();
            
            stmt.executeUpdate();

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

    private int getDaireId(String apartman_no, int daire_no) throws SQLException {
        
    //    List<Tesis> tList = new ArrayList<Tesis>();
    
//        System.out.println(apartman_no);
//        
//        System.out.println(daire_no);

        PreparedStatement stmt = connection.prepareStatement("SELECT ID  FROM DAIRE  WHERE DAIRE_NO = '"+daire_no+"' AND APARTMAN_ID = '"+apartman_no+"'");
        ResultSet rs = stmt.executeQuery();
        int daire_id = 0;
        try {
            
            while (rs.next()) {
                
                daire_id = rs.getInt("ID");
    //            tList.add(tObj);
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
        
        System.out.println(daire_id);
        
        return daire_id;
    }

    public boolean deleteTesis(List<Tesis> tList) {
       PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "DELETE FROM SOSYAL_TESIS WHERE ID = ?");
            Iterator<Tesis> it = tList.iterator();

            while (it.hasNext()) {

                Tesis t = it.next();

                stmt.setInt(1, t.getId());

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
