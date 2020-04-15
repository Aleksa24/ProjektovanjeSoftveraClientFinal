/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.menadzer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Menadzer;
import ui.components.iValue.product.MenadzerNewPanel;

/**
 *
 * @author Aleksa
 */
public class SacuvajMenadzeraButtonActionListener implements ActionListener{

    private MenadzerNewPanel menadzerNewPanel;
    
    public SacuvajMenadzeraButtonActionListener(MenadzerNewPanel menadzerNewPanel) {
        this.menadzerNewPanel = menadzerNewPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            applicationController.ApplicationController
                    .getInstance()
                    .saveMenadzer((Menadzer)menadzerNewPanel.getValue());
        } catch (IOException ioEx) {
            JOptionPane.showMessageDialog(menadzerNewPanel, "IO Exception when sending request object!");
            Logger.getLogger(SacuvajMenadzeraButtonActionListener.class.getName()).log(Level.SEVERE, null, ioEx);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(menadzerNewPanel, "Bad Input, try again");
            System.out.println("exception:" + ex.getMessage());
        }
    }
    
}
