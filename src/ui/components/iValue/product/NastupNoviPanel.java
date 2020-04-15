/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.iValue.product;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import model.Bend;
import model.DomainObject;
import model.Izvodjac;
import model.Menadzer;
import model.Nastup;
import model.StavkaNastupa;
import ui.components.iValue.IValue;
import vrednosniValidator.VrednosniValidator;
import vrednosniValidator.impl.VrednosniValidatorDefault;

/**
 * kada se napravi potrebno je naknadno ubaciti listu Izvodjac/Bend u panel stavke nastupa
 * @author Aleksa
 */
public class NastupNoviPanel extends javax.swing.JPanel implements IValue{

    VrednosniValidator validator;
    Menadzer ulogovanMenadzer;
    List<DomainObject> pomocnaLista;
    
    /**
     * kada se napravi potrebno je naknadno ubaciti listu Izvodjac/Bend u panel stavke nastupa
     */
    public NastupNoviPanel() {
        initComponents();
        validator = new VrednosniValidatorDefault();
        pomocnaLista =  new ArrayList<>();
        preparePanel();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idNastupaPanel = new ui.components.iValue.impl.InputPanelTextField();
        nazivNastupaPanel = new ui.components.iValue.impl.InputPanelTextField();
        opisPanel = new ui.components.iValue.impl.InputPanelTextArea();
        lokacijaPanel = new ui.components.iValue.impl.InputPanelTextField();
        brnSacuvaj = new javax.swing.JButton();
        stavkaNastupaPanel1 = new ui.components.iValue.impl.StavkaNastupaPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Nastup"));

        brnSacuvaj.setText("Sacuvaj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(opisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idNastupaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nazivNastupaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lokacijaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(brnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stavkaNastupaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(idNastupaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nazivNastupaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lokacijaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stavkaNastupaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * uzima Nastup sa panela bez id
     * @return Nastup
     * @throws Exception 
     */
    @Override
    public Object getValue() throws Exception {
        validator.validate();
        getLoginMenadzer();
        return (Nastup.NastupNoviFactory((String)this.nazivNastupaPanel.getValue(),
                (String)this.opisPanel.getValue(),
                this.ulogovanMenadzer,
                (String)this.lokacijaPanel.getValue()))
                .appendListaStavki((List<StavkaNastupa>) this.stavkaNastupaPanel1
                .getValue());
    }

    /**
     * postavlja Izabrani nastup na panel
     * @param value 
     */
    @Override
    public void setValue(Object value) {
        if (value instanceof Nastup) {
            Nastup nastup = (Nastup) value;
            idNastupaPanel.setValue(nastup.getIdNastupa());
            opisPanel.setValue(nastup.getOpis());
            nazivNastupaPanel.setValue(nastup.getNazivNastupa());
            lokacijaPanel.setValue(nastup.getLokacija());
            stavkaNastupaPanel1.setValue(nastup.getListaStavki());
        }else return;
    }

    /**
     * u listu moraju da se ubace i bendovi i zivodjaci
     * ubacuje listu Izvodjaca/Bendova
     * @param initValue List<DomainObject> 
     */
    @Override
    public void inicialize(Object initValue) {
        this.stavkaNastupaPanel1.inicialize(initValue);
    }

    @Override
    public void setValidator(VrednosniValidator validator) {
        this.validator = validator;
    }

    private void preparePanel() {
        this.idNastupaPanel.getJlabText().setText("ID Nastupa:");
        this.idNastupaPanel.getJlabError().setText("");
        this.idNastupaPanel.getJtxtInput().setText("");
        this.idNastupaPanel.getJtxtInput().setEnabled(false);

        this.opisPanel.getJlabText().setText("Opis:");
        this.opisPanel.getJlabError().setText("");
        this.opisPanel.getjTextArea().setText("");

        this.nazivNastupaPanel.getJlabText().setText("Naziv:");
        this.nazivNastupaPanel.getJlabError().setText("");
        this.nazivNastupaPanel.getJtxtInput().setText("");
        
        this.lokacijaPanel.getJlabText().setText("Lokacija:");
        this.lokacijaPanel.getJlabError().setText("");
        this.lokacijaPanel.getJtxtInput().setText("");
    }

    public JButton getBrnSacuvaj() {
        return brnSacuvaj;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnSacuvaj;
    private ui.components.iValue.impl.InputPanelTextField idNastupaPanel;
    private ui.components.iValue.impl.InputPanelTextField lokacijaPanel;
    private ui.components.iValue.impl.InputPanelTextField nazivNastupaPanel;
    private ui.components.iValue.impl.InputPanelTextArea opisPanel;
    private ui.components.iValue.impl.StavkaNastupaPanel stavkaNastupaPanel1;
    // End of variables declaration//GEN-END:variables

    private void getLoginMenadzer() {
        this.ulogovanMenadzer = applicationController.ApplicationController.getInstance()
                .getLogedInMenadzer();
    }

    public void dodajListuIzvodjaca(List<Izvodjac> listaIzvodjaca) {
        if (pomocnaLista == null) {
            pomocnaLista =  new ArrayList<>();
        }
        for (Izvodjac izvodjac : listaIzvodjaca) {
            pomocnaLista.add(izvodjac);
        }
        inicialize(pomocnaLista);
    }

    public void dodajListuBendova(List<Bend> listBendova) {
        if (pomocnaLista == null) {
            pomocnaLista =  new ArrayList<>();
        }
        listBendova.forEach((bend) -> {
            pomocnaLista.add(bend);
        });
//        for (Bend bend : listBendova) {
//            pomocnaLista.add(bend);
//        }
        inicialize(pomocnaLista);
    }

    public JButton getBtnSacuvajIzvodjaca() {
        return this.brnSacuvaj;
    }

    public Long getIdNastupa() throws Exception {
        return Long.valueOf((String)this.idNastupaPanel.getValue());
    }

    /**
     * poziva dodajIzvodjace ili dodajBendove u zavisnosti od tipa
     * @param value 
     */
    public void dodajListuIzvodjacaBendova(Object value) {
        try {
            List<Izvodjac> list = (List<Izvodjac>) value;
            this.dodajListuIzvodjaca(list);
        } catch (Exception e) {//ako uvati gresku zna se da nije lista izvodjaca pa mora jedino drugo da bude
            List<Bend> list = (List<Bend>) value;
            this.dodajListuBendova(list);
        }
    }
}