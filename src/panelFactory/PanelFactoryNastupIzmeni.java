/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelFactory;

import ui.components.iValue.product.NastupIzmeniPanel;

/**
 *
 * @author Aleksa
 */
public class PanelFactoryNastupIzmeni extends PanelFactory{

    @Override
    protected void createProduct() {
        product = new NastupIzmeniPanel();
    }
    
}
