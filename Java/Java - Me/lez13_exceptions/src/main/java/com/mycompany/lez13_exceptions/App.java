/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez13_exceptions;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        try {
            System.out.println("--------------START--------------");
            method();
            System.out.println("proseguo senza errori...");
            System.out.println("--------FINE BLOCCO TRY SENZA ERRORI--------");

//      } catch (Exception ex) {
        } catch (Throwable ex) {
            System.out.println("Scusa, qualcosa è andato storto...");
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
            System.out.println(ex.toString());
        }

        System.out.println("continuo imperterrito...");
        method1();
        System.out.println("--------------END--------------");
    }

    public static void method() {
        method();
    }

    public static void method1() {
        System.out.println("esecuzione method1 dopo stack overflow...");
    }
}
