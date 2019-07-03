/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.List;


/**
 *
 * @author alvar
 */
public interface IUsuarioDAO {
    Usuario validarUsuario(String nombreUsuario, String password);
    Usuario obtenerUsuario(String nombreUsuario);
    void modificarUsuario(Usuario unUsuario);
    void crearUsuario(Usuario unUsuario);
    void eliminarUsuario(Usuario unUsuario);
    List<Usuario> listaUsuario();
}
