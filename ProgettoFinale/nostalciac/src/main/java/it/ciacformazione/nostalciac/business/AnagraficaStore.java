/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.business;

import it.ciacformazione.nostalciac.entity.Anagrafica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * EJB - Enterprise Java Bean
 * 
 * @author tss
 */
@Stateless
public class AnagraficaStore {
    
    @PersistenceContext()
    EntityManager em;

    /**
     * Restituisce tutte le Anagrafiche da DB
     *
     * @return tutte le Anagrafiche
     */
    public List<Anagrafica> all() {
        return em.createQuery("SELECT e FROM Anagrafica e ORDER BY e.cognome, e.nome", Anagrafica.class)
                .getResultList();
    }

    /**
     * Insert o Update su DB
     *
     * @param anagrafica
     * @return
     */
    public Anagrafica save(Anagrafica anagrafica) {
        return em.merge(anagrafica);
    }

    /**
     * Restituisce l'Anagrafica con id
     *
     * @param id
     * @return
     */
    public Anagrafica find(int id) {
        return em.find(Anagrafica.class, id);
    }

    /**
     * Rimuove da DB l'Anagrafica tramite id
     *
     * @param id
     */
    public void remove(int id) {
        em.remove(find(id));
    }

    /**
     * Restituisce le anagrafiche trovate in base alla ricerca
     *
     * @param searchNome
     * @param searchCognome
     * @return
     */
    public List<Anagrafica> search(String searchNome, String searchCognome) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Anagrafica> query = cb.createQuery(Anagrafica.class);
        Root<Anagrafica> root = query.from(Anagrafica.class);

        Predicate condition = cb.conjunction();

        if (searchNome != null && !searchNome.isEmpty()) {
            condition = cb.and(condition,
                    cb.like(root.get("nome"), "%" + searchNome + "%"));
        }

        if (searchCognome != null && !searchCognome.isEmpty()) {
            condition = cb.and(condition,
                    cb.like(root.get("cognome"), "%" + searchCognome + "%"));
        }

        query.select(root)
                .where(condition)
                .orderBy(cb.asc(root.get("cognome")))
                .orderBy(cb.asc(root.get("nome")));

        return em.createQuery(query)
                .getResultList();
    }
}