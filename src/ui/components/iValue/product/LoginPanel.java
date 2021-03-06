/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.iValue.product;

import javax.swing.JButton;
import model.Menadzer;
import ui.components.iValue.IValue;
import vrednosniValidator.VrednosniValidator;
import vrednosniValidator.impl.VrednosniValidatorDefault;

/**
 *
 * @author Aleksa
 */
public class LoginPanel extends javax.swing.JPanel implements IValue{

    private VrednosniValidator validator;
    
    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
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

        username = new ui.components.iValue.impl.InputPanelTextField();
        password = new ui.components.iValue.impl.InputPanelPassword();
        btnLogin = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        btnLogin.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private ui.components.iValue.impl.InputPanelPassword password;
    private ui.components.iValue.impl.InputPanelTextField username;
    // End of variables declaration//GEN-END:variables

    /**
     * 
     * @return Menadzera samo sa username i password
     * @throws Exception govori koja se greska desila prilikom uzimanja vrednosti
     */
    @Override
    public Object getValue() throws Exception {
        validator.validate();
        return Menadzer.menadzerLoginFactory(
                (String) this.username.getValue(),
                (String) this.password.getValue());
    }

    /**
     * dobije se Menadzer za koga se ispise username i password
     * @param value 
     */
    @Override
    public void setValue(Object value) {
        Menadzer menadzer = (Menadzer) value;
        this.username.setValue(menadzer.getUsername());
        this.password.setValue(menadzer.getPassword());
    }

    /**
     * popunjava sa pocetnim tekstom
     * @param initValue 
     */
    @Override
    public void inicialize(Object initValue) {
        this.username.setValue("type your username");
        this.password.setValue("type your password");
    }

    @Override
    public void setValidator(VrednosniValidator validator) {
        this.validator = validator;
    }

    private void preparePanel() {
        username.getJlabText().setText("Username:");
        username.getJlabError().setText("");
        username.getJtxtInput().setText("");
        password.getJlabText().setText("Password:");
        password.getJlabError().setText("");
        password.getJpassword().setText("");
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }
}
