/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.CorsoStore;
import it.ciacformazione.nostalciac.entity.Corso;
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
@Path("corsi")
public class CorsiResource {
    
    @Inject
    CorsoStore store;
    
    @GET
    public List<Corso> findAll() {
        return store.all();
    }
    
    @GET
    @Path("search")
    public List<Corso> search(
            @QueryParam("nome") String searchNome) {
        return store.search(searchNome);
    }
    
    @GET
    // es.: http://localhost:8080/nostalciac/resources/corsi/2
    @Path("{id}")
    public Corso find(@PathParam("id") int id) {
        return store.find(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Corso corso) {
        store.save(corso);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void update(@PathParam("id")int id, Corso corso) {
        corso.setId(id);
        store.save(corso);
    }
    
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") int id) {
        store.remove(id);
    }
}
