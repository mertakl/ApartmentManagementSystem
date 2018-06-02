/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiteService;

import com.google.gson.Gson;
import dao.KullaniciAccess;
import dto.Kullanici;
import dto.Personel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author makel
 */
@Path("/service")
public class KullaniciService {

    KullaniciAccess kc = new KullaniciAccess();

    @GET
    @Path("/getKullanici")
    @Produces("application/json")
    public Response getPersonel() {

        String kullanici = null;
        List<Kullanici> kList = new ArrayList<Kullanici>();
        try {
            kList = new KullaniciAccess().getKullanici();
            Gson gson = new Gson();
            kullanici = gson.toJson(kList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(kullanici).header("Access-Control-Allow-Origin", "*").build();
    }

    // Apartman ekleme
    @POST
    @Path("/insertKullanici")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response createKullanici(@FormParam("adi") String adi,
            @FormParam("soyadi") String soyadi, @FormParam("kullanici_adi") String kullanici_adi,
            @FormParam("sifre") String sifre, @FormParam("email") String email) throws SQLException {

//        System.out.println(adi);
//        
//        System.out.println(soyadi);
//        
//        System.out.println(kullanici_adi);
//        
//        System.out.println(sifre);
//        
//        System.out.println(email);
//        
        Kullanici k = new Kullanici();

        List<Kullanici> kList = new ArrayList<Kullanici>();

        k.setAdi(adi);

        k.setSoyadi(soyadi);

        k.setKullanici_adi(kullanici_adi);

        k.setSifre(sifre);

        k.setEmail(email);

        kList.add(k);

        if (kc.saveKullanici(kList) == true) {

            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/updateKullanici")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response updatePersonel(
            @FormParam("id") int id, @FormParam("adi") String adi,
            @FormParam("soyadi") String soyadi, @FormParam("kullanici_adi") String kullanici_adi,
            @FormParam("sifre") String sifre, @FormParam("email") String email) throws SQLException {

        Kullanici k = new Kullanici();

        List<Kullanici> kList = new ArrayList<Kullanici>();

        k.setId(id);

        k.setAdi(adi);

        k.setSoyadi(soyadi);

        k.setKullanici_adi(kullanici_adi);

        k.setSifre(sifre);

        k.setEmail(email);

        kList.add(k);

        if (kc.updateKullanici(kList) == true) {

            return Response.ok("Basariyla Güncellendi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/deleteKullanici")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response deleteKullanici(@FormParam("id") int id) throws SQLException {

        Kullanici k = new Kullanici();

        List<Kullanici> kList = new ArrayList<Kullanici>();

        k.setId(id);

        kList.add(k);

        if (kc.deleteKullanici(kList) == true) {

            return Response.ok("Basariyla Silindi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/frgtPassword")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response frgtPassword(@FormParam("email") String email) throws SQLException {

        Kullanici k = new Kullanici();

        List<Kullanici> kList = new ArrayList<Kullanici>();

        k.setEmail(email);

        kList.add(k);

        if (kc.sendEmail(kList) == true) {

            return Response.ok("Basariyla gönderildi. Lütfen Emailinizi kontrol edin!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/renewPassword")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response renewSifre(@FormParam("k_adi") String k_adi, @FormParam("sifre") String sifre) throws SQLException {

        Kullanici k = new Kullanici();

        List<Kullanici> kList = new ArrayList<Kullanici>();

        k.setKullanici_adi(k_adi);
        
        k.setSifre(sifre);

        kList.add(k);

        if (kc.renewSifre(kList) == true) {

            return Response.ok("Basariyla yenilendi. Yeni şifrenizle giriş yapabilirsiniz", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

}
