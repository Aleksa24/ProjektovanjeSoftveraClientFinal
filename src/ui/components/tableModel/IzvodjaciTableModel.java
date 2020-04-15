/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Izvodjac;
import model.Pol;

/**
 *
 * @author Aleksa
 */
public class IzvodjaciTableModel extends AbstractTableModel{

    private final List<Izvodjac> listaIzvodjaca;
    private String[] columnNames = {"ID","Ime","Prezime","Email","Telefon","Pol","Tip"};
    private Class[] columnClasses = new Class[]{Long.class, String.class, String.class, String.class, String.class, Pol.class, String.class};
    
    public IzvodjaciTableModel(List<Izvodjac> listaIzvodjaca) {
        this.listaIzvodjaca = listaIzvodjaca;
    }

    @Override
    public int getRowCount() {
        if (listaIzvodjaca == null) {
            return 0;
        }
        return listaIzvodjaca.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Izvodjac izvodjac = listaIzvodjaca.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return izvodjac.getIdIzvodjac();
            case 1:
                return izvodjac.getIme();
            case 2:
                return izvodjac.getPrezime();
            case 3:
                return izvodjac.getEmail();
            case 4:
                return izvodjac.getTelefon();
            case 5:
                return izvodjac.getPol();
            case 6:
                return izvodjac.getTip();
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
    
    public Izvodjac getIzvodjac(int index) {
        return listaIzvodjaca.get(index);
    }
    
}
