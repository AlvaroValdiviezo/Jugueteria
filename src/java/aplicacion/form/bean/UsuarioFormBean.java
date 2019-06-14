/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.ClienteBean;
import aplicacion.bean.UsuarioBean;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import static java.lang.reflect.Array.set;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Flia. Vilca
 */
@ManagedBean
@RequestScoped
public class UsuarioFormBean {
   @ManagedProperty(value="#{usuarioBean}")
   private UsuarioBean usuarioBean;
   private ClienteBean clienteBean;
   private Usuario unUsuario;
   private Cliente unCliente;
    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
        unUsuario=new Usuario();
        unCliente=new Cliente();
    }
    
    public void agregarUsuario(){
     
     getUnUsuario().setEstado(true);
     getUnUsuario().setTipoUsuario("cliente");
     getUnUsuario().setClientes(getUnCliente());
     getUnUsuario().setCodigo(152);
     try{
            getUsuarioBean().agregarUsuario(getUnUsuario());
         FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario Agregado correctamente",
                 "Usuario"+getUnUsuario().getApellidos());
         FacesContext.getCurrentInstance().addMessage(null, facesMessage);
     }catch(Exception e){
         FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave",
                 "No se pudo agregar usuario");
          FacesContext.getCurrentInstance().addMessage(null, facesMessage);
     }
    }
    
    public void modificarUsuario(){
        getUsuarioBean().modificarUsuario(getUnUsuario());
    }
    
    public void eliminarUsuario(){
     //usuarioBean.eliminarUsuario(unUsuario);
    }
    

    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    /**
     * @return the unUsuario
     */
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    /**
     * @return the unCliente
     */
    public Cliente getUnCliente() {
        return unCliente;
    }

    /**
     * @param unCliente the unCliente to set
     */
    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    /**
     * @return the clienteBean
     */
    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    /**
     * @param clienteBean the clienteBean to set
     */
    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }
    
}
