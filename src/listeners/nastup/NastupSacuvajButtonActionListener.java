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
import javax.swing.JOptionPane;
import model.Nastup;
import ui.components.iValue.product.NastupNoviPanel;

/**
 *
 * @author Aleksa
 */
public class NastupSacuvajButtonActionListener implements ActionListener{

    private final NastupNoviPanel nastupNoviPanel;

    public NastupSacuvajButtonActionListener(NastupNoviPanel nastupNoviPanel) {
        this.nastupNoviPanel = nastupNoviPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //treba implementirati rad JButton na panelu
        try {
            applicationController.ApplicationController
                    .getInstance()
                    .saveNastup((Nastup) nastupNoviPanel.getValue());
        } catch (IOException ioEx) {
            JOptionPane.showMessageDialog(nastupNoviPanel, "IO Exception when sending request object!");
            Logger.getLogger(NastupSacuvajButtonActionListener.class.getName()).log(Level.SEVERE, null, ioEx);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(nastupNoviPanel, "Bad Input, try again");
            System.out.println("exception:" + ex.getMessage());
        }
    }
    
}
