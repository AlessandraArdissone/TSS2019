/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lex07;

/**
 *
 * @author tss
 */
public class OO1 {
   
    public static void main(String[] args) {
        
        Giacca giacca = new Giacca();
        
        Giacca giacca1 = new Giacca();
        
        giacca.chiudiZip();
        
        System.out.println(giacca.stato());
        
        System.out.println(giacca1.stato());
    }
            
}
