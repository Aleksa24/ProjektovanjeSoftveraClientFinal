/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import applicationController.ApplicationController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import forms.mainForm.MainForm;
import model.Bend;
import model.Izvodjac;
import model.Menadzer;
import model.Nastup;
import model.VrstaIzvodjaca;
import transfer.ResponseObject;
import util.ResponseStatus;

/**
 * nit ce da gadja panel koji joj treba i njemu da ubacuje podatke, usput moze
 * da prima poruke sa servera, sve radi asinhrono
 *
 * @author Aleksa
 */
public class NitZaPrimanjePoruka extends Thread {

    private static NitZaPrimanjePoruka instance;
    //-------
    private MainForm mainForm;
    private Socket socket;
    private ObjectInputStream objectInputStream;

    private NitZaPrimanjePoruka() {
        objectInputStream = null;
    }

    @Override
    public void run() {
        super.run();
        this.mainForm = applicationController.ApplicationController
                .getInstance()
                .getMainFormController()
                .getMainForm();

        while (objectInputStream == null) { //spava dok ne se ne dobije input stream           
            try {
                System.out.println("nit spava 3 sekunde, objectinputstream = " + objectInputStream);
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitZaPrimanjePoruka.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //primati poruke ovde
        while (!socket.isClosed()) {
            System.out.println("NitZaPrimanjePoruka je spremna da prima poruke!!!");
            try {
                ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();
                ResponseStatus status = responseObject.getStatus();
                switch (status) {
                    case SUCCESS_LOGIN: {
                        ApplicationController.getInstance()
                                .handleSuccesLogin((Menadzer) responseObject.getData());
                        break;
                    }
                    case SUCCESS_LOGOUT_MENADZER: {
                        ApplicationController.getInstance()
                                .handleSuccesLogOUT();
                        break;
                    }
                    case FAIL_LOGIN: {
                        ApplicationController.getInstance()
                                .failedLogin();
                        break;
                    }
                    case SUCCESS_SAVE_MENADZER: {
                        ApplicationController.getInstance()
                                .successSaveMenadzer((Menadzer)responseObject.getData());
                        break;
                    }
                    case SUCCESS_GET_ALL_VRSTAIZVODJACA: {
                        ApplicationController.getInstance()
                                .successGetAllVrstaIzvodjaca((List<VrstaIzvodjaca>)responseObject.getData());
                        break;
                    }
                    case SUCCESS_SAVE_IZVODJAC: {
                        ApplicationController.getInstance()
                                .successSaveIzvodjac((Izvodjac)responseObject.getData());
                        break;
                    }
                    case SUCCESS_PRETRAZIVANJE_PO_KRITERIJUMU: {
                        ApplicationController.getInstance()
                                .successPretrazivanjePoKriterijumu((List<Izvodjac>)responseObject.getData());
                        break;
                    }
                    case SUCCESS_UCITAJ_IZVODJACA: {
                        ApplicationController.getInstance()
                                .successUcitajIzvodjaca((Izvodjac)responseObject.getData());
                        break;
                    }
                    case SUCCESS_UCITAJ_BEND: {
                        ApplicationController.getInstance()
                                .successUcitajBend((Bend)responseObject.getData());
                        break;
                    }
                    case SUCCESS_UPDATE_IZVODJACA: {
                        ApplicationController.getInstance()
                                .successUpdateIzvodjaca((Izvodjac)responseObject.getData());
                        break;
                    }
                    case SUCCESS_UPDATE_BEND: {
                        ApplicationController.getInstance()
                                .successUpdateBend((Bend)responseObject.getData());
                        break;
                    }
                    case SUCCESS_UCITAJ_LISTU_IZVODJACA: {
                        ApplicationController.getInstance()
                                .successUcitajListuIzvodjaca((List<Izvodjac>)responseObject.getData());
                        break;
                    }
                    case SUCCESS_ZAPAMTI_BEND: {
                        ApplicationController.getInstance()
                                .successZapamtiBend((Bend)responseObject.getData());
                        break;
                    }
                    case SUCCESS_PRETRAZIVANJE_PO_KRITERIJUMU_BEND: {
                        ApplicationController.getInstance()
                                .successPretrazivanjePoKriterijumuBend((List<Bend>)responseObject.getData());
                        break;
                    }
                    case SUCCESS_PRETRAZIVANJE_PO_KRITERIJUMU_NASTUP: {
                        ApplicationController.getInstance()
                                .successPretrazivanjePoKriterijumuNastup((List<Nastup>)responseObject.getData());
                        break;
                    }
                    case SUCCESS_UCITAJ_LISTU_BENDOVA: {
                        ApplicationController.getInstance()
                                .successUcitajListuBendova((List<Bend>)responseObject.getData());
                        break;
                    }
                    case SUCCESS_ZAPAMTI_NASTUP: {
                        ApplicationController.getInstance()
                                .successZapamtuNastup((Nastup)responseObject.getData());
                        break;
                    }
                    case SUCCESS_UCITAJ_NASTUP: {
                        ApplicationController.getInstance()
                                .successUcitajNastup((Nastup)responseObject.getData());
                        break;
                    }
                    case SUCCESS_UPDATE_NASTUP: {
                        ApplicationController.getInstance()
                                .successUpdateNastup((Nastup)responseObject.getData());
                        break;
                    }
                    case ERROR: {
                        this.mainForm.printNotification("ERROR: " + responseObject.getErrorMessage());
                        break;
                    }
                    case ERROR_SAVE_MENADZER: {
                        this.mainForm.printNotification("ERROR: Sistem ne moze da zapamti nalog menadzera");
                        JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da zapamti nalog menadzera");
                        break;
                    }
                    case ERROR_SAVE_IZVODJAC: {
                        this.mainForm.printNotification("ERROR: Sistem ne moze da zapamti izvodjaca");
                        JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da zapamti izvodjaca");
                        break;
                    }
                    case ERROR_PRETRAZIVANJE_PO_KRITERIJUMU: {
                        this.mainForm.printNotification("ERROR: " + responseObject.getErrorMessage());
                        JOptionPane.showMessageDialog(mainForm, responseObject.getErrorMessage());
                        break;
                    }
                    case ERROR_PRETRAZIVANJE_PO_KRITERIJUMU_BEND: {
                        this.mainForm.printNotification("ERROR: " + responseObject.getErrorMessage());
                        JOptionPane.showMessageDialog(mainForm, responseObject.getErrorMessage());
                        break;
                    }
                    case ERROR_PRETRAZIVANJE_PO_KRITERIJUMU_NASTUP: {
                        this.mainForm.printNotification("ERROR: " + responseObject.getErrorMessage());
                        JOptionPane.showMessageDialog(mainForm, responseObject.getErrorMessage());
                        break;
                    }
                    case ERROR_UCITAJ_IZVODJACA: {
                        this.mainForm.printNotification("ERROR: Ne moze da se prikaze izvodjac");
                        JOptionPane.showMessageDialog(mainForm, "Ne moze da se prikaze izvodjac");
                        break;
                    }
                    case ERROR_UCITAJ_BEND: {
                        this.mainForm.printNotification("ERROR: Sistem ne moze da ucita bend");
                        JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da ucita bend");
                        break;
                    }
                    case ERROR_UPDATE_IZVODJACA: {
                        this.mainForm.printNotification("ERROR: Sistem ne moze da zapamti izvodjaca");
                        JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da zapamti izvodjaca");
                        break;
                    }
                    case ERROR_UPDATE_BEND: {
                        this.mainForm.printNotification("ERROR: Sistem ne moze da zapamti bend");
                        JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da zapamti bend");
                        break;
                    }
                    case ERROR_UCITAJ_LISTU_IZVODJACA: {
                        this.mainForm.printNotification("ERROR: Sistem ne moze da ucita listu izvodjaca");
                        JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da ucita listu izvodjaca");
                        break;
                    }
                    case ERROR_UCITAJ_LISTU_BENDOVA: {
                        this.mainForm.printNotification("ERROR: Sistem ne moze da ucita listu bendova");
                        JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da ucita listu bendova");
                        break;
                    }
                    case ERROR_ZAPAMTI_BEND: {
                        this.mainForm.printNotification("ERROR: Sistem ne moze da zapamti bend");
                        JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da zapamti bend");
                        break;
                    }
                    case ERROR_ZAPAMTI_NASTUP: {
                        this.mainForm.printNotification("ERROR: Sistem ne moze da zapamti nastup");
                        JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da zapamti nastup");
                        break;
                    }
                    case ERROR_UCITAJ_NASTUP: {
                        this.mainForm.printNotification("ERROR: Ne moze da se prikaze nastup");
                        JOptionPane.showMessageDialog(mainForm, "Ne moze da se prikaze nastup");
                        break;
                    }
                    case ERROR_UPDATE_NASTUP: {
                         this.mainForm.printNotification("ERROR: Sistem ne moze da update nastup");
                        JOptionPane.showMessageDialog(mainForm, "Sistem ne moze da update nastup");
                        break;
                    }
                    default: {
                        this.mainForm.printNotification("DEFAULT OPTION IN NitZaPrianjePoruka");
                        break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(NitZaPrimanjePoruka.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NitZaPrimanjePoruka.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static NitZaPrimanjePoruka getInstance() {
        if (instance == null) {
            instance = new NitZaPrimanjePoruka();
            System.out.println("Napravljena je nit za primanje poruka!!!");
        }
        return instance;
    }

    public void setSocket(ObjectInputStream objectInputStream, Socket socket) {
        this.objectInputStream = objectInputStream;
        this.socket = socket;
    }

}
