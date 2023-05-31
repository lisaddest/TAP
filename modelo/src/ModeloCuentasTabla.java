package modelo;

import controlador.Coordinador;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.vo.Cliente;
import repositorio.Repositorio;
import modelo.vo.Cuenta;
import modelo.vo.Fecha;
import modelo.logica.ClienteLogica;
import modelo.logica.CuentaLogica;
        
        
public class ModeloCuentasTabla extends AbstractTableModel {
  
    Coordinador coordinador;
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    private CuentaLogica cuentaLogica = new CuentaLogica();
    private ClienteLogica clienteLogica = new ClienteLogica();
    private Cliente clienteActual = clienteLogica.getClienteActual();
    
    private List<Cuenta> datosCuentas;
    
    public ModeloCuentasTabla(){
        super();
        datosCuentas = Repositorio.getRepositorioDeCuentasDeUnCliente();
    }
    private String titulos[] = {"CUENTA", "TARJETA", "LIMITE CREDITO", "CREACION",
        "CORTE", "FECHA PAGO", "TASA", "ANUALIDAD", "APLICACION", "SALDO"};
    
    @Override 
    public int getRowCount() {
        return datosCuentas.size();
    }
    
    @Override
    public int getColumnCount() {
        return titulos.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cuenta c = datosCuentas.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return c.getNumeroCuenta();
            case 1: return c.getNumeroTarjeta();
            case 2: return c.getLimiteCredito();
            case 3: return c.getFechaCreacion();
            case 4: return c.getFechaCorte();
            case 5: return c.getFechaPago();
            case 6: return c.getTasaInteresAnual();
            case 7: return c.getAnualidad();
            case 8: return c.getFechaAplicación();
            case 9: return c.getSaldo();
            
        }
        return null;
        
    }
    
    @Override 
    public String getColumnName(int column) {
        return titulos[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        
        if(getValueAt(o, columnIndex) != null){
            return getValueAt(0, columnIndex).getClass();
        }else{
            return Object.class;
        }
        
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return true;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndez, int columnIndex){
        String fecha;
        Fecha f= null;
        switch (columnIndex){
            case3: case 4: case 5: case 8:{
                fecha =(String)aValue;
                String[] fechaSeparada = fecha.split("/");
                int dia = Integer.parseInt(fechaSeparada[0]);
                int mes = Integer.parseInt(fechaSeparada[1]);
                int anio = Integer.parseInt(fechaSeparada[2]);
                f= new Fecha(dia,mes,anio);
            }
        }
    }
    
    Cuenta c= datosCuentas.get(rowIndex);
    switch (columnIndex){
        case 0: c.setNumeroCuenta((Integer) aValue); break;
        case 1: c.setNumeroTarjeta((Integer) aValue); break;
        case 2: c.setLimiteCredito((Double) aValue); 
        case 3: c.setFechaCreacion((f) aValue); break;
        case 4: c.setFechaCorte((f) aValue); break;
        case 5: c.setFechaPago((f) aValue); break;
        case 6: c.setTasaInteresAnual((Double) aValue); break;
        case 7: c.setAnualidad((Double) aValue); break;
        case 8: c.setFechaAplicación((f) aValue); break;
        case 9: c.setSaldo((Double) aValue); break;
    }
     
    fireTableCellUpdated(rowIndez, columnIndex);
        
    }
    public void cargarCuentas(){
        datosCuentas = cuentaLogica.getListaCuentasDelCliente(clienteActual);
        this.fireTableDataChanged();
    }
    
}
