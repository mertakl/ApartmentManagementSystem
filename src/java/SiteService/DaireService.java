/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiteService;

import com.google.gson.Gson;
import dao.DaireAccess;
import dto.Daire;
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
public class DaireService {

    DaireAccess dc = new DaireAccess();

    //Daireleri getir.
    @GET
    @Path("/getDaire")
    @Produces("application/json")
    public Response getDaire() {

        String daire = null;
        List<Daire> dList = new ArrayList<Daire>();
        try {
            dList = new DaireAccess().getDaire();
            Gson gson = new Gson();
            daire = gson.toJson(dList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(daire).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getDaireler")
    @Produces("application/json")
    public Response getDaireler() {

        String daire = null;
        List<Daire> dList = new ArrayList<Daire>();
        try {
            dList = new DaireAccess().getDaireler();
            Gson gson = new Gson();
            daire = gson.toJson(dList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(daire).header("Access-Control-Allow-Origin", "*").build();
    }

    @POST
    @Path("/insertDaire")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response insertDaire(@FormParam("daire_no") int daire_no, @FormParam("kat") int kat, @FormParam("daire_oturan_adi") String daire_oturan_adi,
            @FormParam("daire_oturan_soyadi") String daire_oturan_soyadi, @FormParam("durum") String durum, @FormParam("otopark") String otopark,
            @FormParam("apartman_no") String apartman_no, @FormParam("daire_tipi") String daire_tipi,
            @FormParam("metrekare") int metrekare, @FormParam("balkon_sayisi") int balkon_sayisi) throws SQLException {

//        System.out.println(daire_no);
//        
//        System.out.println(kat);
//        
//        System.out.println(daire_oturan_adi);
//        
//        System.out.println(daire_oturan_soyadi);
//        
//        System.out.println(durum);
//        
        //System.out.println(otopark);
//        
//        System.out.println(apartman_no);
//        
//        System.out.println(daire_tipi);
        Daire d = new Daire();

        List<Daire> dList = new ArrayList<Daire>();

        d.setDaire_no(daire_no);

        d.setKat(kat);

        d.setMetrekare(metrekare);

        d.setBalkon_sayisi(balkon_sayisi);

        d.setDaire_oturan_adi(daire_oturan_adi);

        d.setDaire_oturan_soyadi(daire_oturan_soyadi);

        d.setDurum(durum);

        d.setOtopark(otopark);

        d.setApartman_no(apartman_no);

        d.setDaire_tipi(daire_tipi);

        dList.add(d);

        if (dc.insertDaire(dList) == true) {

            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/updateDaire")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response updateDaire(@FormParam("id") int id,
            @FormParam("daire_no") int daire_no, @FormParam("kat") int kat, @FormParam("daire_oturan_adi") String daire_oturan_adi,
            @FormParam("daire_oturan_soyadi") String daire_oturan_soyadi, @FormParam("durum") String durum, @FormParam("otopark") String otopark,
            @FormParam("apartman_no") String apartman_no, @FormParam("daire_tipi") String daire_tipi,
            @FormParam("metrekare") int metrekare, @FormParam("balkon_sayisi") int balkon_sayisi) throws SQLException {

        Daire d = new Daire();

//        System.out.println(id);
//
//        System.out.println(daire_no);
//
//        System.out.println(durum);
//
//        System.out.println(otopark);
//
//        System.out.println(apartman_no);
//
//        System.out.println(daire_tipi);
        List<Daire> dList = new ArrayList<Daire>();

        d.setId(id);

        d.setDaire_no(daire_no);

        d.setKat(kat);

        d.setDaire_oturan_adi(daire_oturan_adi);

        d.setDaire_oturan_soyadi(daire_oturan_soyadi);

        d.setDurum(durum);

        d.setOtopark(otopark);

        d.setApartman_no(apartman_no);

        d.setDaire_tipi(daire_tipi);

        d.setMetrekare(metrekare);

        d.setBalkon_sayisi(balkon_sayisi);

        dList.add(d);

        if (dc.updateDaire(dList) == true) {

            return Response.ok("Basariyla Güncellendi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }
    }

    @GET
    @Path("/getOtopark")
    @Produces("application/json")
    public Response getOtopark() {

        String daire = null;
        List<Daire> dList = new ArrayList<Daire>();
        try {
            dList = new DaireAccess().getOtopark();
            Gson gson = new Gson();
            daire = gson.toJson(dList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(daire).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getTipi")
    @Produces("application/json")
    public Response getTipi() {

        String daire = null;
        List<Daire> dList = new ArrayList<Daire>();
        try {
            dList = new DaireAccess().getTipi();
            Gson gson = new Gson();
            daire = gson.toJson(dList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(daire).header("Access-Control-Allow-Origin", "*").build();
    }

}
