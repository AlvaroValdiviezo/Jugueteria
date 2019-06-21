/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.FacturaBean;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Factura;
import aplicacion.modelo.dominio.ModoPago;
import aplicacion.modelo.dominio.Usuario;
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
public class FacturaFormBean {
    @ManagedProperty( value = "#{facturaBean}")
    private FacturaBean facturaBean;
    private Factura unaFactura;
    private Usuario unUsuario;
    private ModoPago unModoPago;
    private int numFactura;
    /**
     * Creates a new instance of FacturaFormBean
     */
    public FacturaFormBean() {
        facturaBean =new FacturaBean();
        unaFactura=new Factura();
        unUsuario=new Usuario();
        unModoPago=new ModoPago();
    }
    public void CrearFactura(){
        unaFactura.setUsuarios(unUsuario);
        unaFactura.setModopago(unModoPago);
        unaFactura.setNumFactura((int) (Math.random()*100000));
           try {
               facturaBean.crearFactura(unaFactura);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"factura creada correctamente","Factura");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo crear Factura");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void eliminarFactura(){
        try {
               facturaBean.eliminarFactura(unaFactura);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"factura eliminada correctamente","Factura");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo eliminar Factura");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void modificaFactura(){
        try {
               facturaBean.modificarFactura(unaFactura);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"factura modificada correctamente","Factura");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo modificar Factura");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void obtenerFactura(){
        try {
               facturaBean.obtenerFactura(numFactura);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"factura encontrada","Factura");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error","no se pudo encontrar Factura");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }

    /**
     * @return the facturaBean
     */
    public FacturaBean getFacturaBean() {
        return facturaBean;
    }

    /**
     * @param facturaBean the facturaBean to set
     */
    public void setFacturaBean(FacturaBean facturaBean) {
        this.facturaBean = facturaBean;
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
     * @return the unUsuario
     */
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
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
     * @return the numFactura
     */
    public int getNumFactura() {
        return numFactura;
    }

    /**
     * @param numFactura the numFactura to set
     */
    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }
}
