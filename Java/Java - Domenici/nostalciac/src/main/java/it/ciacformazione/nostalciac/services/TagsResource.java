/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.TagStore;
import it.ciacformazione.nostalciac.entity.Tag;
import java.net.URI;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.json.JsonObject;
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
@Path("/tags")
public class TagsResource {

    @Inject
    TagStore store;

    @GET
    public Map<String,Object> search(
            @QueryParam("tag") String searchTag,
            @QueryParam("tipo") String searchTipo,
            @QueryParam("start") Integer start,
            @QueryParam("page") Integer page,
            @Context UriInfo uriInfo) {
        Map<String, Object> result = store.
                searchToJson(searchTag, searchTipo, start, page);
        result.put("url", uriInfo.getAbsolutePath().toString());
        List<Tag> tags = (List)result.get("data");
        tags.forEach(v -> v.setUrl(uriInfo.getAbsolutePathBuilder()
                .path("/" + v.getId()).build().toString()));
        return result;
    }

    @GET
    @Path("{id}")
    public Tag find(@PathParam("id") int id) {
        return store.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Tag tag, @Context UriInfo uriInfo) {
        Tag saved = store.save(tag);
        URI uri = uriInfo
                .getAbsolutePathBuilder()
                .path("/" + saved.getId())
                .build();       
        return Response.ok(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void update(@PathParam("id") int id, Tag tag) {
        tag.setId(id);
        store.save(tag);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id) {
        store.remove(id);
    }
}
