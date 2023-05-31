package modelo;

import controlador.Coordinador;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.vo.Cliente;

public class ClienteJComboModelo extends DefaultComboBoxModel<Cliente> {
   Coordinador coordinador;
   public void setCoordinador(Coordinador coordinador) {
       this.coordinador = coordinador;
   }
   public ClienteJComboModelo(Cliente clientes[]) {
       super(clientes);
   }
   
   public void agregar(Cliente cliente){
       this.addElement(cliente);
   }
   public void modificar(Cliente cliente){
       
   }
   public void eliminar(Cliente cliente){
       this.removerElement(cliente);
   }
   @Override
   public Cliente getSelectedItem(){
       Cliente selectedJob = (Cliente) super.getSelectedItem();
       return selectedJob;
   }
   
}
