/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.mycloud.services;

import it.ciacformazione.mycloud.business.DocumentoStore;
import it.ciacformazione.mycloud.entity.Documento;
import java.io.InputStream;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author tss
 */
@RolesAllowed({"users"})
@Path("/documenti")
public class DocumentiResource {

    @Inject
    DocumentoStore docStore;

    @GET
    public List<Documento> findAll() {
        return docStore.all();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream is,
            @FormDataParam("file") FormDataContentDisposition cdh,
            @FormDataParam("descrizione") String descrizione) {
        Documento doc = new Documento();
        doc.setDescrizione(descrizione);
        doc.setFile(cdh.getFileName());
        docStore.save(doc, is);
        return Response.status(200).build();
    }
}
