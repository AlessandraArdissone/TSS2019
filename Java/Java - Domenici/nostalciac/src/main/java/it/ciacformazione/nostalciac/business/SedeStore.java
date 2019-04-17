/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.business;

import it.ciacformazione.nostalciac.entity.Sede;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class SedeStore {
    
    @PersistenceContext
    EntityManager em;
    
    
    public List<Sede> all(){
        return em.createQuery("select e FROM Sede e ORDER BY e.nome",Sede.class)
                .getResultList();
    }
    
    public Sede find(int id){
        return em.find(Sede.class, id);
    }
    
    public Sede save(Sede s){
        return em.merge(s);
    }
    
    public void remove(int id){
        em.remove(find(id));
    }
}
