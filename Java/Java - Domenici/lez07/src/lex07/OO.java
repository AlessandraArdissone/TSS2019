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
public class OO {

    public static void main(String[] args) {

        
        String s = "ciao";
        
        String s1 = s ;
        
        s = s.toUpperCase();
        
        System.out.println(s);
        
        System.out.println(s1);
         
        
        StringBuffer sb = new StringBuffer("ciao");

        System.out.println(sb);
        
        sb.append(" a tutti");
        
        System.out.println(sb);
        
        
        StringBuffer sb1 = sb;
        
        sb1.append(" tra un po si mangia...");
        
        System.out.println("sb ->" + sb);
        
        System.out.println("sb1 ->" + sb1);
        
        
    }
}
