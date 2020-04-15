/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.nastup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import listeners.izvodjac.IzvodjacUpdateButtonActionListener;
import model.Izvodjac;
import model.Nastup;
import ui.components.iValue.product.NastupIzmeniPanel;

/**
 *
 * @author Aleksa
 */
public class NastupUpdateButtonActionListener implements ActionListener {

    private final NastupIzmeniPanel nastupIzmeniPanel;

    public NastupUpdateButtonActionListener(NastupIzmeniPanel nastupIzmeniPanel) {
        this.nastupIzmeniPanel = nastupIzmeniPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //ucitava nastupZaUpdate sa panela i poziva appCon da odradi dalje
            applicationController.ApplicationController.getInstance()
                    .updateNastup((Nastup)nastupIzmeniPanel.getValue());
        } catch (Exception ex) {
            Logger.getLogger(NastupUpdateButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
