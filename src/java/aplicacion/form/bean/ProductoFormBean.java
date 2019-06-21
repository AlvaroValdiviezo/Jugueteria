/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.ProductoBean;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Producto;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author alvar
 */
@ManagedBean
@RequestScoped
public class ProductoFormBean implements Serializable{
    @ManagedProperty (value = "#{productoBean}")
    private ProductoBean productoBean;
    private int codProducto;
    private Producto unProducto;
    private Categoria unaCategoria;
    private transient UploadedFile archivo=null;

    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() {
        productoBean=new ProductoBean();
        unProducto=new Producto();
        unaCategoria=new Categoria();
    }
    public void agregarProducto(){
        if(getArchivo() != null){
            byte[] contents = getArchivo().getContents();
            unProducto.setFoto(contents);
        }
        else{
            unProducto.setFoto(null);
        }
        getUnProducto().setCategorias(getUnaCategoria());
           try {
               productoBean.crearProducto(getUnProducto());
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto agreagado correctamente","Producto");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo agregar Producto");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void eliminarProducto(){
         try {
               productoBean.eliminarProducto(getUnProducto());
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto eliminado correctamente","Producto");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo eliminar Producto");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void modificarProducto(){
         try {
               productoBean.modificarProducto(getUnProducto());
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto modificado correctamente","Producto");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo modificar Producto");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }

    /**
     * @return the productoBean
     */
    public ProductoBean getProductoBean() {
        return productoBean;
    }

    /**
     * @param productoBean the productoBean to set
     */
    public void setProductoBean(ProductoBean productoBean) {
        this.productoBean = productoBean;
    }

    /**
     * @return the codProducto
     */
    public int getCodProducto() {
        return codProducto;
    }

    /**
     * @param codProducto the codProducto to set
     */
    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
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
     * @return the unaCategoria
     */
    public Categoria getUnaCategoria() {
        return unaCategoria;
    }

    /**
     * @param unaCategoria the unaCategoria to set
     */
    public void setUnaCategoria(Categoria unaCategoria) {
        this.unaCategoria = unaCategoria;
    }

    /**
     * @return the archivo
     */
    public UploadedFile getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
    
}
