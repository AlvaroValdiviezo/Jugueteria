/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.ModoPagoBean;
import aplicacion.modelo.dominio.ModoPago;
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
public class ModoPagoFormBean {
    @ManagedProperty(value = "#{modopago}")
    private ModoPagoBean modopago;
    private ModoPago unModoPago;
    private int idModoPago;

    /**
     * Creates a new instance of ModoPagoFormBean
     */
    public ModoPagoFormBean() {
        modopago=new ModoPagoBean();
        unModoPago=new ModoPago();
    }
    public void crearModoPago(){
        try {
            modopago.crearModoPago(unModoPago);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"modo de pago creado correctamente","ModoPago");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo crear modo de pago");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void eliminarModoPago(){
        try {
            modopago.eliminarModoPago(unModoPago);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"modo de pago eliminado correctamente","ModoPago");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo eliminar modo de pago");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void modificarModoPago(){
        try {
            modopago.modificarModoPago(unModoPago);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"modo de pago eliminado correctamente","ModoPago");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo eliminar modo de pago");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void obtenerModoPago(){
        try {
            modopago.obtenerModoPago(idModoPago);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"modo de pago encontrado","ModoPago");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo encontrar modo de pago");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }

    /**
     * @return the modopago
     */
    public ModoPagoBean getModopago() {
        return modopago;
    }

    /**
     * @param modopago the modopago to set
     */
    public void setModopago(ModoPagoBean modopago) {
        this.modopago = modopago;
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

    /**
     * @return the idModoPago
     */
    public int getIdModoPago() {
        return idModoPago;
    }

    /**
     * @param idModoPago the idModoPago to set
     */
    public void setIdModoPago(int idModoPago) {
        this.idModoPago = idModoPago;
    }
    
}
