/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez13_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author tss
 */
public class App3 {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");

            InputStream stream = url.openStream();
            int c;
            while ((c = stream.read()) != -1) {
                System.out.print((char) c);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            Path path = Paths.get("/home/tss/NetBeansProjects/TSS2019/Java/esempio3.html");
            Files.deleteIfExists(path);
            String riga;
            while ((riga = br.readLine()) != null) {
                Files.write(path, riga.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
