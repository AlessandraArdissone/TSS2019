/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lex13_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App2 {

    public static void main(String[] args) {

        try {
            Files.readAllLines(Paths.get("/home/tss/esempio.txt"))
                    .forEach(v -> System.out.println(v));

            String testo = "ciao a tutti\nè ora di intervallo";

            Files.write(Paths.get("/home/tss/esempio_scrittura.txt"), testo.getBytes());
            
        } catch (IOException ex) {
            Logger.getLogger(App2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
