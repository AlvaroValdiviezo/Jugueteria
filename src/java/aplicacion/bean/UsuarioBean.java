/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDAOImp;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alvar
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {
    private IUsuarioDAO usuarioDAO;

    /**
     * Creates a new instance of LoginBean
     */
    public UsuarioBean() {
        usuarioDAO = new UsuarioDAOImp();
    }
   public void agregarUsuario(Usuario unUsuario){
       usuarioDAO.crearUsuario(unUsuario);
   }
   public void modificarUsuario(Usuario unUsuario){
       usuarioDAO.modificarUsuario(unUsuario);
   }
   public void eliminarUsuario(Usuario unUsuario){
       usuarioDAO.eliminarUsuario(unUsuario);
   }
   public Usuario obtenerUsuario(String nombreUsuario){
       return usuarioDAO.obtenerUsuario(nombreUsuario);
   }
   public List<Usuario> listaUsuario(){
       return usuarioDAO.listaUsuario();
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
