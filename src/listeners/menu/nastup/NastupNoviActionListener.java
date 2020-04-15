/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.menu.nastup;

import formControllers.MainFormController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import panelFactory.PanelFactoryNastupNovi;

/**
 *
 * @author Aleksa
 */
public class NastupNoviActionListener implements ActionListener{

    private final MainFormController mainFormController;

    public NastupNoviActionListener(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //postavlja NastupNoviPanel
        mainFormController.setPanelFactory(new PanelFactoryNastupNovi());
        mainFormController.createPanel();
        mainFormController.addNastupNoviListeners();//ovde se i doda validator
    }
    
}
