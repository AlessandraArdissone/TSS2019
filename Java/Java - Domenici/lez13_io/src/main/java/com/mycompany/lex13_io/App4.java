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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App4 {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.google.it");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String riga;
            while ((riga = br.readLine()) != null) {
                System.out.println(riga);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(App4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
