/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.ClienteBean;
import aplicacion.modelo.dominio.Cliente;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author alvar
 */
@ManagedBean
@RequestScoped
public class ClienteFormBean {
    @ManagedProperty(value = "#{clienteBean}")
    private ClienteBean clienteBean;
    private Cliente unCliente;

    /**
     * Creates a new instance of ClienteFormBean
     */
    public ClienteFormBean() {
        unCliente=new Cliente();
    }
    public void agregarCliente(){
        getClienteBean().agregarCliente(unCliente);
    }
    public void modificarCliente(){
         try {
               clienteBean.modificarCliente(unCliente);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"usuario eliminado correctamente","Cliente");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo modificar cliente");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void eliminarCliente(){
         try {
               clienteBean.eliminarCliente(unCliente);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente eliminado correctamente","Cliente");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo eliminar Cliente");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
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
}
