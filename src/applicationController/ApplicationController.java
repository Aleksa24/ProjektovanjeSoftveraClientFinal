/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationController;

import Thread.NitZaPrimanjePoruka;
import communication.CommunicationController;
import formControllers.MainFormController;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Bend;
import model.Izvodjac;
import model.Menadzer;
import model.Nastup;
import model.VrstaIzvodjaca;
import transfer.RequestObject;
import ui.components.iValue.product.BendIzmeniPanel;
import ui.components.iValue.product.BendNoviPanel;
import ui.components.iValue.product.IzvodjacIzmeniPanel;
import ui.components.iValue.product.IzvodjacNoviPanel;
import ui.components.iValue.product.MenadzerNewPanel;
import ui.components.iValue.product.NastupIzmeniPanel;
import ui.components.iValue.product.NastupNoviPanel;
import util.Operation;

/**
 *
 * @author Aleksa
 */
public class ApplicationController {

    private static ApplicationController instance;

    private final MainFormController mainFormController;
    private final CommunicationController comunicationController;
    private final Map<String, Object> mapa;
    private int loginAtempts;

    private ApplicationController() {
        this.mainFormController = new MainFormController();
        mapa = new HashMap<String, Object>();
        comunicationController = new CommunicationController();
        loginAtempts = 3;
    }

    public void start() {
        this.mainFormController.start();
        NitZaPrimanjePoruka.getInstance().start();//startuje se nit
    }

    public static ApplicationController getInstance() {
        if (instance == null) {
            instance = new ApplicationController();
            System.out.println("napravljen je ApplicatoinController");
        }
        return instance;
    }

    public MainFormController getMainFormController() {
        return mainFormController;
    }

    public CommunicationController getComunicationController() {
        return comunicationController;
    }

    public void loginUser(Menadzer menadzer) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_LOGIN);
        requestObject.setData(menadzer);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("loginUser sent to server");
    }

    /**
     * obavestava sistem da treba da se prebaci u ulogovano stanje korisnika
     *
     * @param menadzer
     */
    public void handleSuccesLogin(Menadzer menadzer) {
        this.mainFormController.setLogInState();
        this.mainFormController.printNotification("Loged in: " + menadzer.getImeMenadzera() + " " + menadzer.getPrezimeMenadzera());
        saveLogedInMenadzer(menadzer);
    }

    public void saveLogedInMenadzer(Menadzer menadzer) {
        mapa.put("logedInMenadzer", menadzer);
    }

    public Menadzer getLogedInMenadzer() {
        Menadzer men = (Menadzer) mapa.get("logedInMenadzer");
        if (men == null) {
            return Menadzer.menadzerCreateFactory(null, null, null, null, null, null, null);
        }
        return men;
    }

    /**
     * salje serveru zahtev da odloguje menadzera
     */
    public void logoutMenadzer() throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_LOGOUT_MENADZER);
        requestObject.setData(getLogedInMenadzer());
        saveLogedInMenadzer(null);
        comunicationController.sendRequestObject(requestObject);
        this.mainFormController.printNotification("--Sent Request for logout to server!--");
    }

    /**
     * namesta sistem da bude na log out state
     */
    public void handleSuccesLogOUT() {
        this.mainFormController.setLogOutState();
        this.loginAtempts = 3;
    }

    
    public void failedLogin() {
        this.loginAtempts--;
        if (loginAtempts == 0) {
            JOptionPane.showMessageDialog(null, "No more atempts!!!");
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "You have " + loginAtempts + " atempts!");
    }

    public void saveMenadzer(Menadzer menadzer) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_SAVE_MENADZER);
        requestObject.setData(menadzer);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("saveMenadzer sent to server");
    }

    /**
     * popunice menadzera na panel, ako je PanelMenadzerNew trenutno product
     * @param menadzer 
     */
    public void successSaveMenadzer(Menadzer menadzerNew) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "sistem je zapamtio nalog menadzera");
        if (product instanceof MenadzerNewPanel) {
            ((MenadzerNewPanel) product).setValue(menadzerNew);
        }
    }

    /**
     * salje zahtev serveeru za listu VrstaIzvodjaca, primace kasnije nit za primanje poruka
     * @throws IOException 
     */
    public void ucitajListuVrstaIzvodjaca() throws IOException{
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_GET_ALL_VRSTAIZVODJACA);
        requestObject.setData(null);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("ucitajListuVrstaIzvodjaca sent to server");
    }

    public void successGetAllVrstaIzvodjaca(List<VrstaIzvodjaca> listVrstaIzvodjaca) {
        JPanel product = mainFormController.getMainForm().getProduct();
        if (product instanceof IzvodjacNoviPanel) {
            ((IzvodjacNoviPanel) product).popuniComboBox(listVrstaIzvodjaca);
        }
        if (product instanceof IzvodjacIzmeniPanel) {
            ((IzvodjacIzmeniPanel) product).popuniComboBox(listVrstaIzvodjaca);
        }
    }

    /**
     * samo salje zahtev serveru da sacuva Izvodjaca
     * @param value 
     */
    public void saveOsobaIzvodjac(Izvodjac izvodjac) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_SAVE_IZVODJAC);
        requestObject.setData(izvodjac);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("saveOsobaIzvodjac sent to server");
    }

    public void successSaveIzvodjac(Izvodjac sauvanIzvodjac) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "sistem je zapamtio izvodjaca");
        if (product instanceof IzvodjacNoviPanel) {
            ((IzvodjacNoviPanel) product).setValue(sauvanIzvodjac);
        }
    }

    public void pretraziIzvodjacePoKriterijumu(String zavrsniKriterikum) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_PRETRAZI_PO_KRITERIJUMU);
        requestObject.setData(zavrsniKriterikum);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("pretraziIzvodjacePoKriterijumu sent to server");
    }

    public void successPretrazivanjePoKriterijumu(List<Izvodjac> listaIzvodjacaSaKriterijumom) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "sistem je nasao izvodjace po zadatoj vrednosti");
        if (product instanceof IzvodjacIzmeniPanel) {
            ((IzvodjacIzmeniPanel) product).popuniTabelu(listaIzvodjacaSaKriterijumom);
        }
    }

    /**
     * salje zahtev serveru da vrati izvodjaca, sa sve popunjenom listom
     * @param izvodjac 
     */
    public void ucitajIzvodjaca(Izvodjac izvodjac) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_UCITAJ_IZVODJACA);
        requestObject.setData(izvodjac);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("ucitajIzvodjaca sent to server");
    }

    public void successUcitajIzvodjaca(Izvodjac izvodjac) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "odabrani izvodjac je prikazan");
        if (product instanceof IzvodjacIzmeniPanel) {
            ((IzvodjacIzmeniPanel) product).setValue(izvodjac);
        }
    }

    public void updateIzvodjac(Izvodjac izvodjacZaUpdate) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_UPDATE_IZVODJACA);
        requestObject.setData(izvodjacZaUpdate);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("ucitajIzvodjaca sent to server");
    }

    public void successUpdateIzvodjaca(Izvodjac izvodjac) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "izmenjeni izvodjac je prikazan");
        if (product instanceof IzvodjacIzmeniPanel) {
            ((IzvodjacIzmeniPanel) product).setValue(izvodjac);
        }
    }

    public void ucitajListuIzvodjaca() throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_UCITAJ_LISTU_IZVODJACA);
        requestObject.setData(null);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("ucitajIzvodjaca sent to server");
    }

    public void successUcitajListuIzvodjaca(List<Izvodjac> listaIzvodjaca) {
        JPanel product = mainFormController.getMainForm().getProduct();
        mainFormController.printNotification("primljena lista izvodjaca");
        if (product instanceof BendNoviPanel) {
            ((BendNoviPanel) product).inicialize(listaIzvodjaca);
        }
        if (product instanceof BendIzmeniPanel) {
            ((BendIzmeniPanel) product).inicialize(listaIzvodjaca);
        }
        if (product instanceof NastupNoviPanel) {
            ((NastupNoviPanel) product).dodajListuIzvodjaca(listaIzvodjaca);
        }
        if (product instanceof NastupIzmeniPanel) {
            ((NastupIzmeniPanel) product).inicialize(listaIzvodjaca);
        }
    }

    public void zapamtiBend(Bend bend) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_ZAPAMTI_BEND);
        requestObject.setData(bend);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("zapamtiBend sent to server");
    }

    public void successZapamtiBend(Bend bend) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "Primljen zapamcen bend");
        if (product instanceof BendNoviPanel) {
            ((BendNoviPanel) product).setValue(bend);
        }
    }

    public void pretraziBendovePoKriterijumu(String kriterijum) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_PRETRAZI_PO_KRITERIJUMU_BEND);
        requestObject.setData(kriterijum);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("pretraziBendPoKriterijumu sent to server");
    }

    public void successPretrazivanjePoKriterijumuBend(List<Bend> listaBendovaSaKriterijumom) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "sistem je nasao bendove po zadatoj vrednosti");
        if (product instanceof BendIzmeniPanel) {
            ((BendIzmeniPanel) product).popuniTabelu(listaBendovaSaKriterijumom);
        }
    }

    public void ucitajBend(Bend bend) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_UCITAJ_BEND);
        requestObject.setData(bend);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("ucitajBend sent to server");
    }

    public void successUcitajBend(Bend bend) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "odabrani bend je prikazan");
        if (product instanceof BendIzmeniPanel) {
            ((BendIzmeniPanel) product).setValue(bend);
        }
    }

    public void updateBend(Bend bendZaUpdate) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_UPDATE_BEND);
        requestObject.setData(bendZaUpdate);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("updateBend sent to server");
    }

    public void successUpdateBend(Bend bend) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "izmenjeni bend je prikazan");
        if (product instanceof BendIzmeniPanel) {
            ((BendIzmeniPanel) product).setValue(bend);
        }
    }

    public void ucitajListuBendova() throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_UCITAJ_LISTU_BENDOVA);
        requestObject.setData(null);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("ucitajListuBendova sent to server");
    }

    public void successUcitajListuBendova(List<Bend> list) {
        JPanel product = mainFormController.getMainForm().getProduct();
        mainFormController.printNotification("primljena lista Bendova");
        if (product instanceof NastupNoviPanel) {
            ((NastupNoviPanel) product).dodajListuBendova(list);
        }
        if (product instanceof NastupIzmeniPanel) {
            ((NastupIzmeniPanel) product).inicialize(list);
        }
    }
    
    public void saveNastup(Nastup nastup) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_SAVE_NASTUP);
        requestObject.setData(nastup);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("saveNastup sent to server");
    }

    public void successZapamtuNastup(Nastup nastup) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "Primljen zapamcen nastup");
        if (product instanceof NastupNoviPanel) {
            ((NastupNoviPanel) product).setValue(nastup);
        }
    }

    public void pretraziNastupePoKriterijumu(String kriterijum) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_PRETRAZI_PO_KRITERIJUMU_NASTUP);
        requestObject.setData(kriterijum);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("pretraziNastupePoKriterijumu sent to server");
    }

    public void successPretrazivanjePoKriterijumuNastup(List<Nastup> listaNastupaSaKriterijumom) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "sistem je nasao nastupe po zadatoj vrednosti");
        if (product instanceof NastupIzmeniPanel) {
            ((NastupIzmeniPanel) product).popuniTabelu(listaNastupaSaKriterijumom);
        }
    }

    public void ucitajNastup(Nastup nastup) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_UCITAJ_NASTUP);
        requestObject.setData(nastup);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("ucitajNastup sent to server");
    }

    public void updateNastup(Nastup nastup) throws IOException {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_UPDATE_NASTUP);
        requestObject.setData(nastup);
        comunicationController.sendRequestObject(requestObject);
        System.out.println("updateNastup sent to server");
    }

    public void successUcitajNastup(Nastup nastup) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "odabrani nastup je ucitan");
        if (product instanceof NastupIzmeniPanel) {
            ((NastupIzmeniPanel) product).setValue(nastup);
        }
    }

    public void successUpdateNastup(Nastup nastup) {
        JPanel product = mainFormController.getMainForm().getProduct();
        JOptionPane.showMessageDialog(product, "update nastup je ucitan");
        if (product instanceof NastupIzmeniPanel) {
            ((NastupIzmeniPanel) product).setValue(nastup);
        }
    }

    

}
