/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Bend;

/**
 *
 * @author Aleksa
 */
public class BendTableModel extends AbstractTableModel{
    private final List<Bend> listaBendova;
    private String[] columnNames = {"ID","Naziv benda","Email","Telefon","Tip"};
    private Class[] columnClasses = new Class[]{Long.class, String.class, String.class, String.class, String.class};
    public BendTableModel(List<Bend> listaBendova) {
        this.listaBendova = listaBendova;
    }

    @Override
    public int getRowCount() {
        if (listaBendova == null) {
            return 0;
        }
        return listaBendova.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bend bend = listaBendova.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return bend.getIdIzvodjaca();
            case 1:
                return bend.getNazivBenda();
            case 2:
                return bend.getEmail();
            case 3:
                return bend.getTelefon();
            case 4:
                return bend.getTip();
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
    
    public Bend getBend(int index) {
        return listaBendova.get(index);
    }
}
