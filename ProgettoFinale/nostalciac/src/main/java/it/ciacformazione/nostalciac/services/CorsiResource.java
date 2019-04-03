/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.CorsoStore;
import it.ciacformazione.nostalciac.business.SedeStore;
import it.ciacformazione.nostalciac.business.TagStore;
import it.ciacformazione.nostalciac.entity.Corso;
import it.ciacformazione.nostalciac.entity.Sede;
import it.ciacformazione.nostalciac.entity.Tag;
import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
@Path("/corsi")
public class CorsiResource {

    private Integer sedeId;
    
    @Inject
    private CorsoStore store;
    
    @Inject
    private SedeStore sedeStore;
    
    @Inject
    private TagStore tagStore;

    @GET
    public List<Corso> findAll() {
        //return store.all();
        return store.findBySede(sedeId);
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
    public Response create(Corso corso, @Context UriInfo uriInfo) {
        //Sede sede = sedeStore.find(corso.getSede().getId());
        Sede sede = sedeStore.find(sedeId);
        corso.setSede(sede);
        Corso saved = store.save(corso);
        URI uri = uriInfo
                .getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build(); 
        return Response.ok(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void update(@PathParam("id") int id, Corso corso) {
        corso.setId(id);
        Sede sede = sedeStore.find(sedeId);
        corso.setSede(sede);
        store.save(corso);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id) {
        store.remove(id);
    }
    
    @GET
    @Path("{id}/tags")
    public List<Tag> findTags(@PathParam("id") int id) {
        return store.findTags(id);
    }

    @PUT
    @Path("{id}/tags")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTags(@PathParam("id") int id, List<Integer> idTags) {
        Corso finded = store.find(id);
        Set<Tag> tosave = idTags.stream()
                .map(t -> tagStore.find(t))
                .collect(Collectors.toSet());
        finded.setTags(tosave);
        store.save(finded);
    }

    public void setSedeId(Integer sedeId) {
        this.sedeId = sedeId;
    }
}
