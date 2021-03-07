/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package indkøbsliste.projekt.pkg2;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author krist
 */
public class DatabaseKode {
    
    Connection connection = null;
    
    void connect() {
        try {
        connection = DriverManager.getConnection("jdbc:sqlite"+Paths
                .get("")
                .toAbsolutePath()
                .toString()+"\\src\\indkøsliste\\projekt\\pkg2\\Database.sqlite");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
    }
//laver en connection mellem database og program//
    
    public ObservableList VareInfo(){
        this.connect ();
        ObservableList Vare = FXCollections.observableArrayList();
        String query = "SELECT * FROM VareInfo";
        try {
            ResultSet result = connection
                    .createStatement()
                    .executeQuery(query);
            while(result.next()){
                Vare.add(result.getString("Vare"));   
            }
        }catch(SQLException ex){
            
        }
        return Vare;
    }
//skulle gerne være her hvor vi kan indsætte vores vare i databasen. Da vi indsatte dette opstod dog nogle ukendte fejl//
    void skrivString(String indkøbsvare) {
        String query ="INSERT INTO VareInfo(Vare)VALUES('"+indkøbsvare+"')";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch(SQLException ex){
            
        }
    }
      
}
