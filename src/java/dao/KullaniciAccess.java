/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Kullanici;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author makel
 */
public class KullaniciAccess extends Database {

    public List<Kullanici> getKullanici() throws SQLException {
        List<Kullanici> kullaniciList = new ArrayList<Kullanici>();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM KULLANICI");
        ResultSet rs = stmt.executeQuery();
        try {
            while (rs.next()) {
                Kullanici kObj = new Kullanici();
                kObj.setId(rs.getInt("ID"));
                kObj.setAdi(rs.getString("ADI"));
                kObj.setSoyadi(rs.getString("SOYADI"));
                kObj.setKullanici_adi(rs.getString("KULLANICI_ADI"));
                kObj.setSifre(rs.getString("SIFRE"));
                kObj.setEmail(rs.getString("EMAİL"));
                kullaniciList.add(kObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kullaniciList;
    }

    public boolean saveKullanici(List<Kullanici> kList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "INSERT INTO KULLANICI (ADI, SOYADI, KULLANICI_ADI, SIFRE, EMAIL) VALUES (?,?,?,?,?)");

            Iterator<Kullanici> it = kList.iterator();

            while (it.hasNext()) {

                Kullanici k = it.next();

                stmt.setString(1, k.getAdi());

                stmt.setString(2, k.getSoyadi());

                stmt.setString(3, k.getKullanici_adi());

                stmt.setString(4, k.getSifre());

                stmt.setString(5, k.getEmail());

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

    public boolean updateKullanici(List<Kullanici> kList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "UPDATE KULLANICI SET ADI = ?, SOYADI = ?, KULLANICI_ADI = ?, SIFRE = ?, EMAIL = ? WHERE ID = ?");
            Iterator<Kullanici> it = kList.iterator();

            while (it.hasNext()) {

                Kullanici k = it.next();

                stmt.setString(1, k.getAdi());

                stmt.setString(2, k.getSoyadi());

                stmt.setString(3, k.getKullanici_adi());

                stmt.setString(4, k.getSifre());

                stmt.setString(5, k.getEmail());

                stmt.setInt(6, k.getId());

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

    public boolean deleteKullanici(List<Kullanici> kList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "DELETE FROM KULLANICI WHERE ID = ?");
            Iterator<Kullanici> it = kList.iterator();

            while (it.hasNext()) {

                Kullanici k = it.next();

                stmt.setInt(1, k.getId());

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

    public boolean sendEmail(List<Kullanici> kList) {

        String email = null;

        Iterator<Kullanici> it = kList.iterator();

        while (it.hasNext()) {

            Kullanici k = it.next();

            email = k.getEmail();
        }

        try {

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); // for gmail use smtp.gmail.com
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("akelmert95@gmail.com", "241.M1e2r3t4");
                }
            });

            mailSession.setDebug(true); // Enable the debug mode

            Message msg = new MimeMessage(mailSession);

            //--[ Set the FROM, TO, DATE and SUBJECT fields
            msg.setFrom(new InternetAddress("akelmert95@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            msg.setSentDate(new Date());
            msg.setSubject("Şifre Yenileme");

            //--[ Create the body of the mail
            msg.setText("Şifre isteğiniz için gerekli link aşağıdadaır!");

            msg.setText("http://10.6.10.108:8080/SiteYonetim/yeniSifre.html");

            //--[ Ask the Transport class to send our mail message
            Transport.send(msg);

        } catch (Exception E) {
            System.out.println("Oops something has gone pearshaped!");
            System.out.println(E);
        }

        return true;

    }

    public boolean renewSifre(List<Kullanici> kList) {

        PreparedStatement stmt = null;

        try {

            stmt = connection.prepareStatement(
                    "UPDATE KULLANICI SET SIFRE = ?  WHERE KULLANICI_ADI = ?");
            Iterator<Kullanici> it = kList.iterator();

            while (it.hasNext()) {

                Kullanici k = it.next();

                stmt.setString(1, k.getSifre());

                stmt.setString(2, k.getKullanici_adi());

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
