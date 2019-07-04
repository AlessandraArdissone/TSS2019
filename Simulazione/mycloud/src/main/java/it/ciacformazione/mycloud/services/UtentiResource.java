/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.mycloud.services;

import com.sun.jndi.toolkit.url.Uri;
import it.ciacformazione.mycloud.business.UtenteStore;
import it.ciacformazione.mycloud.entity.Utente;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author tss
 */
@Path("/utenti")
public class UtentiResource {
    
    @Inject UtenteStore usrStore;
    
    @GET
    public List<Utente> findAll() {
        return usrStore.all();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Utente utente, @Context UriInfo uriInfo) {
        Utente saved = usrStore.save(utente);
        URI uri = uriInfo
                .getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();
    }
}
