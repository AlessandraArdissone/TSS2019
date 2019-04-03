/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.AnagraficaStore;
import it.ciacformazione.nostalciac.entity.Anagrafica;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author tss
 */
@Path("/anagrafiche")
public class AnagraficheResource {
    
    @Inject
    AnagraficaStore store;

    @GET
    public List<Anagrafica> findAll() {
        return store.all();
    }

    @GET
    @Path("search")
    public List<Anagrafica> search(
            @QueryParam("nome") String searchNome,
            @QueryParam("cognome") String searchCognome) {
        return store.search(searchNome, searchCognome);
    }

    @GET
    // es.: http://localhost:8080/nostalciac/resources/anagrafiche/2
    @Path("{id}")
    public Anagrafica find(@PathParam("id") int id) {
        return store.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Anagrafica anagrafica, @Context UriInfo uriInfo) {
        Anagrafica saved = store.save(anagrafica);
        URI uri = uriInfo
                .getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build(); 
        return Response.ok(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void update(@PathParam("id")int id, Anagrafica anagrafica) {
        anagrafica.setId(id);
        store.save(anagrafica);
    }

    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") int id) {
        store.remove(id);
    }
}
