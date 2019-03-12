/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Giocatore from 'Giocatore';
import Dado from './Dado';

        let g1 = creaGiocatore("Primo");
        let g2 = creaGiocatore("Secondo");
        let dado = new Dado();

        do {
            let ptG1 = dado.lancio();
            let ptG2 = dado.lancio();

            if (ptG1 != ptG2) {
                if (ptG1 > ptG2) {
                    g1.incrementaSoldi();
                    g2.decrementaSoldi();
                } else {
                    g2.incrementaSoldi();
                    g1.decrementaSoldi();
                }
            }

            stampaGiocata(ptG1, ptG2, g1.getSoldi(), g2.getSoldi(), g1.getNome(), g2.getNome());
        } while (g1.getSoldi() > 0 && g2.getSoldi() > 0);
    
    function creaGiocatore(ordinale) {
        console.log()
        
        Scanner s = new Scanner(System.in);
        System.out.println(ordinale + " giocatore, come ti chiami?");
        String nome = s.next();
        System.out.println("Quanti soldi hai?");
        return new Giocatore(s.nextInt(), nome);
    }

    private static void stampaGiocata(int ptG1, int ptG2, int soldiG1, int soldiG2, String nomeG1, String nomeG2) {
        System.out.println("--------------- GIOCATA ---------------");
        System.out.println("Punti " + nomeG1 + ": " + ptG1);
        System.out.println("Punti " + nomeG2 + ": " + ptG2);
        System.out.println("Soldi " + nomeG1 + ": " + soldiG1);
        System.out.println("Soldi " + nomeG2 + ": " + soldiG2);
    }
