/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.menu.Accaunt;

import formControllers.MainFormController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import panelFactory.PanelFactoryLoginPanel;

/**
 * 
 * @author Aleksa
 * 
 */
public class LogInActrionListener implements ActionListener{

    private final MainFormController mainFormController;

    public LogInActrionListener(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       //postaviti LoginPanel 
       mainFormController.setPanelFactory(new PanelFactoryLoginPanel());
       mainFormController.createPanel();
       mainFormController.addLoginPanelListeners();
    }
    
}
