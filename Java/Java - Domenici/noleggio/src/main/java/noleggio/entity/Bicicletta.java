/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.entity;

/**
 *
 * @author tss
 */
public class Bicicletta {
    
    private int id;
    private String marca;
    private String modello;

    public Bicicletta() {
    }

    public Bicicletta(int id, String marca, String modello) {
        this.id = id;
        this.marca = marca;
        this.modello = modello;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
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
        final Bicicletta other = (Bicicletta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bicicletta{" + "id=" + id + ", marca=" + marca + ", modello=" + modello + '}';
    }
    
    
}
