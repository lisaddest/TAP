package modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import repositorio.Repositorio;
import modelo.vo.Cliente;
import controlador.Coordinador;

public class ModeloClientesTabla extends AbstractTableModel {
    Coordinador coordinador;
    
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    private List<Cliente> datosClientes = Repositorio.getRepositorioDeClientes();
    private String titulos [] = {"CURP", "NOMBRE", "APELLIDO 1", "APELLIDO 2", "TELEFONO", "SEXO"};
   
    @Override 
    public int getRowCount() {
        return datosClientes.size();
     
    }
    @Override
    public int getColumnCount(){
        return titulos.length;
    }
    
    @Override 
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = datosClientes.get(rowIndex);
        switch(columnIndex) {
            case 0: return c.getCurp();
            case 1: return c.getNombre();
            case 2: return c.getApellido1();
            case 3: return c.getApellido2();
            case 4: return c.getTelefono();
            case 5: return c.getSexo();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
    
    @Override 
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cliente c = datosClientes.get(rowIndex);
        switch(columnIndex){
            case 0: c.setCurp((String)aValue); break;
            case 1: c.setNombre((String)aValue); break;
            case 2: c.setApellido1((String)aValue); break;
            case 3: c.setApellido2((String)aValue); break;
            case 4: c.setTelefono((String)aValue); break;
            case 5: c.setSexo((Character)aValue); break;       
            
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
