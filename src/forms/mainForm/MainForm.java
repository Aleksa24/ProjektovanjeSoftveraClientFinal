/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.mainForm;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Aleksa
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        prepareForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        southPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificationsJTextArea = new javax.swing.JTextArea();
        panel = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        AccauntMenu = new javax.swing.JMenu();
        LogINMenuItem = new javax.swing.JMenuItem();
        LogOUTMenuItem = new javax.swing.JMenuItem();
        MenadzerMenu = new javax.swing.JMenu();
        NoviMenadzerMenuItem = new javax.swing.JMenuItem();
        IzvodjacMenu = new javax.swing.JMenu();
        IzovdjacNoviMenuItem = new javax.swing.JMenuItem();
        IzvodjacIzmeniMenuItem = new javax.swing.JMenuItem();
        BendMenu = new javax.swing.JMenu();
        BendNoviMenuItem = new javax.swing.JMenuItem();
        BendIzmeniMenuItem = new javax.swing.JMenuItem();
        NastupMenu = new javax.swing.JMenu();
        NastupNoviMenuItem = new javax.swing.JMenuItem();
        NastupIzmeniMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Notifications:");

        notificationsJTextArea.setColumns(20);
        notificationsJTextArea.setRows(5);
        jScrollPane1.setViewportView(notificationsJTextArea);

        javax.swing.GroupLayout southPanelLayout = new javax.swing.GroupLayout(southPanel);
        southPanel.setLayout(southPanelLayout);
        southPanelLayout.setHorizontalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE))
                .addContainerGap())
        );
        southPanelLayout.setVerticalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(southPanel, java.awt.BorderLayout.PAGE_END);

        panel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        AccauntMenu.setText("Accaunt");

        LogINMenuItem.setText("Log In");
        AccauntMenu.add(LogINMenuItem);

        LogOUTMenuItem.setText("Log Out");
        AccauntMenu.add(LogOUTMenuItem);

        MenuBar.add(AccauntMenu);

        MenadzerMenu.setText("Menadzer");

        NoviMenadzerMenuItem.setText("Novi Menadzer");
        MenadzerMenu.add(NoviMenadzerMenuItem);

        MenuBar.add(MenadzerMenu);

        IzvodjacMenu.setText("Izvodjac");

        IzovdjacNoviMenuItem.setText("Novi Izvodjac");
        IzvodjacMenu.add(IzovdjacNoviMenuItem);

        IzvodjacIzmeniMenuItem.setText("Izmeni Izvodjaca");
        IzvodjacMenu.add(IzvodjacIzmeniMenuItem);

        MenuBar.add(IzvodjacMenu);

        BendMenu.setText("Bend");

        BendNoviMenuItem.setText("Novi Bend");
        BendMenu.add(BendNoviMenuItem);

        BendIzmeniMenuItem.setText("Izmeni Bend");
        BendMenu.add(BendIzmeniMenuItem);

        MenuBar.add(BendMenu);

        NastupMenu.setText(" Nastup");

        NastupNoviMenuItem.setText("Novi nastup");
        NastupMenu.add(NastupNoviMenuItem);

        NastupIzmeniMenuItem.setText("Izmeni nastup");
        NastupMenu.add(NastupIzmeniMenuItem);

        MenuBar.add(NastupMenu);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AccauntMenu;
    private javax.swing.JMenuItem BendIzmeniMenuItem;
    private javax.swing.JMenu BendMenu;
    private javax.swing.JMenuItem BendNoviMenuItem;
    private javax.swing.JMenuItem IzovdjacNoviMenuItem;
    private javax.swing.JMenuItem IzvodjacIzmeniMenuItem;
    private javax.swing.JMenu IzvodjacMenu;
    private javax.swing.JMenuItem LogINMenuItem;
    private javax.swing.JMenuItem LogOUTMenuItem;
    private javax.swing.JMenu MenadzerMenu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem NastupIzmeniMenuItem;
    private javax.swing.JMenu NastupMenu;
    private javax.swing.JMenuItem NastupNoviMenuItem;
    private javax.swing.JMenuItem NoviMenadzerMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea notificationsJTextArea;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel southPanel;
    // End of variables declaration//GEN-END:variables

    
    
    
    public JMenu getAccauntMenu() {
        return AccauntMenu;
    }

    public JMenuItem getLogINMenuItem() {
        return LogINMenuItem;
    }

    public JMenuItem getLogOUTMenuItem() {
        return LogOUTMenuItem;
    }

    public JMenu getMenadzerMenu() {
        return MenadzerMenu;
    }

    public JMenuItem getNoviMenadzerMenuItem() {
        return NoviMenadzerMenuItem;
    }

    public JTextArea getNotificationsJTextArea() {
        return notificationsJTextArea;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void printNotification(String poruka) {
        this.notificationsJTextArea.append("\n"+poruka);
    }

    private void prepareForm() {
        this.notificationsJTextArea.setEnabled(false);

    }

    public void setPosition() {
        this.setBounds(300, 50, 1000, 980);
        
    }

    public JPanel getProduct() {
        return (JPanel) panel.getComponent(0);
    }

    public javax.swing.JMenuItem getIzovdjacNoviMenuItem() {
        return IzovdjacNoviMenuItem;
    }

    public javax.swing.JMenuItem getIzvodjacIzmeniMenuItem() {
        return IzvodjacIzmeniMenuItem;
    }

    public javax.swing.JMenu getIzvodjacMenu() {
        return IzvodjacMenu;
    }

    public JMenuItem getBendIzmeniMenuItem() {
        return BendIzmeniMenuItem;
    }

    public JMenu getBendMenu() {
        return BendMenu;
    }

    public JMenuItem getBendNoviMenuItem() {
        return BendNoviMenuItem;
    }

    public JMenuItem getNastupIzmeniMenuItem() {
        return NastupIzmeniMenuItem;
    }

    public JMenu getNastupMenu() {
        return NastupMenu;
    }

    public JMenuItem getNastupNoviMenuItem() {
        return NastupNoviMenuItem;
    }
    
    
}