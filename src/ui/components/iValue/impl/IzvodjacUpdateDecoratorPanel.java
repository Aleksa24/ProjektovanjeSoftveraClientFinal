/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.iValue.impl;

import java.util.List;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import model.Izvodjac;
import ui.components.iValue.IValue;
import ui.components.iValue.product.IzvodjacNoviPanel;
import vrednosniValidator.VrednosniValidator;
import vrednosniValidator.impl.VrednosniValidatorDefault;

/**
 *
 * @author Aleksa
 */
public class IzvodjacUpdateDecoratorPanel extends javax.swing.JPanel implements IValue{

    vrednosniValidator.VrednosniValidator validator;
    
    /**
     * Creates new form IzvodjacUpdateDecoratorPanel
     */
    public IzvodjacUpdateDecoratorPanel() {
        initComponents();
        preparePanel();
        validator = new VrednosniValidatorDefault();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        izvodjacNoviPanel = new ui.components.iValue.product.IzvodjacNoviPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(izvodjacNoviPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(izvodjacNoviPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.components.iValue.product.IzvodjacNoviPanel izvodjacNoviPanel;
    // End of variables declaration//GEN-END:variables

    public IzvodjacNoviPanel getProduct(){
        return izvodjacNoviPanel;
    }
    public JButton getBtnUpdate(){
        return izvodjacNoviPanel.getBtnSacuvajIzvodjaca();
    }

    private void preparePanel() {
        TitledBorder border = (TitledBorder) izvodjacNoviPanel.getBorder();
        border.setTitle("Update Izvodjac");
        izvodjacNoviPanel.getBtnSacuvajIzvodjaca().setText("Update");
    }

    @Override
    public Object getValue() throws Exception {
        //dodaje id da bi mogao da preko njega da radi update
        return ((Izvodjac)izvodjacNoviPanel.getValue())
                .appendIdIzvodjac(izvodjacNoviPanel.getIdIzvodjaca());
    }

    @Override
    public void setValue(Object value) {
        izvodjacNoviPanel.setValue(value);
    }

    /**
     * popunjava combobox
     * @param initValue trebalo bi da bude List<Izvodjac>
     */
    @Override
    public void inicialize(Object initValue) {
        this.izvodjacNoviPanel.getVrstaIzvodjacaPanel().inicialize(initValue);
    }

    @Override
    public void setValidator(VrednosniValidator validator) {
        izvodjacNoviPanel.setValidator(validator);
    }
}
