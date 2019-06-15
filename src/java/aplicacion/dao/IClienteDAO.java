/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Cliente;


/**
 *
 * @author alvar
 */
public interface IClienteDAO {
    void agregarCliente(Cliente unCliente);
    void modificarCliente(Cliente unCliente);
    void eliminarCliente(Cliente unCliente);
}
