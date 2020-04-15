/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.menu.bend;

import formControllers.MainFormController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import panelFactory.PanelFactoryBendNovi;

/**
 *
 * @author Aleksa
 */
public class BendNoviMenuItemActionListener implements ActionListener{

    private final MainFormController mainFormController;

    public BendNoviMenuItemActionListener(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //postavlja BendNoviPanel
        mainFormController.setPanelFactory(new PanelFactoryBendNovi());
        mainFormController.createPanel();
        mainFormController.addBendNoviListeners();//ovde se i doda validator
    }
    
}
