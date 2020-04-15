/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.bend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.components.iValue.product.BendIzmeniPanel;

/**
 *
 * @author Aleksa
 */
public class BendPretraziPoKriterijumuButtonActionListener implements ActionListener{

    private final BendIzmeniPanel bendIzmeniPanel;

    public BendPretraziPoKriterijumuButtonActionListener(BendIzmeniPanel bendIzmeniPanel) {
        this.bendIzmeniPanel = bendIzmeniPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //uzima kriterijum i u zavisnosti od onoga sto je selektovano u combobox ispisuje se kriterijum
        String kriterijum = bendIzmeniPanel.getSelektovanKriterijum();
        String zavrsniKriterikum = "";
        //moguci kriterijumi: ID, naziv benda, email, telefon 
        if (kriterijum.equals("ID")) {
            zavrsniKriterikum = "idIzvodjaca = " + bendIzmeniPanel.getTxtKriterijum().getText();
        }
        if (kriterijum.equals("naziv benda")) {
            zavrsniKriterikum = "nazivBenda LIKE '" + bendIzmeniPanel.getTxtKriterijum().getText() + "%'";
        }
        if (kriterijum.equals("email")) {
            zavrsniKriterikum = "email LIKE '" + bendIzmeniPanel.getTxtKriterijum().getText() + "%'";
        }
        if (kriterijum.equals("telefon")) {
            zavrsniKriterikum = "brojTelefona LIKE '" + bendIzmeniPanel.getTxtKriterijum().getText() + "%'";
        }
        System.out.println("kriterijum: " + zavrsniKriterikum);
        try {
            applicationController.ApplicationController.getInstance()
                    .pretraziBendovePoKriterijumu(zavrsniKriterikum);
        } catch (IOException ex) {
            Logger.getLogger(BendPretraziPoKriterijumuButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
