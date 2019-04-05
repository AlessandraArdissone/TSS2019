/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.AnagraficaStore;
import it.ciacformazione.nostalciac.business.CorsoStore;
import it.ciacformazione.nostalciac.business.EsperienzaStore;
import it.ciacformazione.nostalciac.entity.Anagrafica;
import it.ciacformazione.nostalciac.entity.Corso;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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
 * sottorisorsa di AnagraficheResource
 *
 * gestisce le operazioni sulla singola anagrafica
 *
 * @author tss
 */
public class AnagraficaResource {
    
    private Integer id;
    
    @Inject
    private AnagraficaStore store;

    @Inject
    private CorsoStore corsoStore;
    
    @Inject
    private EsperienzaStore esperienzaStore;

    @Context
    ResourceContext rc;

    public void setId(Integer id) {
        this.id = id;
    }
    
    @GET
    public Anagrafica find() {
        return store.find(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Anagrafica anagrafica) {
        anagrafica.setId(id);
        store.save(anagrafica);
    }

    @DELETE
    public void delete () {
        store.remove(id);
    }

    @GET
    @Path("/corsi")
    public List<Corso> findCorsi() {
        return store.findCorsi(id);
    }

    @PUT
    @Path("/corsi")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCorsi(List<Integer> idCorsi) {
        Anagrafica finded = store.find(id);
        Set<Corso> tosave = idCorsi.stream()
                .map(t -> corsoStore.find(t))
                .collect(Collectors.toSet());
        finded.setCorsi(tosave);
        store.save(finded);
    }

    @Path("/esperienze")
    public EsperienzeResource getEsperienze() {
        EsperienzeResource resource = rc.getResource(EsperienzeResource.class);
        resource.setAnagraficaId(id);
        return resource;
    }
}
