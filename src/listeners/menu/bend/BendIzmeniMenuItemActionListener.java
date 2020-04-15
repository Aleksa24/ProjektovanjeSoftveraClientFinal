/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.menu.bend;

import formControllers.MainFormController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import panelFactory.PanelFactoryBendIzmeni;

/**
 *
 * @author Aleksa
 */
public class BendIzmeniMenuItemActionListener implements ActionListener{

    private final MainFormController mainFormController;

    public BendIzmeniMenuItemActionListener(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //postavlja BendIzmeniPanel
        mainFormController.setPanelFactory(new PanelFactoryBendIzmeni());
        mainFormController.createPanel();
        mainFormController.addBendIzmeniListeners();//ovde se i doda validator
    }
    
}
