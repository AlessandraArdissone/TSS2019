/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_esperienze")
public class Esperienza implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_esperienza")
    private int id;
    
    @Column(name = "esperienza", nullable = false, length = 100)
    private String nome;

    @Column(name = "note_esperienza")
    private String note;

    @Column(name = "luogo")
    private String luogo;

    @Column(name = "stato")
    private String nazione;

    @Column(name = "data_inizio_esperienza", nullable = false)
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate inizio;

    @Column(name = "data_fine_esperienza")
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate fine;
    
    @Transient
    private Integer idAnagrafica;

    //@JsonbTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_anagrafica", referencedColumnName = "id_anagrafica")
    private Anagrafica anagrafica;
    
    @ManyToMany
    @OrderBy("tag ASC")
    @JoinTable(
            name = "t_tags_esperienze",
            joinColumns =
                    @JoinColumn(name = "id_esperienza", referencedColumnName = "id_esperienza"),
            inverseJoinColumns = 
                    @JoinColumn(name = "id_tag", referencedColumnName = "id_tag")
    )
    private Set<Tag> tags = new TreeSet<>();

    public Esperienza() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public LocalDate getInizio() {
        return inizio;
    }

    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate fine) {
        this.fine = fine;
    }

    public Integer getIdAnagrafica() {
        return idAnagrafica;
    }

    public void setIdAnagrafica(Integer idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    public Anagrafica getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(Anagrafica anagrafica) {
        this.anagrafica = anagrafica;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Esperienza other = (Esperienza) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Esperienza{" + "id=" + id + ", nome=" + nome + ", note="
                + note + ", luogo=" + luogo + ", nazione=" + nazione + ", inizio="
                + inizio + ", fine=" + fine + ", anagrafica=" + anagrafica + '}';
    }
}
