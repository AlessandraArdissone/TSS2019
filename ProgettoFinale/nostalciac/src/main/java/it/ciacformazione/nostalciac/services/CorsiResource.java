/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.CorsoStore;
import it.ciacformazione.nostalciac.business.SedeStore;
import it.ciacformazione.nostalciac.entity.Corso;
import it.ciacformazione.nostalciac.entity.Sede;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * gestisce le operazioni sull'insieme dei corsi
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

    @Context
    ResourceContext rc;

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

    // niente @GET per accedere ad una sottorisorsa!!
    @Path("{id}")
    // es.: http://localhost:8080/nostalciac/resources/corsi/2
    public CorsoResource find(@PathParam("id") int id) {
        CorsoResource resource = rc.getResource(CorsoResource.class);
        resource.setId(id);
        resource.setSedeId(sedeId);
        return resource;
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

    public void setSedeId(Integer sedeId) {
        this.sedeId = sedeId;
    }
}
