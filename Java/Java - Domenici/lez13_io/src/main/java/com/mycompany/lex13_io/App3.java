/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lex13_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App3 {
    
    public static void main(String[] args) {
        
        try {
            URL url = new URL("https://www.google.it");
            URLConnection cn = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(cn.getInputStream()));
            String line;
            while((line = br.readLine()) !=null){
                System.out.println(line);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(App3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
