package controlador;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import modelo.ClienteJComboModelo;
import modelo.logica.ClienteLogica;
import modelo.vo.Cliente;
import modelo.vo.ClienteCuenta;
import modelo.vo.Cuenta;
import modelo.logica.CuentaLogica;
import vista.JTableClientes;
import vista.JTableCuentas;
import vista.MainMenu;
import vista.Principal;
import vista.VentanaCliente;
import vista.VentanaCuenta;
import modelo.ModeloClientesTabla;
import modelo.ModeloCuentasTabla;
//import vista.VentanaTablaClientes;

public class Coordinador {
    //
    private MainMenu mainMenu;  
    private Principal ventanaPrincipal; 
    private VentanaCliente ventanaCliente;
    private JTableClientes ventanaJTableClientes;
    private ClienteLogica logicaCliente;
    private CuentaLogica logicaCuenta;
    private ClienteJComboModelo clienteJComboModelo;
    private VentanaCuenta ventanaCuenta;
    private JTableCuentas ventanaJTableCuentas;
    
    private ModeloClientesTabla modeloClienteTabla;
    private ModeloCuentasTabla modeloCuentasTabla;
    
    
    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }
    
    public void setVentanaPrincipal(Principal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
    public void setVentanaCliente(VentanaCliente ventanaCliente) {
        this.ventanaCliente = ventanaCliente;
        
    }
    public void setVentanaJTableClientes(JTableClientes ventanaJTableClientes) {
        this.ventanaJTableClientes = ventanaJTableClientes;
    }
    public void setVentanaCuenta(VentanaCuenta ventanaCuenta) {
        this.ventanaCuenta = ventanaCuenta;
    }
    public void setVentanaJTableCuentas(JTableCuentas ventanaJTableCuentas) {
        this.ventanaJTableCuentas = ventanaJTableCuentas;
    }
    public void setLogicaCliente(ClienteLogica logicaCliente) {
        this.logicaCliente = logicaCliente;
    }
    public void setModeloClienteTabla(ModeloClientesTabla modeloClienteTabla){
        this.modeloClienteTabla = modeloClienteTabla;
    }
    public void setModeloCuentasTabla(ModeloCuentasTabla modeloCuentasTabla) {
        this.modeloCuentasTabla = modeloCuentasTabla;
    }
    public void setClienteJComboModelo(ClienteJComboModelo clienteJComboModelo) {
        this.clienteJComboModelo = clienteJComboModelo;
    }
    
    public ModeloClientesTabla getModeloClienteTabla(){
        return modeloClienteTabla;
    }
    
    public ModeloCuentasTabla getModeloCuentasTabla(){
        return modeloCuentasTabla;
    }
    public void cargarCuentas() {
        modeloCuentasTabla.cargarCuentas();
    }
    public void addTableModelListenerCoordinador(JTable table){
        modeloCuentasTabla.addTableModelListener(table);
    }
    public ClienteJComboModelo getModeloClienteComboBox(){
        return clienteJComboModelo;
    }
    public void setLogicaCuenta(CuentaLogica logicaCuenta) {
        this.logicaCuenta = logicaCuenta;
    }
    
    public void mostrarMainMenu(){
        this.mainMenu.setVisible(true);
    }
    
    public void mostrarPrincipal(JPanel dashBoard) {
        dashBoard.removeAll();
        dashBoard.add(this.ventanaPrincipal, BorderLayout.CENTER);
        dashBoard.revalidate();
        dashBoard.repaint();
    }
    
    public void mostrarVentanaCliente(JPanel dashBoard) {
        dashBoard.removeAll();
        dashBoard.add(this.ventanaCliente, BorderLayout.CENTER);
        dashBoard.revalidate();
        dashBoard.repaint();
        
    }
    public void mostrarVentanaJTableClientes(JPanel dashBoard) {
        dashBoard.removeAll();
        dashBoard.add(this.ventanaJTableClientes, BorderLayout.CENTER);
        dashBoard.revalidate();
        dashBoard.repaint();
    }
    public void mostrarVentanaCuenta(JPanel dashBoar){
        dashBoar.removeAll();
        
        Cliente cte = logicaCliente.getClienteActual();
        if(cte.getCurp() !=null){
            ventanaCuenta.ponerTitular(cte);
        }
        dashBoar.add(this.ventanaCuenta, BorderLayout.CENTER);
        dashBoar.revalidate();
        dashBoar.repaint();
    }
    public void mostrarVentanaJTableCuentas(JPanel dashBoar){
        dashBoar.removeAll();
        dashBoar.add(this.ventanaJTableCuentas, BorderLayout.CENTER);
        dashBoar.revalidate();
        dashBoar.repaint();
    }
    public void agregarCliente(Cliente cte){
        logicaCliente.agregar(cte);
        clienteJComboModelo.addElement(cte);
    }
    public int modificarCliente(Cliente cte){
        logicaCliente.modificar(cte);
        return 1;
    }
    public int eliminarCliente(Cliente cte){
        logicaCliente.eliminar(cte);
        int num = clienteJComboModelo.getSize();
        int posicion = -1;
        for(int i=0; i<num; i++){
            Cliente c= clienteJComboModelo.getElementAt(i);
            
            if(cte.equals(c)){
                posicion = i;
                break;
            }
        }
        if posicion > -1){
            clienteJComboModelo.removeElementAt(posicion);
        }
        return 1;
    }
    public Cliente consultarCliente (String curp) {
        Cliente cte = logicaCliente.consultar(curp);
        return cte;
    }
    public Cliente getClienteActual(){
        return logicaCliente.getClienteActual();
    }
    public void setClienteActual(Cliente cliente){
        logicaCliente.setClienteActual(cliente);
    }
    public void agregarCuenta(Cuenta cta){
        logicaCuenta.agregar(cta);
    }
    public void agregarClienteCuenta(ClienteCuenta clienteCuenta){
        logicaCuenta.agregaClienteCuenta(clienteCuenta);
    }
    public int modificarCuenta(Cuenta cta){
        logicaCuenta.modificar(cta);
        return 1;
    }
    public int eliminarCuenta(Cuenta cta) {
        logicaCuenta.eliminar(cta);
        return 1;
    }
    public Cuenta consultarCliente(int numTarjeta) {
        Cuenta cta = logicaCuenta.consultar(numTarjeta);
        return cta;
    }
}
    
