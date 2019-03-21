/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noleggio.bici.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import noleggio.bici.entity.Bicicletta;

/**
 *
 * @author tss
 */
@Stateless
public class BiciclettaStore {

    public List<Bicicletta> all() {
        List<Bicicletta> result = new ArrayList<>();

        try (Connection cn = DSManager.connection();
                Statement cmd = cn.createStatement(); // CREO UN OGGETTO DI TIPO "ISTRUZIONE"
                ResultSet query = cmd.executeQuery("SELECT * FROM t_biciclette ORDER BY marca, modello");) {    // ESEGUO UNA QUERY

            System.out.println("-----------------------Biciclette trovate-----------------------");

            while (query.next()) {  // CICLO SUI RECORD RESTITUITI DALLA QUERY
                String marca = query.getString("marca");
                System.out.println(marca);
                result.add(new Bicicletta(
                        query.getInt("id_bicicletta"),
                        query.getString("marca"),
                        query.getString("modello")));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(BiciclettaStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DataBase error");
        }
    }
}
