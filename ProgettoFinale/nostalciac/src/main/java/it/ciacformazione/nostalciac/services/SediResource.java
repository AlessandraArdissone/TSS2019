/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.CorsoStore;
import it.ciacformazione.nostalciac.business.SedeStore;
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
 * gestisce le operazioni sull'insieme delle sedi
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

    @GET
    @Path("search")
    public List<Sede> search(
            @QueryParam("nome") String searchNome,
            @QueryParam("citta") String searchCitta) {
        return store.search(searchNome, searchCitta);
    }

    // niente @GET per accedere ad una sottorisorsa!!
    @Path("{id}")
    // es.: http://localhost:8080/nostalciac/resources/sedi/2
    public SedeResource find(@PathParam("id") int id) {
        SedeResource resource = rc.getResource(SedeResource.class);
        resource.setId(id);
        return resource;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Sede sede, @Context UriInfo uriInfo) {
        Sede saved = store.save(sede);
        URI uri = uriInfo
                .getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();
    }
}
