/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Flia. Vilca
 */
@ManagedBean
@RequestScoped
public class LoginBean {
 private IUsuarioDAO usuarioDAO;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        usuarioDAO=new UsuarioDAOImp();
    }
    
    public Usuario validarUsuario(String nombre, String password){
     return getUsuarioDAO().validarUsuario(nombre, password);
    }

    /**
     * @return the usuarioDAO
     */
    public IUsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    /**
     * @param usuarioDAO the usuarioDAO to set
     */
    public void setUsuarioDAO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    
}
