/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.menu.izvodjac;

import formControllers.MainFormController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import panelFactory.PanelFactoryIzvodjacIzmeniPanel;

/**
 *
 * @author Aleksa
 */
public class IzvodjacIzmeniMenuItemActionListener implements ActionListener{

    MainFormController mainFormController;
    
    public IzvodjacIzmeniMenuItemActionListener(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //postavlja IzvodjacIzmeniPanel
        mainFormController.setPanelFactory(new PanelFactoryIzvodjacIzmeniPanel());
        mainFormController.createPanel();
        mainFormController.addIzvodjacIzmeniListeners();//ovde se i doda validator
    }
    
}
