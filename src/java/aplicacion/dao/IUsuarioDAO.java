/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;

/**
 *
 * @author Flia. Vilca
 */
public interface IUsuarioDAO {
    Usuario validarUsuario(String nombreUsuario, String password);
    Usuario obtenerUsuario(String nombreUsuario);
    void agregar(Usuario unUsuario);
    void eliminar(Usuario unUsuario);
    void modificar(Usuario unUsuario);
}
