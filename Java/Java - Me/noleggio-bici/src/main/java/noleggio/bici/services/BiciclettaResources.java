/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.bici.services;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import noleggio.bici.business.BiciclettaStore;
import noleggio.bici.entity.Bicicletta;

/**
 *
 * @author tss
 */
@Path("biciclette")
public class BiciclettaResources {

    @Inject // per ottenere l'istanza da Payara,
            // non funziona (dà null) se manca il file beans.xml
    BiciclettaStore store;
    
    // posso ritornare un oggetto json,
    // oppure una lista di oggetti che Payara convertirà in automatico:
    @GET
    public List<Bicicletta> findAll() {
        return store.all();
    }
}
