/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.bend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bend;
import ui.components.iValue.product.BendIzmeniPanel;

/**
 *
 * @author Aleksa
 */
public class BendUpdateButtonActionListener implements ActionListener{

    private final BendIzmeniPanel bendIzmeniPanel;

    public BendUpdateButtonActionListener(BendIzmeniPanel bendIzmeniPanel) {
        this.bendIzmeniPanel = bendIzmeniPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //ucitava bendZaUpdate sa panela i poziva appCon da odradi dalje
            applicationController.ApplicationController.getInstance()
                    .updateBend((Bend)bendIzmeniPanel.getValue());
        } catch (Exception ex) {
            Logger.getLogger(BendUpdateButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
