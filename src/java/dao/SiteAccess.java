/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Site;
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
public class SiteAccess extends Database {

    public List<Site> getSite() throws SQLException {

        List<Site> siteList = new ArrayList<Site>();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM SITE");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Site siteObj = new Site();
                
                siteObj.setAdi(rs.getString("ADI"));
                siteObj.setAdres(rs.getString("ADRES"));
                siteObj.setBlok_sayi(rs.getInt("BLOK_SAYI"));
                siteObj.setDaire_sayi(rs.getInt("DAIRE_SAYI"));
                siteObj.setTelefon(rs.getString("TELEFON"));
                siteObj.setFax(rs.getString("FAX"));
                siteObj.setYetkili_adi(rs.getString("YETKILI_ADI"));
                siteObj.setYetkili_soyadi(rs.getString("YETKILI_SOYADI"));
                siteList.add(siteObj);
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
        return siteList;
    }

    public boolean updateSite(List<Site> sList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "UPDATE SITE SET ADI = ?, ADRES = ?, BLOK_SAYI = ?, DAIRE_SAYI = ?, TELEFON = ?, FAX = ?, YETKILI_ADI = ?, YETKILI_SOYADI = ?");
            Iterator<Site> it = sList.iterator();

            while (it.hasNext()) {

                Site s = it.next();

                stmt.setString(1, s.getAdi());
                stmt.setString(2, s.getAdres());
                stmt.setInt(3, s.getBlok_sayi());
                stmt.setInt(4, s.getDaire_sayi());
                stmt.setString(5, s.getTelefon());
                stmt.setString(6, s.getFax());
                stmt.setString(7, s.getYetkili_adi());
                stmt.setString(8, s.getYetkili_soyadi());
                
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
