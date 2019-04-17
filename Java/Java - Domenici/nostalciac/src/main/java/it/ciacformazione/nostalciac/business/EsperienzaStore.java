/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.business;

import it.ciacformazione.nostalciac.entity.Esperienza;
import it.ciacformazione.nostalciac.entity.Esperienza;
import it.ciacformazione.nostalciac.entity.Tag;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class EsperienzaStore {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Esperienza> findAll(){
        return em.createQuery("select e from Esperienza e order by e.nome", Esperienza.class)
                .getResultList();
    }
    
    public List<Esperienza> findByAnagrafica(Integer id ){
        return em.createQuery("select e from Esperienza e "
                + "where e.anagrafica.id= :id_anagrafica "
                + "order by e.nome", Esperienza.class)
                .setParameter("id_anagrafica", id)
                .getResultList();
    }
    
    public Esperienza find(Integer id){
        return em.find(Esperienza.class, id);
    }
    
    public Esperienza save(Esperienza a){
        return em.merge(a);
    }
    
    public void remove(Integer id){
        em.remove(find(id));
    }
    
    public List<Tag> findTags(Integer id) {
        return em.createQuery(
                "select e.tags from Esperienza e where e.id= :id",Tag.class)
                .setParameter("id", id)
                .getResultList();
    }
    
}
