/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.services;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import noleggio.business.BiciclettaStore;
import noleggio.entity.Bicicletta;

/**
 *
 * @author tss
 */
@Path("biciclette")
public class BiciclettaResources {
    
    @Inject
    BiciclettaStore store;
    
    @GET
    public List<Bicicletta> findAll(){
        return store.all();
    }
}
