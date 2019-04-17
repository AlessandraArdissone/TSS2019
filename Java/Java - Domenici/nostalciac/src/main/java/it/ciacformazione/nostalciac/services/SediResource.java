/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.CorsoStore;
import it.ciacformazione.nostalciac.business.SedeStore;
import it.ciacformazione.nostalciac.business.TagStore;
import it.ciacformazione.nostalciac.entity.Sede;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Path("/sedi")
public class SediResource {

    @Inject
    SedeStore store;

    @Context
    ResourceContext rc;
    
    @GET
    public List<Sede> findAll() {
        return store.all();
    }

    @Path("{id}")
    public SedeResource find() {
        return rc.getResource(SedeResource.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Sede s, @Context UriInfo uriInfo) {
        Sede saved = store.save(s);
        URI uri = uriInfo.getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();
    }

    /*
    get e set
    */

    public ResourceContext getRc() {
        return rc;
    }

    public void setRc(ResourceContext rc) {
        this.rc = rc;
    }
    
    
}
