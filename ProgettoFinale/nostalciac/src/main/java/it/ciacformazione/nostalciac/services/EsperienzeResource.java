/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.AnagraficaStore;
import it.ciacformazione.nostalciac.business.EsperienzaStore;
import it.ciacformazione.nostalciac.business.TagStore;
import it.ciacformazione.nostalciac.entity.Anagrafica;
import it.ciacformazione.nostalciac.entity.Esperienza;
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
@Path("/esperienze")
public class EsperienzeResource {

    private Integer anagraficaId;

    @Inject
    private EsperienzaStore store;

    @Inject
    private AnagraficaStore anagraficaStore;

    @Inject
    private TagStore tagStore;

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
    
    @GET
    // es.: http://localhost:8080/nostalciac/resources/esperienze/2
    @Path("{id}")
    public Esperienza find(@PathParam("id") int id) {
        return store.find(id);
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
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void update(@PathParam("id") int id, Esperienza esperienza) {
        esperienza.setId(id);
        Anagrafica anagrafica = anagraficaStore.find(anagraficaId);
        esperienza.setAnagrafica(anagrafica);
        store.save(esperienza);
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
        Esperienza finded = store.find(id);
        Set<Tag> tosave = idTags.stream()
                .map(t -> tagStore.find(t))
                .collect(Collectors.toSet());
        finded.setTags(tosave);
        store.save(finded);
    }
}
