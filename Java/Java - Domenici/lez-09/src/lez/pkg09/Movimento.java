/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez.pkg09;

import java.time.LocalDate;

/**
 *
 * @author tss
 */
public class Movimento {

    private final LocalDate data;

    private final TipoMovimento tipoMovimento;

    private final double importo;

    public Movimento(LocalDate data, TipoMovimento tipoMovimento, double importo) {
        this.data = data;
        this.tipoMovimento = tipoMovimento;
        this.importo = importo;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public double getImporto() {
        return importo;
    }

}
