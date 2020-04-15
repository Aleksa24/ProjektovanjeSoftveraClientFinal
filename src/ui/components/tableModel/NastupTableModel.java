/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Menadzer;
import model.Nastup;

/**
 *
 * @author Aleksa
 */
public class NastupTableModel extends AbstractTableModel{

    private final List<Nastup> listaNastupa;
    private String[] columnNames = {"ID","Naziv nastupa","Lokacija","Menadzer"};
    private Class[] columnClasses = new Class[]{Long.class, String.class, String.class, Menadzer.class};
    
    public NastupTableModel(List<Nastup> listaNastupa) {
        this.listaNastupa = listaNastupa;
    }

    @Override
    public int getRowCount() {
        if (listaNastupa == null) {
            return 0;
        }
        return listaNastupa.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nastup nastup = listaNastupa.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return nastup.getIdNastupa();
            case 1:
                return nastup.getNazivNastupa();
            case 2:
                return nastup.getLokacija();
            case 3:
                return nastup.getMenadzer();
            
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
    
    public Nastup getNastup(int index) {
        return listaNastupa.get(index);
    }
    
}
