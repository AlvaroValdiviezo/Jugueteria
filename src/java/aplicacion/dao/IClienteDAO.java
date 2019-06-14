/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Cliente;

/**
 *
 * @author Flia. Vilca
 */
public interface IClienteDAO {
    Cliente obtenerCliente(int dni);
    void agregar(Cliente unCliente);
    void eliminar(Cliente unCliente);
    void modificar(Cliente unCliente); 
}
