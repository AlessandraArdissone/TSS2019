/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Sim {

    private final String numero;
    private final double credito;
    private final List<Telefonata> telefonate;

    public Sim(String numero, double credito) {
        this.numero = numero;
        this.credito = credito;
        this.telefonate = new ArrayList<>();
    }

    public void chiamata(int durata, String destinatario) {
        this.telefonate.add(new Telefonata(durata, destinatario));
    }

    public int totaleMinutiConversazione() {
        return telefonate.stream()
                .mapToInt(v -> v.durata)
                .sum();
    }

    public long telefonateAlNumero(String numero) {
        return telefonate.stream()
                .filter(v -> v.destinatario.equals(numero))
                .count();
    }

    public long totaleMinutiConversazioneAlNumero(String numero) {
        return telefonate.stream()
                .filter(v -> v.destinatario.equals(numero))
                .mapToInt(v -> v.durata)
                .sum();
    }
    
    public String getNumero() {
        return numero;
    }

    public double getCredito() {
        return credito;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------- SIM ------------------------------------\n");
        sb.append("numero: ").append(this.numero).append("\n");
        sb.append("credito: ").append(this.credito).append("\n");
        sb.append("------ Telefonate ------------------\n");
        telefonate.forEach(v -> sb.append(v));
        sb.append("--------------------------------------------------------\n");
        return sb.toString();
    }

    private static class Telefonata {

        private final int durata;
        private final String destinatario;

        private Telefonata(int durata, String destinatario) {
            this.durata = durata;
            this.destinatario = destinatario;
        }

        @Override
        public String toString() {
            return String.format("destinatario -> %s \t durata -> %s \n", 
                    this.destinatario, this.durata);
        }

        
    }

}
