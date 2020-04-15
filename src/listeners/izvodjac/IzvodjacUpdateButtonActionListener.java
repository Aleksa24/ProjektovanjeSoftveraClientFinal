/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.izvodjac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Izvodjac;
import ui.components.iValue.product.IzvodjacIzmeniPanel;

/**
 *
 * @author Aleksa
 */
public class IzvodjacUpdateButtonActionListener implements ActionListener{

    private final IzvodjacIzmeniPanel izvodjacIzmeniPanel;

    public IzvodjacUpdateButtonActionListener(IzvodjacIzmeniPanel izvodjacIzmeniPanel) {
        this.izvodjacIzmeniPanel = izvodjacIzmeniPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //ucitava izvodjacaZaUpdate sa panela i poziva appCon da odradi dalje
            applicationController.ApplicationController.getInstance()
                    .updateIzvodjac((Izvodjac)izvodjacIzmeniPanel.getValue());
        } catch (Exception ex) {
            Logger.getLogger(IzvodjacUpdateButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
