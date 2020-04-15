/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.menu.Accaunt;

import formControllers.MainFormController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksa
 */
public class LogOutActionListener implements ActionListener{

    private MainFormController mainFormController;
    
    public LogOutActionListener(MainFormController con) {
        mainFormController = con;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            applicationController.ApplicationController.getInstance().logoutMenadzer();
        } catch (IOException ex) {
            Logger.getLogger(LogOutActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
