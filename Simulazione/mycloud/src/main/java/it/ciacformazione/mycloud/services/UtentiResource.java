/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.mycloud.services;

import it.ciacformazione.mycloud.business.UtenteStore;
import it.ciacformazione.mycloud.entity.Utente;
import java.net.URI;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author tss
 */
@DenyAll
@RequestScoped
@Path("/utenti")
public class UtentiResource {

    @Inject
    UtenteStore usrStore;

    @Context
    ResourceContext rc;
    
    @Inject
    JsonWebToken callerPrincipal;
    
    @PostConstruct
    public void init(){
        System.out.println("caller principal: " + callerPrincipal.getClaim(Claims.upn.name()) + " groups: " + callerPrincipal.getGroups());
    }
    
    @GET
    @RolesAllowed({"users"})
    public List<Utente> findAll() {
        return usrStore.all();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response create(Utente utente, @Context UriInfo uriInfo) {
        Utente saved = usrStore.save(utente);
        URI uri = uriInfo
                .getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();
    }
    
    @GET
    @Path("{id}")
    @RolesAllowed({"users"})
    public Utente find(@PathParam("id") int id) {
        return usrStore.find(id);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"users"})
    public void update(@PathParam("id") int id, Utente utente) {
        utente.setId(id);
        usrStore.save(utente);
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed({"users"})
    public void delete(@PathParam("id") int id) {
        usrStore.remove(id);
    }
}
