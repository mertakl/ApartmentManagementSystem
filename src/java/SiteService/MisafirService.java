/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiteService;

import com.google.gson.Gson;
import dao.ApartmanAccess;
import dao.HaneAccess;
import dao.MisafirAccess;
import dto.Apartman;
import dto.Daire;
import dto.Hane;
import dto.Misafir;
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
public class MisafirService {

    MisafirAccess mc = new MisafirAccess();

    //Apartmanları getir.
    @GET
    @Path("/getMisafir")
    @Produces("application/json")
    public Response getOturan() {

        String misafir = null;
        List<Misafir> mList = new ArrayList<Misafir>();
        try {
            mList = new MisafirAccess().getMisafir();
            Gson gson = new Gson();
            misafir = gson.toJson(mList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(misafir).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getBlok")
    @Produces("application/json")
    public Response getBlok() {

        String blok = null;
        List<Apartman> bList = new ArrayList<Apartman>();
        try {
            bList = new MisafirAccess().getBlok();
            Gson gson = new Gson();
            blok = gson.toJson(bList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(blok).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getDaire/{input}")
    @Produces("application/json")
    public Response getDaire(@PathParam("input") int apartman_id) {

        String daire = null;
        List<Daire> dList = new ArrayList<Daire>();
        try {
            dList = new MisafirAccess().getDaire(apartman_id);
            Gson gson = new Gson();
            daire = gson.toJson(dList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(daire).header("Access-Control-Allow-Origin", "*").build();

    }

    // Misafir ekleme
    @POST
    @Path("/insertMisafir")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response createOturan(@FormParam("adi") String adi,
            @FormParam("soyadi") String soyadi,
            @FormParam("daire_no") int daire_no, @FormParam("apartman_no") String apartman_no,
            @FormParam("telefon") String telefon,
            @FormParam("plaka") String plaka) throws SQLException {

        Misafir m = new Misafir();

        List<Misafir> mList = new ArrayList<Misafir>();

        m.setAdi(adi);

        m.setSoyadi(soyadi);

        m.setDaire_no(daire_no);

        m.setPlaka(plaka);
        
        m.setTelefon(telefon);

        mList.add(m);

        if (mc.saveMisafir(mList) == true) {

            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

//    @POST
//    @Path("/updateMisafir")
//    @Consumes("application/x-www-form-urlencoded")
//    @Produces("application/json")
//    public Response updateOturan(@FormParam("id") int id, @FormParam("adi") String adi,
//            @FormParam("soyadi") String soyadi, @FormParam("etar") String etar,
//            @FormParam("daire_no") int daire_no, @FormParam("apartman_no") String apartman_no) throws SQLException {
//
//        Misafir m = new Misafir();
//
//        List<Misafir> mList = new ArrayList<Misafir>();
//
//        m.setId(id);
//
//        m.setAdi(adi);
//
//        m.setSoyadi(soyadi);
//
//        m.setEtar(etar);
//
//        m.setDaire_no(daire_no);
//
//        m.setApartman_no(apartman_no);
//
//        mList.add(m);
//
//        if (mc.updateMisafir(mList) == true) {
//
//            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();
//
//        } else {
//
//            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();
//
//        }
//
//    }
    
    @POST
    @Path("/deleteMisafir")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response deleteMisafir(@FormParam("id") int id) throws SQLException {

        Misafir m = new Misafir();

        List<Misafir> mList = new ArrayList<Misafir>();

        m.setId(id);

        mList.add(m);

        if (mc.deleteMisafir(mList) == true) {

            return Response.ok("Basariyla Silindi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }
    
    @POST
    @Path("/exitMisafir")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response exitMisafir(@FormParam("id") int id) throws SQLException {

        Misafir m = new Misafir();

        List<Misafir> mList = new ArrayList<Misafir>();

        m.setId(id);

        mList.add(m);

        if (mc.exitMisafir(mList) == true) {

            return Response.ok("Basariyla Çıkış Yapıldı!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }
     
}
