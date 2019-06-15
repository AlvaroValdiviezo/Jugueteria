/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.LoginBean;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
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
public class LoginFormBean implements Serializable{
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    private String nombreUsuario;
    private String password;
    private Usuario unUsuario;
    private Cliente unCliente;

    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
        unUsuario=new Usuario();
        unCliente=new Cliente();
    }
    
        public String validarUsuario(){
         String pagina=null;
         Usuario usu = getLoginBean().validarUsuario(nombreUsuario, password);
         if(usu == null){
             FacesMessage facesMessage =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales invalidas","Credenciales invalidas");
             FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            
         }else{
             FacesMessage facesMessage =new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario Valido","Usuario Valido");
             FacesContext.getCurrentInstance().addMessage(null, facesMessage);
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UsuarioValido", usu);
             if(usu.getTipoUsuario()=="cliente"){
             pagina="menu?faces-redirect=true";   
             }else{
             pagina= "admin?faces-redirect=true";
             }
         }
         return pagina;
        }
        
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
     * @return the loginBean
     */
    public LoginBean getLoginBean() {
        return loginBean;
    }

    /**
     * @param loginBean the loginBean to set
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    
    
}
