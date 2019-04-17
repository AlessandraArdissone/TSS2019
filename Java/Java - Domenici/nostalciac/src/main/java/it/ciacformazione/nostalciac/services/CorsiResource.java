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
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author tss
 */
@Path("corsi")
public class CorsiResource {

    @Inject
    private CorsoStore store;

    @Inject
    private SedeStore sedeStore;

    @Context
    ResourceContext rc;
    
    private Integer idSede;

    @GET
    public List<Corso> findAll() {
        return store.findBySede(idSede);
    }

    @Path("{id}")
    public CorsoResource find() {
        CorsoResource resource = rc.getResource(CorsoResource.class);
        resource.setIdSede(idSede);
        return resource;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Corso c, @Context UriInfo uriInfo) {
        Sede sede = sedeStore.find(idSede);
        c.setSede(sede);
        Corso saved = store.save(c);
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();
    }

    

    /*
    get e set
     */
    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

}
