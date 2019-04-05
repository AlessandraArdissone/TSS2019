/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.CorsoStore;
import it.ciacformazione.nostalciac.business.SedeStore;
import it.ciacformazione.nostalciac.entity.Sede;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * sottorisorsa di SediResource
 *
 * gestisce le operazioni sulla singola sede
 *
 * @author tss
 */
public class SedeResource {

    private Integer id;
    
    @Inject
    private SedeStore store;
    
    @Inject
    private CorsoStore corsoStore;

    @Context
    ResourceContext rc;
    
    @GET
    public Sede find() {
        return store.find(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Sede sede) {
        sede.setId(id);
        store.save(sede);
    }

    @DELETE
    public void delete() {
        store.remove(id);
    }

    @Path("/corsi")
    public CorsiResource getCorsi() {
        CorsiResource resource = rc.getResource(CorsiResource.class);
        resource.setSedeId(id);
        return resource;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
