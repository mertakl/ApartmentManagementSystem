/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiteService;

import com.google.gson.Gson;
import dao.TesisAccess;
import dto.Tesis;
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
public class TesisService {

    TesisAccess tc = new TesisAccess();

    //Apartmanları getir.
    @GET
    @Path("/getTesis")
    @Produces("application/json")
    public Response getTesis() {

        String tesis = null;
        List<Tesis> tList = new ArrayList<Tesis>();
        try {
            tList = new TesisAccess().getTesis();
            Gson gson = new Gson();
            tesis = gson.toJson(tList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(tesis).header("Access-Control-Allow-Origin", "*").build();
    }

    // Tesis ekleme
    @POST
    @Path("/insertTesis")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response createTesis(@FormParam("ad_soyad") int uye_id,
            @FormParam("daire_id") int daire_id, @FormParam("uyelik_ucret") int uyelik_ucret,
            @FormParam("durum") String durum) throws SQLException {

//          System.out.println(uye_id);
//        
//        System.out.println(daire_no);
//        
//        System.out.println(uyelik_ucret);
//        
//        System.out.println(durum);
        Tesis t = new Tesis();

        List<Tesis> tList = new ArrayList<Tesis>();

        t.setUye_id(uye_id);

        t.setDaire_no(daire_id);

        t.setUyelik_ucret(uyelik_ucret);

        t.setDurum(durum);

        tList.add(t);

        if (tc.saveTesis(tList) == true) {

            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/updateTesis")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response updateTesis(@FormParam("id") int id, @FormParam("ad_soyad") int uye_id,
            @FormParam("apartman_no") String apartman_no, @FormParam("daire_no") int daire_no, @FormParam("uyelik_ucret") int uyelik_ucret,
            @FormParam("durum") String durum) throws SQLException {

//        System.out.println(id);
//        
//        System.out.println(uye_id);
//        
//        System.out.println(apartman_no);
//        
//        System.out.println(daire_no);
//        
//        System.out.println(uyelik_ucret);
//        
//        System.out.println(durum);
//        if(Integer.parseInt(apartman_no) == 1){
//            apartman_no = "A BLOK";
//        }else if(Integer.parseInt(apartman_no) == 2){
//            apartman_no = "B BLOK";
//        }else if(Integer.parseInt(apartman_no) == 3){
//            apartman_no = "C BLOK";
//        }else if(Integer.parseInt(apartman_no) == 4){
//            apartman_no = "D BLOK";
//        }else if(Integer.parseInt(apartman_no) == 5){
//            apartman_no = "E BLOK";
//        }else if(Integer.parseInt(apartman_no) == 6){
//            apartman_no = "F BLOK";
//        }else if(Integer.parseInt(apartman_no) == 7){
//            apartman_no = "G BLOK";
//        }else if(Integer.parseInt(apartman_no) == 8){
//            apartman_no = "H BLOK";
//        }else if(Integer.parseInt(apartman_no) == 15){
//            apartman_no = "L BLOK";
//        }else if(Integer.parseInt(apartman_no) == 13){
//            apartman_no = "J BLOK";
//        }
        Tesis t = new Tesis();

        List<Tesis> tList = new ArrayList<Tesis>();

        t.setId(id);

        t.setUye_id(uye_id);

        t.setApartman_no(apartman_no);

        t.setDaire_no(daire_no);

        t.setUyelik_ucret(uyelik_ucret);

        t.setDurum(durum);

        tList.add(t);

        if (tc.updateTesis(tList) == true) {

            return Response.ok("Basariyla Güncellendi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

    @POST
    @Path("/deleteTesis")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response deleteUser(@FormParam("id") int id) throws SQLException {

        Tesis t = new Tesis();

        List<Tesis> tList = new ArrayList<Tesis>();

        t.setId(id);

        tList.add(t);

        if (tc.deleteTesis(tList) == true) {

            return Response.ok("Basariyla Silindi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

}
