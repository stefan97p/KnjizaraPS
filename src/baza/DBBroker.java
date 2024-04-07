/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Knjiga;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Autor;
import model.Zanr;

/**
 *
 * @author Ne
 */
public class DBBroker {

    public List<Knjiga> ucitajKnjige() {
        List<Knjiga> knjige = new ArrayList<>();
        try {
            
            String upit = "SELECT * FROM knjiga k JOIN autor a ON k.autorId=a.id";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs =  st.executeQuery(upit);
            
            while(rs.next()){
                int id = rs.getInt("k.id");
                String naslov =rs.getString("k.naslov");
                int godinaIzdanja = rs.getInt("k.godinaIzdanja");
                String ISBN =rs.getString("k.ISBN");
                String zanr =rs.getString("k.zanr");
                Zanr z = Zanr.valueOf(zanr);
                int idA = rs.getInt("a.id");
                String ime =rs.getString("a.ime");
                String prezime =rs.getString("a.prezime");
                int godinaRodjenja =rs.getInt("a.godinaRodjenja");
                String biografija =rs.getString("a.biografija");
                
                Autor a = new Autor(idA, ime, prezime, godinaRodjenja, biografija);           
                Knjiga k = new Knjiga(id, naslov, a, ISBN, godinaIzdanja, z);
                
                knjige.add(k);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return knjige;
    }

    public List<Autor> ucitajAutore() {
        List<Autor> autori = new ArrayList<>();
        try {
            
            String upit = "SELECT * FROM autor a";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs =  st.executeQuery(upit);
            
            while(rs.next()){
               
                int idA = rs.getInt("a.id");
                String ime =rs.getString("a.ime");
                String prezime =rs.getString("a.prezime");
                int godinaRodjenja =rs.getInt("a.godinaRodjenja");
                String biografija =rs.getString("a.biografija");
                
                Autor a = new Autor(idA, ime, prezime, godinaRodjenja, biografija);           
                
                autori.add(a);
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autori;
    }

    public void obrisiKnjigu(int id) {
        try {
            String upit = "DELETE  FROM knjiga WHERE id=?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, id);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
        try {
            String upit = "INSERT  INTO knjiga(id, naslov, autorId, ISBN, godinaIzdanja,zanr)"
                    +"VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, novaKnjiga.getId());
            ps.setString(2, novaKnjiga.getNaslov());
            ps.setInt(3, novaKnjiga.getAutor().getId());
            ps.setString(4, novaKnjiga.getISBN());
            ps.setInt(5, novaKnjiga.getGodinaIzdanja());
            ps.setString(6, String.valueOf(novaKnjiga.getZanr()));
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
              try {
            String upit = "UPDATE knjiga SET naslov=?, autorId=?, godinaIzdanja=?, zanr=? WHERE id=?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, knjigaZaIzmenu.getNaslov());
            ps.setInt(2, knjigaZaIzmenu.getAutor().getId());
            ps.setInt(3, knjigaZaIzmenu.getGodinaIzdanja());
            ps.setString(4, String.valueOf(knjigaZaIzmenu.getZanr()));
            ps.setInt(5, knjigaZaIzmenu.getId());
            
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    
    
}
