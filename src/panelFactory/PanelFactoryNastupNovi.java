/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelFactory;

import ui.components.iValue.product.NastupNoviPanel;

/**
 *
 * @author Aleksa
 */
public class PanelFactoryNastupNovi extends PanelFactory{

    @Override
    protected void createProduct() {
        this.product = new NastupNoviPanel();
    }
    
}
