/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.nastup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import listeners.izvodjac.IzvodjacPretraziPoKriterijumuButtonActionListener;
import ui.components.iValue.product.NastupIzmeniPanel;

/**
 *
 * @author Aleksa
 */
public class NastupPretraziPoKriterijumuButtonActionListener implements ActionListener{

    private final NastupIzmeniPanel nastupIzmeniPanel;

    public NastupPretraziPoKriterijumuButtonActionListener(NastupIzmeniPanel nastupIzmeniPanel) {
        this.nastupIzmeniPanel = nastupIzmeniPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //uzima kriterijum i u zavisnosti od onoga sto je selektovano u combobox ispisuje se kriterijum
        String kriterijum = nastupIzmeniPanel.getSelektovanKriterijum();
        String zavrsniKriterikum = "";
        //moguci kriterijumi: idNastupa, nazivNastupa, opis, lokacija 
        if (kriterijum.equals("idNastupa")) {
            zavrsniKriterikum = "idNastupa = " + nastupIzmeniPanel.getTxtKriterijum().getText();
        }
        if (kriterijum.equals("nazivNastupa")) {
            zavrsniKriterikum = "nazivNastupa LIKE '" + nastupIzmeniPanel.getTxtKriterijum().getText() + "%'";
        }
        if (kriterijum.equals("opis")) {
            zavrsniKriterikum = "opis LIKE '" + nastupIzmeniPanel.getTxtKriterijum().getText() + "%'";
        }
        if (kriterijum.equals("lokacija")) {
            zavrsniKriterikum = "lokacija LIKE '" + nastupIzmeniPanel.getTxtKriterijum().getText() + "%'";
        }
        System.out.println("kriterijum: " + zavrsniKriterikum);
        try {
            applicationController.ApplicationController.getInstance()
                    .pretraziNastupePoKriterijumu(zavrsniKriterikum);
        } catch (IOException ex) {
            Logger.getLogger(NastupPretraziPoKriterijumuButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
