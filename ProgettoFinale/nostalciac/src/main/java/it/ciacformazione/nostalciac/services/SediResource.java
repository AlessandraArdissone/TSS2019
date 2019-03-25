/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.SedeStore;
import it.ciacformazione.nostalciac.entity.Sede;
import it.ciacformazione.nostalciac.entity.Tag;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("sedi")
public class SediResource {
    @Inject
    SedeStore store;

    @GET
    public List<Sede> findAll() {
        return store.all();
    }
    
    @GET
    @Path("search")
    public List<Sede> search(
            @QueryParam("nome") String searchNome,
            @QueryParam("citta") String searchCitta) {
        return store.search(searchNome, searchCitta);
    }
    
    @GET
    // es.: http://localhost:8080/nostalciac/resources/sedi/2
    @Path("{id}")
    public Sede find(@PathParam("id") int id) {
        return store.find(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Sede sede) {
        store.save(sede);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void update(@PathParam("id")int id, Sede sede) {
        sede.setId(id);
        store.save(sede);
    }
    
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") int id) {
        store.remove(id);
    }
}
