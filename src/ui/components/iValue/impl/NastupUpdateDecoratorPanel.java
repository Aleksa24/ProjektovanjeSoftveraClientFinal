/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.iValue.impl;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import model.Nastup;
import ui.components.iValue.IValue;
import ui.components.iValue.product.NastupNoviPanel;
import vrednosniValidator.VrednosniValidator;
import vrednosniValidator.impl.VrednosniValidatorDefault;

/**
 *
 * @author Aleksa
 */
public class NastupUpdateDecoratorPanel extends javax.swing.JPanel implements IValue{

    vrednosniValidator.VrednosniValidator validator;
    
    /**
     * Creates new form NazsupUpdateDecoratorPanel
     */
    public NastupUpdateDecoratorPanel() {
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

        nastupNoviPanel1 = new ui.components.iValue.product.NastupNoviPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nastupNoviPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nastupNoviPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.components.iValue.product.NastupNoviPanel nastupNoviPanel1;
    // End of variables declaration//GEN-END:variables

    public NastupNoviPanel getProduct(){
        return nastupNoviPanel1;
    }
    public JButton getBtnUpdate(){
        return nastupNoviPanel1.getBtnSacuvajIzvodjaca();
    }

    private void preparePanel() {
        nastupNoviPanel1.getBtnSacuvajIzvodjaca().setText("Update");
    }

    @Override
    public Object getValue() throws Exception {
        //dodaje id da bi mogao da preko njega da radi update
        return ((Nastup)nastupNoviPanel1.getValue())
                .appendIdNastupa(nastupNoviPanel1.getIdNastupa());
    }

    /**
     * ubacuje Nasutp u panel
     * @param value 
     */
    @Override
    public void setValue(Object value) {
        nastupNoviPanel1.setValue(value);
    }

    /**
     * popunjava combobox sa izvodjacima/bendovima
     * @param initValue trebalo bi da bude List<DomainObject>
     */
    @Override
    public void inicialize(Object initValue) {
        this.nastupNoviPanel1.dodajListuIzvodjacaBendova(initValue);
    }

    @Override
    public void setValidator(VrednosniValidator validator) {
        nastupNoviPanel1.setValidator(validator);
    }
}