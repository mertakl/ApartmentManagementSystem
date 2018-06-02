/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiteService;

import com.google.gson.Gson;
import dao.ApartmanAccess;
import dao.PersonelAccess;
import dto.Apartman;
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
public class ApartmanService {

    ApartmanAccess ac = new ApartmanAccess();

    //Apartmanları getir.
    @GET
    @Path("/getApartman")
    @Produces("application/json")
    public Response getUser() {

        String apartman = null;
        List<Apartman> aList = new ArrayList<Apartman>();
        try {
            aList = new ApartmanAccess().getApartman();
            Gson gson = new Gson();
            apartman = gson.toJson(aList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(apartman).header("Access-Control-Allow-Origin", "*").build();
    }
    
//    @GET
//    @Path("/getPrs")
//    @Produces("application/json")
//    public Response getPrs() {
//
//        String personel = null;
//        List<Personel> pList = new ArrayList<Personel>();
//        try {
//            pList = new PersonelAccess().getPersonelById();
//            Gson gson = new Gson();
//            personel = gson.toJson(pList);
//
//        } catch (Exception e) {
//
//            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
//
//        }
//
//        return Response.ok(personel).header("Access-Control-Allow-Origin", "*").build();
//    }

    // Apartman ekleme
    @POST
    @Path("/insertApartman")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response createUser(@FormParam("apartman_no") String apartman_no,
            @FormParam("daire_sayisi") int daire_sayisi, @FormParam("kat_sayisi") int kat_sayisi,
            @FormParam("asansör_sayisi") int asansör_sayisi) throws SQLException {

        Apartman apt = new Apartman();

        List<Apartman> aList = new ArrayList<Apartman>();

        apt.setApartman_no(apartman_no);

        apt.setDaire_sayisi(daire_sayisi);

        apt.setKat_sayisi(kat_sayisi);

        apt.setAsansör_sayisi(asansör_sayisi);

        aList.add(apt);

        if (ac.saveApartman(aList) == true) {

            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/updateApartman")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response updateUser(@FormParam("id") int id, @FormParam("apartman_no") String apartman_no,
            @FormParam("daire_sayisi") int daire_sayisi, @FormParam("kat_sayisi") int kat_sayisi,
            @FormParam("asansör_sayisi") int asansör_sayisi) throws SQLException {

        Apartman apt = new Apartman();

        List<Apartman> aList = new ArrayList<Apartman>();

        apt.setId(id);

        apt.setApartman_no(apartman_no);

        apt.setDaire_sayisi(daire_sayisi);

        apt.setKat_sayisi(kat_sayisi);

        apt.setAsansör_sayisi(asansör_sayisi);

        aList.add(apt);

        if (ac.updateApartman(aList) == true) {

            return Response.ok("Basariyla Güncellendi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/deleteApartman")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response deleteUser(@FormParam("id") int id) throws SQLException {

        Apartman apt = new Apartman();

        List<Apartman> aptList = new ArrayList<Apartman>();

        apt.setId(id);

        aptList.add(apt);

        if (ac.deleteApartman(aptList) == true) {

            return Response.ok("Basariyla Silindi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

}
