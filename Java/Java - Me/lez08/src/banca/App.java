/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import java.util.List;

/*
import java.util.ArrayList;
import java.util.List;
 */
/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        // LISTA DINAMICA DI OGGETTI GENERICI:
        // ArrayList<ContoCorrente> conti = new ArrayList<ContoCorrente>(); // NON OCCORRE PIU' SPECIFICARE LA CLASSE!
        // List<ContoCorrente> conti = new ArrayList<ContoCorrente>(); // NON OCCORRE PIU' SPECIFICARE LA CLASSE!
        // List è una lista generica
/*
        List<ContoCorrente> conti = new ArrayList<>();
        conti.add(new ContoCorrente(1, "Alessandra Ardissone"));
         */
        ContoCorrente cc = new ContoCorrente(1, "Alessandra Ardissone");
        cc.deposito(50);
        cc.deposito(25.30);
        cc.prelievo(50);
        cc.deposito(45.3);
        cc.prelievo(20);
        cc.deposito(100);

        stampaConto(cc);
/*
        for (int i = 0; i < cc.estrattoConto(5).size(); i++) {
            Double movimento = cc.estrattoConto(5).get(i);
            System.out.println(movimento);
        }
        //cc.estrattoConto(num).forEach((movimento) -> {
        for (Double movimento : cc.estrattoConto(5)) {
            System.out.println(movimento);
        }
        //});
*/
        System.out.println("-------------ESTRATTO CONTO------------");
        cc.estrattoConto(5).stream().forEach(movimento -> System.out.println(movimento)); // ARROW FUNCTION: funzione definita "al volo"

        System.out.println("---------------DEPOSITI----------------");
        cc.estrattoDepositi(5).stream().forEach(movimento -> System.out.println(movimento)); // ARROW FUNCTION: funzione definita "al volo"
    }

    private static void stampaConto(ContoCorrente cc) {
        System.out.println("---------------------------------------");
        System.out.println("Numero:\t\t" + cc.getNumero());
        System.out.println("Intestatario:\t" + cc.getIntestatario());
        System.out.println(String.format("Saldo:\t\t%s", cc.getSaldo()));
        System.out.println("---------------------------------------");
    }
}
