/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiteService;

import com.google.gson.Gson;
import dao.PersonelAccess;
import dto.Personel;
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
public class PersonelService {

    PersonelAccess pc = new PersonelAccess();

    //Apartmanları getir.
    @GET
    @Path("/getPersonel")
    @Produces("application/json")
    public Response getPersonel() {

        String personel = null;
        List<Personel> pList = new ArrayList<Personel>();
        try {
            pList = new PersonelAccess().getPersonel();
            Gson gson = new Gson();
            personel = gson.toJson(pList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(personel).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/getPersonelById/{aptno}")
    @Produces("application/json")
    public Response getPersonelById(@PathParam("aptno") String aptno) {


        String personel = null;
        List<Personel> pList = new ArrayList<Personel>();
        try {
            pList = new PersonelAccess().getPersonelById(aptno);
            Gson gson = new Gson();
            personel = gson.toJson(pList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(personel).header("Access-Control-Allow-Origin", "*").build();
    }

    // Apartman ekleme
    @POST
    @Path("/insertPersonel")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response createPersonel(@FormParam("adi") String adi,
            @FormParam("soyadi") String soyadi, @FormParam("telefon") String telefon,
            @FormParam("adres") String adres, @FormParam("dogum_tarih") String dogum_tarih,
            @FormParam("tc_no") String tc_no, @FormParam("brut_maas") int brut_maas,
            @FormParam("durum") String durum, @FormParam("apartman_no") String apartman_no) throws SQLException {

//        System.out.println(durum);
//
//        System.out.println(apartman_no);
        Personel prs = new Personel();

        List<Personel> pList = new ArrayList<Personel>();

        prs.setAdi(adi);

        prs.setSoyadi(soyadi);

        prs.setTelefon(telefon);

        prs.setAdres(adres);

        prs.setDogum_tarih(dogum_tarih);

        prs.setTc_no(tc_no);

        prs.setBrut_maas(brut_maas);

        prs.setDurum(durum);

        prs.setApartman_no(apartman_no);

        pList.add(prs);

        if (pc.savePersonel(pList) == true) {

            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }
    }

    @POST
    @Path("/updatePersonel")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response updatePersonel(
            @FormParam("id") int id, @FormParam("adi") String adi,
            @FormParam("soyadi") String soyadi, @FormParam("telefon") String telefon,
            @FormParam("adres") String adres, @FormParam("dogum_tarih") String dogum_tarih,
            @FormParam("tc_no") String tc_no, @FormParam("brut_maas") int brut_maas,
            @FormParam("durum") String durum, @FormParam("apartman_no") String apartman_no) throws SQLException {


        Personel prs = new Personel();

        List<Personel> pList = new ArrayList<Personel>();

        prs.setId(id);

        prs.setAdi(adi);

        prs.setSoyadi(soyadi);

        prs.setTelefon(telefon);

        prs.setAdres(adres);

        prs.setDogum_tarih(dogum_tarih);

        prs.setTc_no(tc_no);

        prs.setBrut_maas(brut_maas);

        prs.setDurum(durum);

        prs.setApartman_no(apartman_no);

        pList.add(prs);

        if (pc.updatePersonel(pList) == true) {

            return Response.ok("Basariyla Güncellendi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }
    }

    @POST
    @Path("/deletePersonel")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response deleteUser(@FormParam("id") int id) throws SQLException {

        Personel p = new Personel();

        List<Personel> aptList = new ArrayList<Personel>();

        p.setId(id);

        aptList.add(p);

        if (pc.deleteApartman(aptList) == true) {

            return Response.ok("Basariyla Silindi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

}
