/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.mycloud.business;

import it.ciacformazione.mycloud.Configurazione;
import it.ciacformazione.mycloud.entity.Documento;
import it.ciacformazione.mycloud.entity.Utente;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class DocumentoStore {
    
    @PersistenceContext
    EntityManager em;
    
    // TODO: utente corrente!
    Utente logged;
    
    @PostConstruct
    public void init() {
        logged = em.find(Utente.class, 1);
    }
    
    /**
     * Restituisce tutti i Documenti da DB
     * 
     * @return tutti i Documenti dell'utente loggato
     */
    public List<Documento> all() {
        return em.createQuery("select e from Documento e where e.user = :usr")
                .setParameter("usr", logged)
                .getResultList();
    }
    
    public Documento find(int id) {
        return em.find(Documento.class, id);
    }
    
    private Path documentPath(String name) {
        return Paths.get(Configurazione.DOCUMENT_FOLDER +
                logged.getUsername() + "/" + name);
    }
    
    public Documento save(Documento d, InputStream is) {
        d.setUtente(logged);
        Documento saved = em.merge(d);
        try {
            Files.copy(is, documentPath(saved.getFile()),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new EJBException("Salvataggio del documento fallito.");
        }
        return saved;
    }
    
    public void remove(int id) {
        Documento toBeRemoved = find(id);
        try {
            Files.delete(documentPath(toBeRemoved.getFile()));
        } catch (IOException ex) {
            throw new EJBException("Rimozione del documento fallita.");
        }
        em.remove(toBeRemoved);
    }
    
    // TODO!!!!
    void removeByRemovedUser(int id) {
        throw new UnsupportedOperationException("Operazione non ancora supportata.");
    }
}
