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
import model.Izvodjac;
import ui.components.iValue.product.IzvodjacIzmeniPanel;
import ui.components.tableModel.IzvodjaciTableModel;

/**
 *
 * @author Aleksa
 */
public class IzvodjacUcitajButtonActionListener implements ActionListener{

    private final IzvodjacIzmeniPanel izvodjacIzmeniPanel;

    public IzvodjacUcitajButtonActionListener(IzvodjacIzmeniPanel izvodjacIzmeniPanel) {
        this.izvodjacIzmeniPanel = izvodjacIzmeniPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //treba da posalje zahtev serveru da ocita selektovanog izvodjaca iz tabele
        int selectedRow = izvodjacIzmeniPanel.getTabelaIzvodjaca().getSelectedRow();
        Izvodjac izvodjac = ((IzvodjaciTableModel)izvodjacIzmeniPanel.getTabelaIzvodjaca().getModel())
                .getIzvodjac(selectedRow);
        try {
            applicationController.ApplicationController.getInstance()
                    .ucitajIzvodjaca(izvodjac);
        } catch (IOException ex) {
            Logger.getLogger(IzvodjacUcitajButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
