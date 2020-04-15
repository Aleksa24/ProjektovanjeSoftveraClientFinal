/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formControllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import listeners.izvodjac.IzvodjacNoviButtonActionListener;
import listeners.login.LoginButtonActionListener;
import listeners.menadzer.SacuvajMenadzeraButtonActionListener;
import listeners.menu.Accaunt.LogInActrionListener;
import listeners.menu.Accaunt.LogOutActionListener;
import listeners.menu.izvodjac.IzvodjacIzmeniMenuItemActionListener;
import listeners.menu.izvodjac.IzvodjacNoviMenuItemActionListener;
import listeners.menu.menadzer.NoviMenadzerMenuItemActionListener;
import forms.mainForm.MainForm;
import listeners.bend.BendPretraziPoKriterijumuButtonActionListener;
import listeners.bend.BendSacuvajButtonActionListener;
import listeners.bend.BendUcitajButtonActionListener;
import listeners.bend.BendUpdateButtonActionListener;
import listeners.izvodjac.IzvodjacPretraziPoKriterijumuButtonActionListener;
import listeners.izvodjac.IzvodjacUcitajButtonActionListener;
import listeners.izvodjac.IzvodjacUpdateButtonActionListener;
import listeners.menu.bend.BendIzmeniMenuItemActionListener;
import listeners.menu.bend.BendNoviMenuItemActionListener;
import listeners.menu.nastup.NastupIzmeniActionListener;
import listeners.menu.nastup.NastupNoviActionListener;
import listeners.nastup.NastupPretraziPoKriterijumuButtonActionListener;
import listeners.nastup.NastupSacuvajButtonActionListener;
import listeners.nastup.NastupUcitajButtonActionListener;
import listeners.nastup.NastupUpdateButtonActionListener;
import panelFactory.PanelFactory;
import panelFactory.PanelFactoryDefaultPanel;
import ui.components.iValue.product.BendIzmeniPanel;
import ui.components.iValue.product.BendNoviPanel;
import ui.components.iValue.product.IzvodjacIzmeniPanel;
import ui.components.iValue.product.IzvodjacNoviPanel;
import ui.components.iValue.product.LoginPanel;
import ui.components.iValue.product.MenadzerNewPanel;
import ui.components.iValue.product.NastupIzmeniPanel;
import ui.components.iValue.product.NastupNoviPanel;
import vrednosniValidator.impl.VrednosniValidatorIndenticneSifre;

/**
 *
 * @author Aleksa
 */
public class MainFormController {
    private final MainForm mainForm;
    private PanelFactory panelFactory;

    public MainFormController() {
        this.mainForm = new MainForm();
        panelFactory = new PanelFactoryDefaultPanel();
        createPanel();
        setLogOutState();
    }

    public void start() {
        //stvari koje se dodaju na pocetku aplikacije
        mainForm.setVisible(true);
    }
    
    /**
     * poziva se kada korisnik nije ulogovan, mora da se izgase meniji i ostalo...
     */
    public void setLogOutState(){
        mainForm.getLogOUTMenuItem().setEnabled(false);
        mainForm.getMenadzerMenu().setEnabled(false);
        mainForm.getIzvodjacMenu().setEnabled(false);
        mainForm.getBendMenu().setEnabled(false);
        mainForm.getNastupMenu().setEnabled(false);
        mainForm.getLogINMenuItem().setEnabled(true);
        //dodati 
        
        //listeners:
        mainForm.getLogINMenuItem().addActionListener(new LogInActrionListener(this));
        
        //poruka
        mainForm.getNotificationsJTextArea().setText("Waiting for login user...");
        
        System.out.println("LOG OUT state set");
    }
    /**
     * poziva se kada se korisnik uloguje
     */
    public void setLogInState(){
        mainForm.getLogOUTMenuItem().setEnabled(true);
        mainForm.getMenadzerMenu().setEnabled(true);
        mainForm.getIzvodjacMenu().setEnabled(true);
        mainForm.getBendMenu().setEnabled(true);
        mainForm.getNastupMenu().setEnabled(true);
        mainForm.getLogINMenuItem().setEnabled(false);
        //dodati
        
        
        //listeners:
        mainForm.getLogOUTMenuItem().addActionListener(new LogOutActionListener(this));
        mainForm.getNoviMenadzerMenuItem().addActionListener(new NoviMenadzerMenuItemActionListener(this));
        mainForm.getIzovdjacNoviMenuItem().addActionListener(new IzvodjacNoviMenuItemActionListener(this));
        mainForm.getIzvodjacIzmeniMenuItem().addActionListener(new IzvodjacIzmeniMenuItemActionListener(this));
        mainForm.getBendNoviMenuItem().addActionListener(new BendNoviMenuItemActionListener(this));
        mainForm.getBendIzmeniMenuItem().addActionListener(new BendIzmeniMenuItemActionListener(this));
        mainForm.getNastupNoviMenuItem().addActionListener(new NastupNoviActionListener(this));
        mainForm.getNastupIzmeniMenuItem().addActionListener(new NastupIzmeniActionListener(this));
        System.out.println("LOG IN state set");
    }

    public void createPanel() {
        JPanel panel =  mainForm.getPanel();
        //sacuvajPanelDaBiVracaoUnazad(panel.getComponentAt(0));//dodati if ako je null
        panel.removeAll();
        
        if (panelFactory == null) {
            panelFactory = new PanelFactoryDefaultPanel();
            mainForm.printNotification("greska pri kreiranju panela");
        }
        panelFactory.create();
        JPanel product = (JPanel) panelFactory.getProduct();
//        product.setVisible(true);
        panel.add(product);
        mainForm.setPosition();
        panel.revalidate();//ovo ponovo iscrta,bez ovoga ne radi
    }

    public MainForm getMainForm() {
        return mainForm;
    }

    public void setPanelFactory(PanelFactory panelFactory) {
        this.panelFactory = panelFactory;
    }

    /**
     * dodaje listener na dugmetu na LoginPanel
     */
    public void addLoginPanelListeners() {
        LoginPanel loginPanel = (LoginPanel) mainForm.getProduct();
        loginPanel.getBtnLogin().addActionListener(new LoginButtonActionListener(loginPanel));
    }
    public void printNotification(String notification){
        this.mainForm.printNotification(notification);
    }

    /**
     * dodaje listener na JButton i dodaje validator za panel koji proveraca da li su sifre iste
     */
    public void addMenadzerNewPanelListeners() {
        MenadzerNewPanel menadzerNewPanel = (MenadzerNewPanel) mainForm.getProduct();
        menadzerNewPanel.setValidator(new VrednosniValidatorIndenticneSifre(menadzerNewPanel));
        menadzerNewPanel.getBtnSacuvajMenadzera().addActionListener(new SacuvajMenadzeraButtonActionListener(menadzerNewPanel));
    }

    /**
     * -poziva applicationcontroller da zatrazi od servera listu VrstaIzvodjaca
     * -potencijalno postavlja validator ako treba
     * -postavlja listener na button
     */
    public void addIzvodjacNoviListeners() {
        try {
            applicationController.ApplicationController.getInstance()
                    .ucitajListuVrstaIzvodjaca();
        } catch (IOException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        IzvodjacNoviPanel izvodjacNoviPanel = (IzvodjacNoviPanel) mainForm.getProduct();
//        izvodjacNoviPanel.setValidator(new VrednosniValidatorIzvodjacNovi(izvodjacNoviPanel));
        izvodjacNoviPanel.getBtnSacuvajIzvodjaca()
                .addActionListener(new IzvodjacNoviButtonActionListener(izvodjacNoviPanel));
    }

    public void addIzvodjacIzmeniListeners() {
        IzvodjacIzmeniPanel izvodjacIzmeniPanel = (IzvodjacIzmeniPanel) mainForm.getProduct();
        //treba da Posalje zahtev serveru da mu vrati listu VrstaIzvodjaca,
        try {
            applicationController.ApplicationController.getInstance()
                    .ucitajListuVrstaIzvodjaca();
        } catch (IOException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //treba da doda listener za button:kriterijum,ucitaj,update
        izvodjacIzmeniPanel.getBtnPretraziPoKriterijumu()
                .addActionListener(new IzvodjacPretraziPoKriterijumuButtonActionListener(izvodjacIzmeniPanel));
        izvodjacIzmeniPanel.getBtnUcitaj()
                .addActionListener(new IzvodjacUcitajButtonActionListener(izvodjacIzmeniPanel));
        izvodjacIzmeniPanel.getBtnUpdate()
                .addActionListener(new IzvodjacUpdateButtonActionListener(izvodjacIzmeniPanel));
    }

    public void addBendNoviListeners() {
        BendNoviPanel bendNoviPanel = (BendNoviPanel) mainForm.getProduct();
        //treba da se posalje zahtev da se ucitaju svi Izvodjaci
        try {
            applicationController.ApplicationController.getInstance()
                    .ucitajListuIzvodjaca();
        } catch (IOException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //treba da doda lisenere na panel
        bendNoviPanel.getBtnSacuvajBend()
                .addActionListener(new BendSacuvajButtonActionListener(bendNoviPanel));
    }

    public void addBendIzmeniListeners() {
        //treba da se posalje zahtev da se ucitaju svi Izvodjaci
        BendIzmeniPanel bendIzmeniPanel = (BendIzmeniPanel) mainForm.getProduct();
        try {
            applicationController.ApplicationController.getInstance()
                    .ucitajListuIzvodjaca();
        } catch (IOException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //treba da doda lisenere na panel
        bendIzmeniPanel.getBtnPretraziPoKriterijumu()
                .addActionListener(new BendPretraziPoKriterijumuButtonActionListener(bendIzmeniPanel));
        bendIzmeniPanel.getBtnUcitaj()
                .addActionListener(new BendUcitajButtonActionListener(bendIzmeniPanel));
        bendIzmeniPanel.getBtnUpdate()
                .addActionListener(new BendUpdateButtonActionListener(bendIzmeniPanel));
    }

    public void addNastupNoviListeners() {
        NastupNoviPanel nastupNoviPanel = (NastupNoviPanel) mainForm.getProduct();
        //treba da se posalje zahtev da se ucitaju svi Izvodjaci i svi bendovi
        try {
            applicationController.ApplicationController.getInstance()
                    .ucitajListuIzvodjaca();
            applicationController.ApplicationController.getInstance()
                    .ucitajListuBendova();
        } catch (IOException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //treba da doda lisenere na panel
        nastupNoviPanel.getBrnSacuvaj()
                .addActionListener(new NastupSacuvajButtonActionListener(nastupNoviPanel));
    }

    public void addNastupIzmeniListeners() {
        NastupIzmeniPanel nastupIzmeniPanel = (NastupIzmeniPanel) mainForm.getProduct();
        //treba da se posalje zahtev da se ucitaju svi Izvodjaci i svi bendovi
        try {
            applicationController.ApplicationController.getInstance()
                    .ucitajListuIzvodjaca();
            applicationController.ApplicationController.getInstance()
                    .ucitajListuBendova();
        } catch (IOException ex) {
            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //dodaje lisenere na dugmice
        nastupIzmeniPanel.getBtnPretraziPoKriterijumu()
                .addActionListener(new NastupPretraziPoKriterijumuButtonActionListener(nastupIzmeniPanel));
        nastupIzmeniPanel.getBtnUcitaj()
                .addActionListener(new NastupUcitajButtonActionListener(nastupIzmeniPanel));
        nastupIzmeniPanel.getBtnUpdate()
                .addActionListener(new NastupUpdateButtonActionListener(nastupIzmeniPanel));
    }
    
    
}
