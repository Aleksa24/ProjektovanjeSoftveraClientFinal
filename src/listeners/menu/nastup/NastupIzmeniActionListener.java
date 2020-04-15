/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.menu.nastup;

import formControllers.MainFormController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import panelFactory.PanelFactoryNastupIzmeni;

/**
 *
 * @author Aleksa
 */
public class NastupIzmeniActionListener implements ActionListener{

    private final MainFormController mainFormController;

    public NastupIzmeniActionListener(MainFormController mainFormController) {
        this.mainFormController = mainFormController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //postavlja NastupIzmeniPanel
        mainFormController.setPanelFactory(new PanelFactoryNastupIzmeni());
        mainFormController.createPanel();
        mainFormController.addNastupIzmeniListeners();//ovde se i doda validator
    }
    
}
