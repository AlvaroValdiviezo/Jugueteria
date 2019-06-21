/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IModoPagoDAO;
import aplicacion.dao.mysql.ModoPagoDAOImp;
import aplicacion.modelo.dominio.ModoPago;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alvar
 */
@ManagedBean
@RequestScoped
public class ModoPagoBean {
    private IModoPagoDAO modopagoDAO;
    private ModoPago unModoPago;

    /**
     * Creates a new instance of ModoPagoBean
     */
    public ModoPagoBean() {
        modopagoDAO=new ModoPagoDAOImp();
        unModoPago=new ModoPago();
    }
    public void crearModoPago(ModoPago unModoPago){
        getModopagoDAO().agregar(unModoPago);
    }
    public void eliminarModoPago(ModoPago unModoPago){
        getModopagoDAO().eliminar(unModoPago);
    }
    public void modificarModoPago(ModoPago unModoPago){
        getModopagoDAO().modificar(unModoPago);
    }
    public ModoPago obtenerModoPago(int idModoPago){
        return getModopagoDAO().obtenerModoPago(idModoPago);
    }

    /**
     * @return the modopagoDAO
     */
    public IModoPagoDAO getModopagoDAO() {
        return modopagoDAO;
    }

    /**
     * @param modopagoDAO the modopagoDAO to set
     */
    public void setModopagoDAO(IModoPagoDAO modopagoDAO) {
        this.modopagoDAO = modopagoDAO;
    }

    /**
     * @return the unModoPago
     */
    public ModoPago getUnModoPago() {
        return unModoPago;
    }

    /**
     * @param unModoPago the unModoPago to set
     */
    public void setUnModoPago(ModoPago unModoPago) {
        this.unModoPago = unModoPago;
    }
    
}
