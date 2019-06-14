/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.ModoPago;

/**
 *
 * @author Flia. Vilca
 */
public interface IModoPagoDAO {
    ModoPago obtenerModoPago(int idmodoPago);
    void agregar(ModoPago unModoPago);
    void eliminar(ModoPago unModoPago);
    void modificar(ModoPago unModoPago);
}
