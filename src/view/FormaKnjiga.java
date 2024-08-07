/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.Controller;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author Ne
 */
public class FormaKnjiga extends javax.swing.JDialog {

    private Controller kontroler;
    private GlavnaForma gf;
    private Knjiga knjigaZaIzmenu;
    /**
     * Creates new form FormaKnjiga
     */
    public FormaKnjiga(java.awt.Frame parent, boolean modal, Knjiga knjigaZaIzmenu) {
        super(parent, modal);
        initComponents();
        kontroler = Controller.getInstance();
        this.gf=(GlavnaForma) parent;
        popuniComboBoxAutorima();
        if (knjigaZaIzmenu!=null) {
            this.knjigaZaIzmenu = knjigaZaIzmenu;
            jTextFieldNaziv.setText(knjigaZaIzmenu.getNaslov());
            jComboBoxAutor.setSelectedItem(knjigaZaIzmenu.getAutor());
            jTextFieldISBN.setText(knjigaZaIzmenu.getISBN());
            jTextFieldISBN.setEnabled(false);
            jTextFieldGodina.setText(String.valueOf(knjigaZaIzmenu.getGodinaIzdanja()));
            jComboBoxZanr.setSelectedItem(knjigaZaIzmenu.getZanr());
            jButtonDodaj.setVisible(false);
        } else {
            jButtonIzmeni.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldISBN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxAutor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxZanr = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldGodina = new javax.swing.JTextField();
        jButtonDodaj = new javax.swing.JButton();
        jButtonOdustani = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv");

        jTextFieldNaziv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNazivActionPerformed(evt);
            }
        });

        jLabel2.setText("Autor");

        jTextFieldISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldISBNActionPerformed(evt);
            }
        });

        jLabel3.setText("ISBN");

        jLabel4.setText("Zanr");

        jComboBoxZanr.setModel(new DefaultComboBoxModel(Zanr.values())
        );
        jComboBoxZanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxZanrActionPerformed(evt);
            }
        });

        jLabel5.setText("Godina izdanja");

        jTextFieldGodina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGodinaActionPerformed(evt);
            }
        });

        jButtonDodaj.setText("Dodaj");
        jButtonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajActionPerformed(evt);
            }
        });

        jButtonOdustani.setText("Odustavi");
        jButtonOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdustaniActionPerformed(evt);
            }
        });

        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldGodina)
                    .addComponent(jComboBoxZanr, 0, 159, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxAutor, 0, 160, Short.MAX_VALUE)
                    .addComponent(jTextFieldNaziv)
                    .addComponent(jTextFieldISBN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonOdustani)
                    .addComponent(jButtonDodaj)
                    .addComponent(jButtonIzmeni))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDodaj))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIzmeni))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxZanr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jButtonOdustani)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNazivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNazivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNazivActionPerformed

    private void jTextFieldISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldISBNActionPerformed

    private void jComboBoxZanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxZanrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxZanrActionPerformed

    private void jTextFieldGodinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGodinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGodinaActionPerformed

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
        String naziv = jTextFieldNaziv.getText();
        if(naziv==null || naziv.isEmpty() ||naziv.length()<3){
            JOptionPane.showMessageDialog(this, "Los naziv!", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String isbn = jTextFieldISBN.getText();
        int godinaIz;
        try {
            godinaIz = Integer.parseInt(jTextFieldGodina.getText());
            if(godinaIz<0 || godinaIz>2024){
                JOptionPane.showMessageDialog(this, "Losa godina izdanja", "Upozorenje", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Godinaizdanja mora biti broj", "Upozorenje", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Zanr zanr = (Zanr) jComboBoxZanr.getSelectedItem();
        Autor autor = (Autor) jComboBoxAutor.getSelectedItem();
        
        Random rand = new Random();
        int id = 101+rand.nextInt(Integer.MAX_VALUE-100);
        
        Knjiga novaKnjiga = new Knjiga(id,naziv, autor, isbn, godinaIz, zanr);
        
        kontroler.dodajKnjigu(novaKnjiga);
        JOptionPane.showMessageDialog(this, "Knjiga je uspesno dodata", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
        gf.osveziTabelu();
        this.dispose();
    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdustaniActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonOdustaniActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        String naziv = jTextFieldNaziv.getText();
        String isbn = jTextFieldISBN.getText();
        int godinaIz;
        try {
            godinaIz = Integer.parseInt(jTextFieldGodina.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Godinaizdanja mora biti broj", "Upozorenje", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Zanr zanr = (Zanr) jComboBoxZanr.getSelectedItem();
        Autor autor = (Autor) jComboBoxAutor.getSelectedItem();
        
        knjigaZaIzmenu.setNaslov(naziv);
        knjigaZaIzmenu.setAutor(autor);
        knjigaZaIzmenu.setGodinaIzdanja(godinaIz);
        knjigaZaIzmenu.setZanr(zanr);
        
        kontroler.azurirajKnjigu(knjigaZaIzmenu);
        
        JOptionPane.showMessageDialog(this, "Knjiga je uspesno azurirana", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
        gf.osveziTabelu();
        this.dispose();
    }//GEN-LAST:event_jButtonIzmeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonOdustani;
    private javax.swing.JComboBox<Autor> jComboBoxAutor;
    private javax.swing.JComboBox<String> jComboBoxZanr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldGodina;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldNaziv;
    // End of variables declaration//GEN-END:variables

    private void popuniComboBoxAutorima() {
        jComboBoxAutor.removeAllItems();
        List<Autor>autori = kontroler.ucitajAutore();
        for (Autor autor : autori) {
            jComboBoxAutor.addItem(autor);
        }
    }
}
