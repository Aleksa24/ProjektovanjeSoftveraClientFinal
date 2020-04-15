/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.tableModel;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DomainObject;
import model.StavkaNastupa;

/**
 *
 * @author Aleksa
 */
public class StavkaNastupaTableModel extends AbstractTableModel{

    private String[] columnNames = {"ID","Vreme","Trajanje","Izvodjac"};
    private Class[] columnClasses = new Class[]{Long.class, Date.class, Long.class, DomainObject.class};
    private List<StavkaNastupa> listaStavkiNastupa;
    private int sledeciIdBroj;
    
    public StavkaNastupaTableModel(List<StavkaNastupa> listaStavkiNastupa) {
        this.listaStavkiNastupa = listaStavkiNastupa;
        sledeciIdBroj = 1;
    }
    
    @Override
    public int getRowCount() {
        if (listaStavkiNastupa == null) {
            return 0;
        }
        return listaStavkiNastupa.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaNastupa stavkaNastupa = listaStavkiNastupa.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stavkaNastupa.getIdStavkeNastupa();
            case 1:
                return stavkaNastupa.getVreme();
            case 2:
                return stavkaNastupa.getTrajanje();
            case 3:
                return stavkaNastupa.getIzvodjac();
            
            default:
                return "n/a";
        }
    }
    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }

        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    @Override
    public Class<?> getColumnClass(int column) {
        return columnClasses[column];
    }
    
    public StavkaNastupa getStavkaNastupa(int index) {
        return listaStavkiNastupa.get(index);
    }
    
    public void ubaciStavku(StavkaNastupa stavkaNastupa){
        this.listaStavkiNastupa.add(stavkaNastupa);
        this.setIdStavkeNastupa();
        this.fireTableDataChanged();
    }
    public void izbaciStavku(StavkaNastupa stavkaNastupa){
        this.listaStavkiNastupa.remove(stavkaNastupa);
        fireTableDataChanged();
    }
    public List<StavkaNastupa> getListaStavki(){
        return this.listaStavkiNastupa;
    }

    private void setIdStavkeNastupa() {
        Long br = 1l;
        for (StavkaNastupa stavkaNastupa : listaStavkiNastupa) {
            stavkaNastupa.setIdStavkeNastupa(br);
            br++;
        }
    }
    
}
