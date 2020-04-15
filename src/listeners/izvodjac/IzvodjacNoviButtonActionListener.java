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
import javax.swing.JOptionPane;
import model.Izvodjac;
import ui.components.iValue.product.IzvodjacNoviPanel;

/**
 *
 * @author Aleksa
 */
public class IzvodjacNoviButtonActionListener implements ActionListener{

    IzvodjacNoviPanel izvodjacNoviPanel;
    
    public IzvodjacNoviButtonActionListener(IzvodjacNoviPanel izvodjacNoviPanel) {
        this.izvodjacNoviPanel = izvodjacNoviPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //treba implementirati rad JButton na panelu
        try {
            applicationController.ApplicationController
                    .getInstance()
                    .saveOsobaIzvodjac((Izvodjac) izvodjacNoviPanel.getValue());
        } catch (IOException ioEx) {
            JOptionPane.showMessageDialog(izvodjacNoviPanel, "IO Exception when sending request object!");
            Logger.getLogger(IzvodjacNoviButtonActionListener.class.getName()).log(Level.SEVERE, null, ioEx);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(izvodjacNoviPanel, "Bad Input, try again");
            System.out.println("exception:" + ex.getMessage());
        }
    }
    
}
