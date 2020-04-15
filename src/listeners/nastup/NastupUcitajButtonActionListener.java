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
import listeners.izvodjac.IzvodjacUcitajButtonActionListener;
import model.Izvodjac;
import model.Nastup;
import ui.components.iValue.product.NastupIzmeniPanel;
import ui.components.tableModel.IzvodjaciTableModel;
import ui.components.tableModel.NastupTableModel;

/**
 *
 * @author Aleksa
 */
public class NastupUcitajButtonActionListener implements ActionListener{

    private final NastupIzmeniPanel nastupIzmeniPanel;

    public NastupUcitajButtonActionListener(NastupIzmeniPanel nastupIzmeniPanel) {
        this.nastupIzmeniPanel = nastupIzmeniPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //treba da posalje zahtev serveru da ocita selektovanog izvodjaca iz tabele
        int selectedRow = nastupIzmeniPanel.getTabelaNastupa().getSelectedRow();
        Nastup nastup = ((NastupTableModel)nastupIzmeniPanel.getTabelaNastupa().getModel())
                .getNastup(selectedRow);
        try {
            applicationController.ApplicationController.getInstance()
                    .ucitajNastup(nastup);
        } catch (IOException ex) {
            Logger.getLogger(NastupUcitajButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
