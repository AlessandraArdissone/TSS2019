/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.SedeStore;
import it.ciacformazione.nostalciac.entity.Sede;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * sottorisorsa di Sedistore
 *
 * gestisce le operazioni sulla singola sede
 *
 * @author tss
 */
public class SedeResource {

    private final int id;
    private final SedeStore store;

    public SedeResource(int id, SedeStore store) {
        this.id = id;
        this.store = store;
    }

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
}
