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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_anagrafiche")
public class Anagrafica implements Serializable {

    public static enum Ruolo {
        A, U
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anagrafica")
    private int id;

    @Column(name = "cognome", nullable = false, length = 45)
    private String cognome;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "data_nascita")
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate nascita;

    @Column(name = "usr", nullable = false, length = 45)
    private String usr;

    @Column(name = "pwd", nullable = false, length = 45)
    private String pwd;

    @Column(name = "mail", nullable = false, length = 45)
    private String mail;

    @Column(name = "ruolo", nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private Ruolo ruolo = Ruolo.U;

    @Column(name = "citta", length = 50)
    private String citta;

    @Column(name = "indirizzo", length = 45)
    private String indirizzo;

    @Column(name = "tel", length = 45)
    private String tel;

    @Column(name = "note")
    private String note;

    @Column(name = "filefoto", length = 100)
    private String foto;
    
    @ManyToMany
    @OrderBy("nome ASC")
    @JoinTable(
            name = "t_anagrafiche_corsi",
            joinColumns =
                    @JoinColumn(name = "id_anagrafica", referencedColumnName = "id_anagrafica"),
            inverseJoinColumns = 
                    @JoinColumn(name = "id_corso", referencedColumnName = "id_corso")
    )
    private Set<Corso> corsi = new TreeSet<>();

    public Anagrafica() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public void setNascita(LocalDate nascita) {
        this.nascita = nascita;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Set<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(Set<Corso> corsi) {
        this.corsi = corsi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
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
        final Anagrafica other = (Anagrafica) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Anagrafica{" + "id=" + id + ", cognome=" + cognome + ", nome="
                + nome + ", nascita=" + nascita + ", usr=" + usr + ", pwd="
                + pwd + ", mail=" + mail + ", ruolo=" + ruolo + ", citta="
                + citta + ", indirizzo=" + indirizzo + ", tel=" + tel + ", note="
                + note + ", foto=" + foto + '}';
    }
}
