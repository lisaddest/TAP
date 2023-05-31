package controlador;

import vista.MainMenu;
import vista.VentanaCliente;
import modelo.logica.ClienteLogica;
import modelo.logica.CuentaLogica;
import vista.JTableClientes;
import vista.Principal;
import modelo.ClienteJComboModelo;
import modelo.ModeloClientesTabla;
import modelo.ModeloCuentasTabla;
import modelo.vo.Cliente;
import repositorio.Repositorio;
import vista.VentanaCuenta;
import vista.JTableCuentas;

public class Relaciones {
    public void iniciar(){
        Coordinador coordinador = new Coordinador();
        Cliente clientes[] = Repositorio.getArregloDeClientes();
        
        MainMenu mainMenu = new MainMenu();
        mainMenu.setCoordinador(coordinador);
        coordinador.setMainMenu(mainMenu);
        
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setCoordinador(coordinador);
        coordinador.setVentanaPrincipal(ventanaPrincipal);
        
        VentanaCliente ventanaCliente = new VentanaCliente();
        ventanaCliente.setCoordinador(coordinador);
        coordinador.setVentanaCliente(ventanaCliente);
        
        JTableClientes ventanaTableClientes = new JTableClientes();
        ventanaTableClientes.setCoordinador(coordinador);
        coordinador.setVentanaCuenta(ventanaCuenta);
        
        JTableCuenta ventanaTablecuentas = new JTableCuentas();
        ventanaTablecuentas.setCoordinador(coordinador);
        coordinador.setVentanaJTableCuentas(ventanaTablecuentas);
        
        ClienteLogica logicaCliente = new ClienteLogica();
        logicaCliente.setCoordinador(coordinador);
        coordinador.setLogicaCliente(logicaCliente);
        
        CuentaLogica logicaCuenta = new CuentaLogica();
        logicaCuenta.setCoordinador(coordinador);
        coordinador.setLogicaCuenta(logicaCuenta);
        
        ClienteJComboModelo CJCM = new ClienteJComboModelo(clientes);
        CJCM.setCoordinador(coordinador);
        coordinador.setClienteJComboModelo(CJCM);
        
        ModeloClientesTabla modeloClientesTabla = new ModeloCuentasTabla();
        modeloCuentasTabla.setCoordinador(coordinador);
        coordinador.setModeloCuentasTabla(modeloCuentasTabla);
        
        coordinador.mostrarMainMenu();
    }
    
}
