/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.AnagraficaStore;
import it.ciacformazione.nostalciac.business.EsperienzaStore;
import it.ciacformazione.nostalciac.entity.Anagrafica;
import it.ciacformazione.nostalciac.entity.Esperienza;
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
 * gestisce le operazioni sull'insieme delle esperienze
 *
 * @author tss
 */
@Path("/esperienze")
public class EsperienzeResource {

    private Integer anagraficaId;

    @Inject
    private EsperienzaStore store;

    @Inject
    private AnagraficaStore anagraficaStore;

    @Context
    ResourceContext rc;

    public void setAnagraficaId(Integer anagraficaId) {
        this.anagraficaId = anagraficaId;
    }

    @GET
    public List<Esperienza> findAll() {
        return store.findByAnagrafica(anagraficaId);
    }

    @GET
    @Path("search")
    public List<Esperienza> search(
            @QueryParam("nome") String searchNome,
            @QueryParam("luogo") String searchLuogo) {
        return store.search(searchNome, searchLuogo);
    }

    // niente @GET per accedere ad una sottorisorsa!!
    @Path("{id}")
    // es.: http://localhost:8080/nostalciac/resources/esperienze/2
    public EsperienzaResource find(@PathParam("id") int id) {
        EsperienzaResource resource = rc.getResource(EsperienzaResource.class);
        resource.setId(id);
        resource.setAnagraficaId(anagraficaId);
        return resource;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Esperienza esperienza, @Context UriInfo uriInfo) {
        Anagrafica anagrafica = anagraficaStore.find(anagraficaId);
        esperienza.setAnagrafica(anagrafica);
        Esperienza saved = store.save(esperienza);
        URI uri = uriInfo
                .getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();
        return Response.ok(uri).build();
    }
}
