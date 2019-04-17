/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.business;

import it.ciacformazione.nostalciac.entity.Tag;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author tss
 */
@Stateless
public class TagStore {

    @PersistenceContext()
    EntityManager em;

    public List<Tag> all() {
        return all(0, 10);
    }
    
    /**
     * Restituisce tutti i Tag da DB
     *
     * @param start
     * @param maxResult
     * @return tutti i Tag
     */
    public List<Tag> all(int start, int maxResult) {
        return em.createQuery("select e FROM Tag e ORDER BY e.tipo", Tag.class)
                .setFirstResult(start)
                .setMaxResults(maxResult)
                .getResultList();

    }

    /**
     * Insert o Update su DB
     *
     * @param tag
     * @return
     */
    public Tag save(Tag tag) {
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
        Tag toremove = em.find(Tag.class, id);
        em.remove(toremove);
    }

    /**
     * Restituisce i tag trovati in base alla ricerca
     *
     * @param searchTag
     * @param searchTipo
     * @param start
     * @param page
     * @return
     */
    public List<Tag> search(String searchTag, String searchTipo,
            Integer start, Integer page) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tag> query = cb.createQuery(Tag.class);
        Root<Tag> root = query.from(Tag.class);

        Predicate condition = cb.conjunction();

        if (searchTag != null && !searchTag.isEmpty()) {
            condition = cb.and(condition,
                    cb.like(root.get("tag"), "%" + searchTag + "%"));
        }

        if (searchTipo != null && !searchTipo.isEmpty()) {
            condition = cb.and(condition,
                    cb.like(root.get("tipo"), "%" + searchTipo + "%"));
        }

        query.select(root)
                .where(condition)
                .orderBy(cb.asc(root.get("tipo")));

        return em.createQuery(query)
                .setFirstResult(start)
                .setMaxResults(page)
                .getResultList();

    }
    
    public Integer searchCount(String searchTag, String searchTipo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Tag> root = query.from(Tag.class);

        Predicate condition = cb.conjunction();

        if (searchTag != null && !searchTag.isEmpty()) {
            condition = cb.and(condition,
                    cb.like(root.get("tag"), "%" + searchTag + "%"));
        }

        if (searchTipo != null && !searchTipo.isEmpty()) {
            condition = cb.and(condition,
                    cb.like(root.get("tipo"), "%" + searchTipo + "%"));
        }

        query.select(cb.count(root))
                .where(condition);

        return em.createQuery(query)
                .getSingleResult().intValue();

    }
    
    public Map<String,Object> searchToJson(String searchTag, String searchTipo,
            Integer start, Integer page) {
        
        int count = searchCount(searchTag, searchTipo);
        
        List<Tag> search = search(searchTag, searchTipo, start, page);
        
        Map<String,Object> result = new HashMap<>();
        result.put("count", count);
        result.put("data", search);
        
        return result;
    }
    
}
