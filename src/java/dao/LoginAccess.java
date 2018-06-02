/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author makel
 */
public class LoginAccess extends Database{
    
    

    public static Login kullaniciOnayla(Login login){
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        try {

            stmt = connection.prepareStatement("SELECT * FROM KULLANICI where KULLANICI_ADI = ? AND " + "SIFRE = ?");

            stmt.setString(1, login.getKullanici());
            stmt.setString(2, login.getSifre());

            rs = stmt.executeQuery();

            boolean exist = rs.next();

            if (!exist) {

//                System.out.println("Kayıtlı kullanıcı değil!");
                login.setGecerli(false);

            } else {

//                System.out.println("Ok!");
                login.setGecerli(true);

            }

        } catch (Exception e) {

            System.out.println(e);

        }finally {
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

        return login;
    }

}
