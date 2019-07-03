/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.mycloud.business;

import it.ciacformazione.mycloud.Configurazione;
import it.ciacformazione.mycloud.entity.Documento;
import it.ciacformazione.mycloud.entity.Utente;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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
public class UtenteStore {
    
    @PersistenceContext()
    EntityManager em;
    
    @Inject
    DocumentoStore docStore;

    public Optional<Utente> login(String usr, String pwd) {
        try {
            Utente u = em.createQuery("SELECT e FROM Utente e "
                    + "WHERE e.username = :usr AND e.password = :pwd", Utente.class)
                    .setParameter("usr", usr)
                    .setParameter("pwd", pwd)
                    .getSingleResult();
            return Optional.of(u);
        } catch (NoResultException | NonUniqueResultException ex) {
            return Optional.empty();
        }
    }
    
    /**
     * Restituisce tutti gli Utenti da DB
     * (serve per scegliere con chi condividere)
     * 
     * TODO: filtrare escludendo l'utente corrente
     *
     * @return tutti gli Utenti
     */
    public List<Utente> all() {
        return em.createQuery("SELECT e FROM Utente e ORDER BY e.username", Utente.class)
                .getResultList();
/*        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utente> query = cb.createQuery(Utente.class);
        Root<Utente> root = query.from(Utente.class);

        Predicate condition = cb.conjunction();

            condition = cb.and(condition,
                    cb.equal(root.get("id"), 1));

        query.select(root)
                .where(condition)
                .orderBy(cb.asc(root.get("username")));

        return em.createQuery(query)
                .getResultList();
*/
    }
    
    /**
     * Insert o Update su DB
     *
     * @param utente
     * @return
     */
    public Utente save(Utente utente) {
        Utente saved = em.merge(utente);
        Path path = Paths.get(Configurazione.DOCUMENT_FOLDER + saved.getUsername());
        if (Files.notExists(path, LinkOption.NOFOLLOW_LINKS)) {
            try {
                Files.createDirectory(path);
            } catch (IOException ex) {
                throw new EJBException("Salvataggio dell'utente fallito.");
            }
        }
        return saved;
    }
    
    /**
     * Restituisce l'Utente con id
     *
     * @param id
     * @return
     */
    public Utente find(int id) {
        return em.find(Utente.class, id);
    }
    
    private void deleteDirectoryStream(Path path) throws IOException {
        Files.walk(path)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }
            
    /**
     * Rimuove da DB l'Utente tramite id
     *
     * @param id
     */
    public void remove(int id) {
        Utente toBeRemoved = find(id);
        em.createQuery("delete from Documento e where e.utente = :usr")
                .setParameter("usr", toBeRemoved)
                .executeUpdate();
        try {
            deleteDirectoryStream(Paths.get(Configurazione.DOCUMENT_FOLDER + toBeRemoved.getUsername()));
        } catch (IOException ex) {
            throw new EJBException("Rimozione dell'utente fallita.");
        }
        em.remove(find(id));
    }
    
    /**
     * Restituisce gli utenti trovati in base alla ricerca
     *
     * @param searchUsername
     * @return
     */
    public List<Utente> search(String searchUsername) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utente> query = cb.createQuery(Utente.class);
        Root<Utente> root = query.from(Utente.class);

        Predicate condition = cb.conjunction();

        if (searchUsername != null && !searchUsername.isEmpty()) {
            condition = cb.and(condition,
                    cb.like(root.get("username"), "%" + searchUsername + "%"));
        }

        query.select(root)
                .where(condition)
                .orderBy(cb.asc(root.get("username")));

        return em.createQuery(query)
                .getResultList();
    }

    public List<Documento> findDocumenti(int id) {
        return em.createQuery("select e.documenti from Utenti e where e.id= :utente_id", Documento.class)
                .setParameter("utente_id", id)
                .getResultList();
    }
}
