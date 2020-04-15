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
import model.Bend;
import ui.components.iValue.product.BendIzmeniPanel;
import ui.components.tableModel.BendTableModel;

/**
 *
 * @author Aleksa
 */
public class BendUcitajButtonActionListener implements ActionListener{

    private final BendIzmeniPanel bendIzmeniPanel;

    public BendUcitajButtonActionListener(BendIzmeniPanel bendIzmeniPanel) {
        this.bendIzmeniPanel = bendIzmeniPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //treba da posalje zahtev serveru da ocita selektovanog izvodjaca iz tabele
        int selectedRow = bendIzmeniPanel.getTabelaBendova().getSelectedRow();
        Bend bend = ((BendTableModel)bendIzmeniPanel.getTabelaBendova().getModel())
                .getBend(selectedRow);
        try {
            applicationController.ApplicationController.getInstance()
                    .ucitajBend(bend);
        } catch (IOException ex) {
            Logger.getLogger(BendUcitajButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
