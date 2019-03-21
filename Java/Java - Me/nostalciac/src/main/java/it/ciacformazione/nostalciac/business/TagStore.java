/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.business;

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
public class TagStore {

    @PersistenceContext()
    EntityManager em;

    /**
     * Restituisce tutti i Tag da DB
     * 
     * @return tutti i Tag
     */
    public List<Tag> all() {
        return em.createQuery("SELECT e FROM Tag e ORDER BY e.tag", Tag.class)
                .getResultList();
    }
    
    /**
     * Insert o Update su DB
     * @param tag
     * @return 
     */
    public Tag save(Tag tag) {
/*
        em.persist(tag);
        em.refresh(tag);
        return tag;
*/
        return em.merge(tag);
    }
    
    /**
     * Restituisce il Tag con id
     * 
     * @param id
     * @return 
     */
    public Tag find(int id) {
        return em.find(Tag.class, id);
    }
    
    /**
     * Rimuove da DB il Tag tramite id
     * 
     * @param id 
     */
    public void remove(int id) {
        em.remove(find(id));
        // oppure:
        // em.remove(em.find(Tag.class, id));
    }
}