/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author Ne
 */
public class Controller {
    private DBBroker dbb;
    private List<Knjiga>listaKnjiga = new ArrayList<>();
    private List<Autor>listaAutora = new ArrayList<>();

    private static Controller instance;
    public static Controller getInstance(){
        if(instance==null){
            instance = new Controller();
        }
        return instance;
    }
    
    private Controller() {
        
        dbb = new DBBroker();
          
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
      return  dbb.ucitajKnjige();
    }

    public List<Autor> ucitajAutore() {
        return  dbb.ucitajAutore();
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
        dbb.azurirajKnjigu(knjigaZaIzmenu);
    }
    
    
    
}
