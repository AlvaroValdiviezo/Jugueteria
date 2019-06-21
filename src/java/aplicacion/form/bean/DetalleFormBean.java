/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.DetalleBean;
import aplicacion.modelo.dominio.Detalle;
import aplicacion.modelo.dominio.Factura;
import aplicacion.modelo.dominio.Producto;
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
public class DetalleFormBean {
    @ManagedProperty(value = "#{detalleBean}")
    private DetalleBean detalleBean;
    private Factura unaFactura;
    private Producto unProducto;
    private Detalle unDetalle;

    /**
     * Creates a new instance of DetalleFormBean
     */
    public DetalleFormBean() {
        detalleBean =new DetalleBean();
        unaFactura=new Factura();
        unProducto=new Producto();
        unDetalle=new Detalle();
    }
    public void agregarDetalle(){
        unDetalle.setFactura(unaFactura);
        unDetalle.setProductos(unProducto);
        unDetalle.setIddetalle((int) (Math.random()*1000000));
         try {
             detalleBean.agregarDetalle(unDetalle);
             FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Detalle agregado correctamente","Detalle");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo agregar Detalle");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void eliminarDetalle(){
         try {
             detalleBean.eliminarDetalle(unDetalle);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Detalle eliminado correctamente","Detalle");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo eliminar Detalle");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void modificarDetalle(){
         try {
             detalleBean.modificarDetalle(unDetalle);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Detalle modificado correctamente","Detalle");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo modificar Detalle");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }

    /**
     * @return the detalleBean
     */
    public DetalleBean getDetalleBean() {
        return detalleBean;
    }

    /**
     * @param detalleBean the detalleBean to set
     */
    public void setDetalleBean(DetalleBean detalleBean) {
        this.detalleBean = detalleBean;
    }

    /**
     * @return the unaFactura
     */
    public Factura getUnaFactura() {
        return unaFactura;
    }

    /**
     * @param unaFactura the unaFactura to set
     */
    public void setUnaFactura(Factura unaFactura) {
        this.unaFactura = unaFactura;
    }

    /**
     * @return the unProducto
     */
    public Producto getUnProducto() {
        return unProducto;
    }

    /**
     * @param unProducto the unProducto to set
     */
    public void setUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }

    /**
     * @return the unDetalle
     */
    public Detalle getUnDetalle() {
        return unDetalle;
    }

    /**
     * @param unDetalle the unDetalle to set
     */
    public void setUnDetalle(Detalle unDetalle) {
        this.unDetalle = unDetalle;
    }
    
}
