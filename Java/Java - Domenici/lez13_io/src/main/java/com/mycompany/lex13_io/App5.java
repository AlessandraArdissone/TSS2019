/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lex13_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App5 {

    public static void main(String[] args) throws MalformedURLException, IOException {

        URL url = new URL("https://www.google.it");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        Path fileToWrite = Paths.get("/home/tss/google_home_it.html");
        if (Files.exists(fileToWrite)) {
            Files.delete(fileToWrite);
        }
        String riga;
        while ((riga = br.readLine()) != null) {
            Files.write(fileToWrite, riga.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }

    }
}
