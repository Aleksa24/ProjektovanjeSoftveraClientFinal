/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.izvodjac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.components.iValue.product.IzvodjacIzmeniPanel;

/**
 *
 * @author Aleksa
 */
public class IzvodjacPretraziPoKriterijumuButtonActionListener implements ActionListener{

    private final IzvodjacIzmeniPanel izvodjacIzmeniPanel;

    public IzvodjacPretraziPoKriterijumuButtonActionListener(IzvodjacIzmeniPanel izvodjacIzmeniPanel) {
        this.izvodjacIzmeniPanel = izvodjacIzmeniPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //uzima kriterijum i u zavisnosti od onoga sto je selektovano u combobox ispisuje se kriterijum
        String kriterijum = izvodjacIzmeniPanel.getSelektovanKriterijum();
        String zavrsniKriterikum = "";
        //moguci kriterijumi: idIzvodjac, ime, prezime, email, telefon, pol 
        if (kriterijum.equals("idIzvodjac")) {
            zavrsniKriterikum = "idIzvodjaca = " + izvodjacIzmeniPanel.getTxtKriterijum().getText();
        }
        if (kriterijum.equals("ime")) {
            zavrsniKriterikum = "ime LIKE '" + izvodjacIzmeniPanel.getTxtKriterijum().getText() + "%'";
        }
        if (kriterijum.equals("prezime")) {
            zavrsniKriterikum = "prezime LIKE '" + izvodjacIzmeniPanel.getTxtKriterijum().getText() + "%'";
        }
        if (kriterijum.equals("email")) {
            zavrsniKriterikum = "email LIKE '" + izvodjacIzmeniPanel.getTxtKriterijum().getText() + "%'";
        }
        if (kriterijum.equals("telefon")) {
            zavrsniKriterikum = "brojTelefona LIKE '" + izvodjacIzmeniPanel.getTxtKriterijum().getText() + "%'";
        }
        if (kriterijum.equals("pol")) {
            zavrsniKriterikum = "pol = '" + izvodjacIzmeniPanel.getTxtKriterijum().getText() + "'";
        }
        System.out.println("kriterijum: " + zavrsniKriterikum);
        try {
            applicationController.ApplicationController.getInstance()
                    .pretraziIzvodjacePoKriterijumu(zavrsniKriterikum);
        } catch (IOException ex) {
            Logger.getLogger(IzvodjacPretraziPoKriterijumuButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
