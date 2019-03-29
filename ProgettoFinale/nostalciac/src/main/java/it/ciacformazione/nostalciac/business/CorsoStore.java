/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.business;

import it.ciacformazione.nostalciac.entity.Corso;
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
public class CorsoStore {

    @PersistenceContext()
    EntityManager em;

    /**
     * Restituisce tutti i Corsi da DB
     *
     * @return tutti i Corsi
     */
    public List<Corso> all() {
        return em.createQuery("SELECT e FROM Corso e ORDER BY e.nome", Corso.class)
                .getResultList();
    }

    /**
     * Insert o Update su DB
     *
     * @param corso
     * @return
     */
    public Corso save(Corso corso) {
        return em.merge(corso);
    }

    /**
     * Restituisce il Corso con id
     *
     * @param id
     * @return
     */
    public Corso find(int id) {
        return em.find(Corso.class, id);
    }

    /**
     * Rimuove da DB il Corso tramite id
     *
     * @param id
     */
    public void remove(int id) {
        em.remove(find(id));
        // oppure:
        // em.remove(em.find(Corso.class, id));
    }

    /**
     * Restituisce i corsi trovati in base alla ricerca
     *
     * @param searchNome
     * @return
     */
    public List<Corso> search(String searchNome) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Corso> query = cb.createQuery(Corso.class);
        Root<Corso> root = query.from(Corso.class);

        Predicate condition = cb.conjunction();

        if (searchNome != null && !searchNome.isEmpty()) {
            condition = cb.and(condition,
                    cb.like(root.get("nome"), "%" + searchNome + "%"));
        }

        query.select(root)
                .where(condition)
                .orderBy(cb.asc(root.get("nome")));

        return em.createQuery(query)
                .getResultList();
    }
}
