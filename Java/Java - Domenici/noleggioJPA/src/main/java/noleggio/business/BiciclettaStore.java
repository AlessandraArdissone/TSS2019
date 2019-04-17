/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import noleggio.entity.Bicicletta;

/**
 *
 * @author tss
 */
@Stateless
public class BiciclettaStore {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Bicicletta> all(){
       return em.createQuery("select e from Bicicletta e order by e.marca", Bicicletta.class)
               .getResultList();
    }
}
