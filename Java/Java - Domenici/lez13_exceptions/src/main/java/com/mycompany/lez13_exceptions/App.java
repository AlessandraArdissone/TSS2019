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

        System.out.println("------start-----");
        method();
        System.out.println("proseguo senza errori...");
        System.out.println("------ fine blocco try senza errori -----");

        System.out.println("continuo imperterrito....");

        method1();

        System.out.println("----- end-----");
    }

    public static void method() {

        method();

    }

    private static void method1() {
        System.out.println("esecuzione method1... dopo stack overflow...");
    }
}
