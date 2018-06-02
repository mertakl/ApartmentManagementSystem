/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiteService;

import com.google.gson.Gson;
import dao.SiteAccess;
import dto.Site;
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
public class SiteService {

    SiteAccess sc = new SiteAccess();

    //Siteleri getir.
    @GET
    @Path("/getSite")
    @Produces("application/json")
    public Response getSite() {

        String site = null;
        List<Site> sList = new ArrayList<Site>();
        try {
            sList = new SiteAccess().getSite();
            Gson gson = new Gson();
            site = gson.toJson(sList);

        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();

        }

        return Response.ok(site).header("Access-Control-Allow-Origin", "*").build();
    }

    @POST
    @Path("/updateSite")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response updateUser(@FormParam("adi") String adi, @FormParam("adres") String adres,
            @FormParam("blok_sayi") int blok_sayi, @FormParam("daire_sayi") int daire_sayi,
            @FormParam("telefon") String telefon, @FormParam("fax") String fax,
            @FormParam("yetkili_adi") String yetkili_adi, @FormParam("yetkili_soyadi") String yetkili_soyadi) throws SQLException {

        Site site = new Site();

        List<Site> sList = new ArrayList<Site>();

        site.setAdi(adi);

        site.setAdres(adres);

        site.setBlok_sayi(blok_sayi);

        site.setDaire_sayi(daire_sayi);
        
        site.setTelefon(telefon);
        
        site.setFax(fax);
        
        site.setYetkili_adi(yetkili_adi);
        
        site.setYetkili_soyadi(yetkili_soyadi);

        sList.add(site);

        if (sc.updateSite(sList) == true) {

            return Response.ok("Basariyla Güncellendi!", MediaType.TEXT_PLAIN).build();

        } else {

            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();

        }

    }

}
