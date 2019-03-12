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
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Movimento m = new Movimento(LocalDate.MAX, TipoMovimento.DEPOSITO, 0);
        
        ContoCorrente cc = new ContoCorrente(1, "Rossi");
        cc.deposito(100);
        cc.prelievo(40);
        cc.deposito(25);
        cc.prelievo(10);
        stampaConto(cc);
    }
    
    public static void stampaConto(ContoCorrente cc) {
        System.out.println("----------------------------");
        System.out.println("numero:\t\t" + cc.getNumero());
        System.out.println("intestatario:\t" + cc.getIntestatario());
        System.out.println(String.format("saldo:\t\t%s", cc.getSaldo()));
        System.out.println("--------------- Movimenti ----------");
        cc.estrattoConto(5).stream().forEach(movimento -> {
            System.out.println(String.format("Data %s \t Tipo %s \t Importo %s", 
                    movimento.getData(), movimento.getTipoMovimento(),movimento.getImporto()));
        });
        System.out.println("----------------------------");
    }
    
}
