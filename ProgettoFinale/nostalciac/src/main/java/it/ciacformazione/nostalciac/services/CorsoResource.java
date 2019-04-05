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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * sottorisorsa di CorsiResource
 *
 * gestisce le operazioni sul singolo corso
 *
 * @author tss
 */
public class CorsoResource {
    
    private int id;
    private Integer sedeId;
    
    @Inject
    private CorsoStore store;
    
    @Inject
    private SedeStore sedeStore;
    
    @Inject
    private TagStore tagStore;

    @Context
    ResourceContext rc;

    public void setId(int id) {
        this.id = id;
    }

    public void setSedeId(Integer sedeId) {
        this.sedeId = sedeId;
    }
    
    @GET
    public Corso find() {
        return store.find(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Corso corso) {
        corso.setId(id);
        Sede sede = sedeStore.find(sedeId);
        corso.setSede(sede);
        store.save(corso);
    }

    @DELETE
    public void delete() {
        store.remove(id);
    }
    
    @GET
    //@Path("{id}/tags")
    @Path("/tags")
    //public List<Tag> findTags(@PathParam("id") int id) {
    public List<Tag> findTags() {
        return store.findTags(id);
    }

    @PUT
    //@Path("{id}/tags")
    @Path("/tags")
    @Consumes(MediaType.APPLICATION_JSON)
    //public void updateTags(@PathParam("id") int id, List<Integer> idTags) {
    public void updateTags(List<Integer> idTags) {
        Corso finded = store.find(id);
        Set<Tag> tosave = idTags.stream()
                .map(t -> tagStore.find(t))
                .collect(Collectors.toSet());
        finded.setTags(tosave);
        store.save(finded);
    }
}
