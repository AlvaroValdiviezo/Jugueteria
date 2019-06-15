/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.UsuarioBean;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
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
public class UsuarioFormBean {
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean; 
    private Cliente unCliente;
    private Usuario unUsuario;

    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
        unCliente=new Cliente();
        unUsuario=new Usuario();
    }
    
    public String crearUsuario(){
        String pagina=null;
           getUnUsuario().setEstado(true);
           getUnUsuario().setTipoUsuario("cliente");
           getUnUsuario().setCodigo((int) (Math.random()*1000000));
           getUnUsuario().setClientes(unCliente);
           try {
               usuarioBean.agregarUsuario(unUsuario);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"usuario agreagado correctamente","Usuario" + unUsuario.getApellidos());
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
               pagina="menu?faces-redirect=true";
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo crear usuario");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
           return pagina;
        }
    
        public String crearAdmin(){
           String pagina=null;
           getUnUsuario().setEstado(true);
           getUnUsuario().setTipoUsuario("administrador");
           getUnUsuario().setCodigo((int) (Math.random()*1000000));
           getUnUsuario().setClientes(unCliente);
           try {
               usuarioBean.agregarUsuario(unUsuario);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"usuario agreagado correctamente","Usuario" + unUsuario.getApellidos());
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
               pagina="admin?faces-redirect=true";
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo crear usuario");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
           return pagina;
        }
        public void modificarUsuario(){
             try {
               usuarioBean.modificarUsuario(unUsuario);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"usuario modificado correctamente","Usuario" + unUsuario.getApellidos());
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo modificar usuario");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
            
        }
        public void eliminarUsuario(){
            try {
               usuarioBean.eliminarUsuario(unUsuario);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"usuario eliminado correctamente","Usuario" + unUsuario.getApellidos());
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo eliminado usuario");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
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
    
    
}
