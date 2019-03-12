/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {

        ContoCorrente cc = new ContoCorrente(1, "Rossi");
        cc.deposito(50);
        cc.deposito(25.30);
        cc.prelievo(50);
        cc.deposito(45.3);
        cc.prelievo(20);
        cc.deposito(100);
        stampaConto(cc);

        System.out.println("----------------------------");
        for (int i = 0; i < cc.estrattoConto(4).size(); i++) {
            Double movimento = cc.estrattoConto(4).get(i);
             System.out.println(movimento);
        }
        System.out.println("----------------------------");
        for (Double movimento : cc.estrattoConto(4)) {
            System.out.println(movimento);
        }
        System.out.println("----------------------------");
        cc.estrattoConto(4).stream().forEach(movimento -> System.out.println(movimento));
    }

    public static void stampaConto(ContoCorrente cc) {
        System.out.println("----------------------------");
        System.out.println("numero:\t\t" + cc.getNumero());
        System.out.println("intestatario:\t" + cc.getIntestatario());
        System.out.println(String.format("saldo:\t\t%s", cc.getSaldo()));
        System.out.println("----------------------------");
    }
}
