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
public class App1 {
    public static void main(String[] args) {
        A a = new A();
       
        B b = new B();
        
        System.out.println(a.getClass().equals(b.getClass()));
    
        B b1 = new B();
        
        System.out.println(b1.getClass().equals(b.getClass()));
    
        C c = new C();
        
        System.out.println(a.getClass().equals(c.getClass()));
    
        System.out.println(c instanceof A);
    }
    
}

class A{
    
}

class B{
    
}

class C extends A{
    
}


