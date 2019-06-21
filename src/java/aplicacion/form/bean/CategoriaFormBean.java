/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.CategoriaBean;
import aplicacion.modelo.dominio.Categoria;
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
public class CategoriaFormBean {
    @ManagedProperty (value = "#{categoriaBean}")
    CategoriaBean categoriaBean;
    Categoria unaCategoria;

    /**
     * Creates a new instance of CategoriaFormBean
     */
    public CategoriaFormBean() {
        categoriaBean=new CategoriaBean();
        unaCategoria=new Categoria();
    }
    public void agregarCategoria(){
        unaCategoria.setIdcategoria((int) (Math.random()*1000000));
         try {
               categoriaBean.agregarCategoria(unaCategoria);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Categoria agreagada correctamente","Categoria");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo agregar Categoria");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void eliminarCategoria(){
         try {
               categoriaBean.eliminarCategoria(unaCategoria);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Categoria eliminada correctamente","Producto");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo eliminar Categoria");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void modificrCategoria(){
         try {
               categoriaBean.modificarCategoria(unaCategoria);
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Categoria modificada correctamente","Categoria");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo modificar Categoria");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
}
