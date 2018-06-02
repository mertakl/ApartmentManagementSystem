/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SiteService;

import dao.LoginAccess;
import dto.Login;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 *
 * @author makel
 */
@Path("/service")
public class LoginService {
    
    //Kullanıcı login yapma

    @POST
    @Path("/login")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response login(@FormParam("uName") String kullanici, @FormParam("uPass") String sifre,
            @Context HttpServletRequest request) throws URISyntaxException {
        

        Login login = new Login();

        login.setKullanici(kullanici);

        login.setSifre(sifre);

        login = LoginAccess.kullaniciOnayla(login);

        if (login.isGecerli() == true) {

            HttpSession session = request.getSession();

            session.setAttribute("name", login.getKullanici());

        } else {

            return Response.status(Response.Status.NOT_FOUND).entity("Kullanici adi veya sifre hatali!").build();

        }
        
        return null;

    }

}
