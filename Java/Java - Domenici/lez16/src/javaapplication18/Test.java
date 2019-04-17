/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

/**
 *
 * @author tss
 */
public class Test {
    public static void main(String[] args) {
        Prova prova = new Prova("ciao");
        Prova prova1 = new Prova();
    }
}


class Prova{
    
    private String message;

    public Prova() {
    }

    public Prova(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}