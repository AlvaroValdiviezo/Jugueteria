/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.IProductoDAO;
import aplicacion.dao.mysql.ProductoDAOImp;
import aplicacion.modelo.dominio.Producto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alvar
 */
@ManagedBean
@RequestScoped
public class ProductoBean{
    private IProductoDAO productoDao;
    private Producto unProducto;

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
        productoDao=new ProductoDAOImp();
        unProducto=new Producto();
    }
    public void crearProducto(Producto unProducto){
        getProductoDao().agregar(unProducto);
    }
    public void eliminarProducto(Producto unProducto){
        getProductoDao().eliminar(unProducto);
    }
    public void modificarProducto(Producto unProducto){
        getProductoDao().modificar(unProducto);
    }
    public Producto obtenerProducto(int codProducto){
    return getProductoDao().obtenerProducto(codProducto);}

    /**
     * @return the productoDao
     */
    public IProductoDAO getProductoDao() {
        return productoDao;
    }

    /**
     * @param productoDao the productoDao to set
     */
    public void setProductoDao(IProductoDAO productoDao) {
        this.productoDao = productoDao;
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
    
}
