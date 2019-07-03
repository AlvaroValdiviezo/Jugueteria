/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.CategoriaBean;
import aplicacion.bean.ProductoBean;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Producto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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
    @ManagedProperty (value = "#{categoriaBean}")
    private CategoriaBean categoriaBean;
    private int codProducto;
    private Producto unProducto;
    private List<Producto> productos;
    private List<Categoria> categorias;
    private transient UploadedFile archivo=null;

    /**
     * Creates a new instance of ProductoFormBean
     */
    public ProductoFormBean() {
        productoBean=new ProductoBean();
        unProducto=new Producto();
    }
    @PostConstruct
    public void init(){
        obtenerLista();
        listaCategoria();
    }
    public void agregarProducto(){
        if(getArchivo() != null){
            byte[] contents = getArchivo().getContents();
            getUnProducto().setFoto(contents);
        }
        else{
            getUnProducto().setFoto(null);
        }
           try {
               getProductoBean().crearProducto(getUnProducto());
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto agreagado correctamente","Producto");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo agregar Producto");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
           setUnProducto(new Producto());
    }
    public void eliminarProducto(){
         try {
               getProductoBean().eliminarProducto(getUnProducto());
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
               getProductoBean().modificarProducto(getUnProducto());
               FacesMessage facesMesagge=new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto modificado correctamente","Producto");
               FacesContext.getCurrentInstance().addMessage(null, facesMesagge);
           }
           catch(Exception e){
               FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Grave","no se pudo modificar Producto");
                       FacesContext.getCurrentInstance().addMessage(null, facesMessage);
           }
    }
    public void obtenerLista(){
        setProductos(productoBean.obtenerLista());
    }
    public void listaCategoria(){
        setCategorias(categoriaBean.obtenerLista());
    }
    public StreamedContent getFotoproducto() throws IOException{
     FacesContext context=FacesContext.getCurrentInstance();
     if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE){
      return new DefaultStreamedContent();
     }
     else{
        String codigo=context.getExternalContext().getRequestParameterMap().get("codProducto");
        Producto producto=getProductoBean().obtenerProducto(Integer.parseInt(codigo));
        if (producto.getFoto()==null){
         return null;
        }
        else{
         return new DefaultStreamedContent(new ByteArrayInputStream(producto.getFoto()));        
        }
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

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the categorias
     */
    public List<Categoria> getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    /**
     * @return the categoriaBean
     */
    public CategoriaBean getCategoriaBean() {
        return categoriaBean;
    }

    /**
     * @param categoriaBean the categoriaBean to set
     */
    public void setCategoriaBean(CategoriaBean categoriaBean) {
        this.categoriaBean = categoriaBean;
    }
    
}
