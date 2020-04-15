/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.menu.izvodjac;

import formControllers.MainFormController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import panelFactory.PanelFactoryIzvodjacNovi;

/**
 *
 * @author Aleksa
 */
public class IzvodjacNoviMenuItemActionListener implements ActionListener{

    MainFormController mainFormController;
    
    public IzvodjacNoviMenuItemActionListener(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //postavlja IzvodjacNoviPanel
        mainFormController.setPanelFactory(new PanelFactoryIzvodjacNovi());
        mainFormController.createPanel();
        mainFormController.addIzvodjacNoviListeners();//ovde se i doda validator
    }
    
}
