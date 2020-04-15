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
import ui.components.iValue.product.BendNoviPanel;

/**
 *
 * @author Aleksa
 */
public class BendSacuvajButtonActionListener implements ActionListener{

    private final BendNoviPanel bendNoviPanel;

    public BendSacuvajButtonActionListener(BendNoviPanel bendNoviPanel) {
        this.bendNoviPanel = bendNoviPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //salje zahtev serveru da sacuva Bend
            applicationController.ApplicationController.getInstance()
                    .zapamtiBend((Bend)bendNoviPanel.getValue());
        } catch (Exception ex) {
            Logger.getLogger(BendSacuvajButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
