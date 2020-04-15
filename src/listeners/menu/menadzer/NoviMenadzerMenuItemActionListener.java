/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.menu.menadzer;

import formControllers.MainFormController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import panelFactory.PanelFactoryMenadzerNew;

/**
 *
 * @author Aleksa
 */
public class NoviMenadzerMenuItemActionListener implements ActionListener {

    private MainFormController mainFormController;

    public NoviMenadzerMenuItemActionListener(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //postaviti MenadzerNewPanel 
        mainFormController.setPanelFactory(new PanelFactoryMenadzerNew());
        mainFormController.createPanel();
        mainFormController.addMenadzerNewPanelListeners();//ovde se i doda validator
    }

}
