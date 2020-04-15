/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Menadzer;
import ui.components.iValue.product.LoginPanel;

/**
 * samo salje serveru login zahtev
 * @author Aleksa
 */
public class LoginButtonActionListener implements ActionListener{

    private LoginPanel loginPanel;

    public LoginButtonActionListener(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            applicationController.ApplicationController
                    .getInstance()
                    .loginUser((Menadzer)loginPanel.getValue());
        } catch (IOException ioEx) {
            JOptionPane.showMessageDialog(loginPanel, "IO Exception when sending request object!");
            Logger.getLogger(LoginButtonActionListener.class.getName()).log(Level.SEVERE, null, ioEx);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(loginPanel, "Bad Input, try again");
            Logger.getLogger(LoginButtonActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
