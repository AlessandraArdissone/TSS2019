/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez13_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author tss
 */
public class App2 {

    public static void main(String[] args) {
        try {
            Path path = Paths.get("/home/tss/NetBeansProjects/TSS2019/Java/esempio2.txt");
            Files.readAllLines(path).forEach(v -> System.out.println(v));

            String testo = "\nBASTAAAAA!!!!!\n";

            Files.write(path, testo.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("Errore generico di I/O :-(");
        }
    }
}
