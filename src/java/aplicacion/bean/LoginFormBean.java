/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author alvar
 */
@ManagedBean
@ViewScoped
public class LoginFormBean implements Serializable{
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private String nombreUsuario;
    private String password;

    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
    }
    
            public String validarUsuario(){
        String pagina=null;
        Usuario usu = usuarioBean.validarUsuario(nombreUsuario, password);
        if(usu == null){
            FacesMessage facesMessage =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales invalidas","Credenciales invalidas");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            
        }else{
            FacesMessage facesMessage =new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario Valido","Usuario Valido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("UsuarioValido", usu);
            pagina= "menu?faces-redirect=true";
        }
        return pagina;
    }
    

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
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
    
    
    
}
