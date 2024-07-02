/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Autor;
import model.Knjiga;
import model.User;
import model.Zanr;

/**
 *
 * @author Ne
 */
public class Controller {
    private DBBroker dbb;
    private List<Knjiga>listaKnjiga = new ArrayList<>();
    private List<Autor>listaAutora = new ArrayList<>();
    private List<User>listaUsera = new ArrayList<>();

    private static Controller instance;
    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
        }
        return instance;
    }
    
    private Controller() {
        
        dbb = new DBBroker();
        
        User u1 = new User(1, "Pera", "pera");
        User u2 = new User(1, "Mile", "mile");
        User u3 = new User(1, "Smilja", "smilja");
        
        listaUsera.add(u1);
        listaUsera.add(u2);
        listaUsera.add(u3);
          
//        Autor a1 = new Autor("Ivo", "Andric", 1892, "Biografija");
//        Autor a2 = new Autor("Danilo", "Kis", 1935, "Biografijaa je tto");
//        Autor a3 = new Autor("Milos", "Peric", 1985, "Biografija i ostalo");
//        
//        Knjiga k1 = new Knjiga("Na Drini Cuprija", a1, "12345315", 1945, Zanr.ISTORIJSKI);
//        Knjiga k2 = new Knjiga("Basta", a2, "52125315", 1982, Zanr.ROMAN);
//        Knjiga k3 = new Knjiga("Detektiv Pera", a3, "007", 2003, Zanr.DETEKTIVSKI);
//        
//        listaAutora.add(a1);
//        listaAutora.add(a2);
//        listaAutora.add(a3);
//        
//        listaKnjiga.add(k1);
//        listaKnjiga.add(k2);
//        listaKnjiga.add(k3);
        
    }

    public List<User> getListaUsera() {
        return listaUsera;
    }

    public void setListaUsera(List<User> listaUsera) {
        this.listaUsera = listaUsera;
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public void obrisiKnjigu(int id) {
        dbb.obrisiKnjigu(id);
        
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
        dbb.dodajKnjigu(novaKnjiga);
    // listaKnjiga.add(novaKnjiga);
    }

    public List<Knjiga> ucitajKnjige() {
      this.listaKnjiga = dbb.ucitajKnjige();
        return listaKnjiga;
    }

    public List<Autor> ucitajAutore() {
        return  dbb.ucitajAutore();
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
        dbb.azurirajKnjigu(knjigaZaIzmenu);
    }

    public boolean login1(String username, String password) {

        for (User u : listaUsera) {
            if (u.getUsername().equals(username)&&u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean login2(String username, String password) {
        
        return dbb.login(username,password);
    }

    public List<Knjiga> filtriraj(String autor, String naziv) {
        List<Knjiga> rez = new ArrayList<>();
        if (autor!=null&& naziv==null) {
            for (Knjiga k : listaKnjiga) {
                String autorKnjige = k.getAutor().getIme()+" "+k.getAutor().getPrezime();
                if (autorKnjige.contains(autor)) {
                    rez.add(k);
                }
            }
   
        }
        if (autor==null && naziv!=null) {
            for (Knjiga k : listaKnjiga) {
                if (k.getNaslov().contains(naziv)) {
                    rez.add(k);
                }
            }
        }
        if (autor!=null && naziv!=null) {
                for (Knjiga k : listaKnjiga) {
                String autorKnjige = k.getAutor().getIme()+" "+k.getAutor().getPrezime();
                if (autorKnjige.contains(autor)&& k.getNaslov().contains(naziv)) {
                    rez.add(k);
                }
            }
        }
//        List<Knjiga> rez2 = new ArrayList<>();
//        rez2 = listaKnjiga.stream()
//                .filter(k->(naziv!=null && k.getNaslov().contains(naziv))&&
//                (autor!=null && (k.getAutor().getIme()+" "+k.getAutor().getPrezime()).contains(autor)))
//                .collect(Collectors.toList());
        
        
        return rez;
    }
    
    
    
}
