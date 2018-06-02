/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiteService;

import com.google.gson.Gson;
import dao.ApartmanAccess;
import dao.HaneAccess;
import dto.Apartman;
import dto.Hane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author makel
 */
@Path("/service")
public class HaneService {

    HaneAccess hc = new HaneAccess();

    //Apartmanları getir.
    @GET
    @Path("/getHane")
    @Produces("application/json")
    public Response getOturan() {

        String hane_halkı = null;
        List<Hane> hList = new ArrayList<Hane>();
        try {
            hList = new HaneAccess().getOturan();
            Gson gson = new Gson();
            hane_halkı = gson.toJson(hList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(hane_halkı).header("Access-Control-Allow-Origin", "*").build();
    }
    
    @GET
    @Path("/getHaneApartman/{dno}/{ano}")
    @Produces("application/json")
    public Response getHaneApartman(@PathParam("dno") String daire_no, @PathParam("ano") String apartman_no ) {   
        
//        System.err.println(daire_no);
//        
//        System.out.println(apartman_no);

        String hane_halkı = null;
        List<Hane> hList = new ArrayList<Hane>();
        try {
            hList = new HaneAccess().getHaneApartman(daire_no, apartman_no);
            Gson gson = new Gson();
            hane_halkı = gson.toJson(hList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(hane_halkı).header("Access-Control-Allow-Origin", "*").build();
    }
    
    @GET
    @Path("/getDaireApartman")
    @Produces("application/json")
    public Response getDaireApartman() {

        String daireler = null;
        List<Hane> dList = new ArrayList<Hane>();
        try {
            dList = new HaneAccess().getDaireApartman();
            Gson gson = new Gson();
            daireler = gson.toJson(dList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(daireler).header("Access-Control-Allow-Origin", "*").build();
    }

//    @GET
//    @Path("/getAdSoyad")
//    @Produces("application/json")
//    public Response getAdSoyad() {
//
//        String kisiler = null;
//        List<Hane> hList = new ArrayList<Hane>();
//        try {
//            hList = new HaneAccess().getKisiler();
//            Gson gson = new Gson();
//            kisiler = gson.toJson(hList);
//
//        } catch (Exception e) {
//
//            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
//
//        }
//
//        return Response.ok(kisiler).header("Access-Control-Allow-Origin", "*").build();
//    }

    // Oturan ekleme
    @POST
    @Path("/insertOturan")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response createOturan(@FormParam("adi") String adi,
            @FormParam("soyadi") String soyadi, @FormParam("dob") String dob,
            @FormParam("tc_no") String tc_no, @FormParam("durum") String durum,
            @FormParam("cinsiyet") String cinsiyet,@FormParam("apt_daire") int daire_id,
            @FormParam("telefon") String telefon,@FormParam("email") String email,
            @FormParam("kan_grubu") String kan_grubu) throws SQLException {
 
        Hane hane = new Hane();

        List<Hane> hList = new ArrayList<Hane>();

        hane.setAdi(adi);

        hane.setSoyadi(soyadi);

        hane.setDob(dob);

        hane.setTc_no(tc_no);

        hane.setDurum(durum);

        hane.setCinsiyet(cinsiyet);
        
        hane.setDaire_id(daire_id);

//        hane.setDaire_no(daire_no);
//        
//        hane.setApartman_no(apartman_no);

        hane.setTelefon(telefon);
        
        hane.setEmail(email);
        
        hane.setKan_grubu(kan_grubu);

        hList.add(hane);

        if (hc.saveOturan(hList) == true) {

            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/updateOturan")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response updateOturan(@FormParam("id") int id, @FormParam("adi") String adi,
            @FormParam("soyadi") String soyadi, @FormParam("dob") String dob,
            @FormParam("tc_no") String tc_no, @FormParam("durum") String durum,
            @FormParam("cinsiyet") String cinsiyet, @FormParam("apt_daire") int daire_id, 
            @FormParam("telefon") String telefon,@FormParam("email") String email,
            @FormParam("kan_grubu") String kan_grubu) throws SQLException {


//        System.out.println(id);
//        
//        System.out.println(adi);
//        
//        System.out.println(soyadi);
//        
//        System.out.println(dob);
//        
//        System.out.println(tc_no);
//        
//        System.out.println(durum);
//        
//        System.out.println(cinsiyet);
//        
//        System.out.println(daire_id);
//        
//        System.out.println(telefon);
//        
//        System.out.println(email);
//        
//        System.out.println(kan_grubu);
        

        Hane hane = new Hane();

        List<Hane> hList = new ArrayList<Hane>();

        hane.setId(id);

        hane.setAdi(adi);

        hane.setSoyadi(soyadi);

        hane.setDob(dob);

        hane.setTc_no(tc_no);

        hane.setDurum(durum);

        hane.setCinsiyet(cinsiyet);
        
        hane.setDaire_id(daire_id);
        
        hane.setTelefon(telefon);
        
        hane.setEmail(email);
        
        hane.setKan_grubu(kan_grubu);

        hList.add(hane);

        if (hc.updateOturan(hList) == true) {

            return Response.ok("Basariyla Güncellendi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/deleteOturan")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response deleteOturan(@FormParam("id") int id) throws SQLException {

        Hane h = new Hane();

        List<Hane> hList = new ArrayList<Hane>();

        h.setId(id);

        hList.add(h);

        if (hc.deleteOturan(hList) == true) {

            return Response.ok("Basariyla Silindi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

}
