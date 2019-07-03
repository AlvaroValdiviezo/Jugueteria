/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.dao.ICategoriaDAO;
import aplicacion.dao.mysql.CategoriaDAOImp;
import aplicacion.modelo.dominio.Categoria;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alvar
 */
@ManagedBean
@RequestScoped
public class CategoriaBean {
    private ICategoriaDAO categoriaDao;
    private Categoria unaCategoria;

    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
        categoriaDao=new CategoriaDAOImp();
        unaCategoria=new Categoria();
    }
    public void agregarCategoria(Categoria unaCategoria){
        categoriaDao.agregar(unaCategoria);
    }
    public void eliminarCategoria(Categoria unaCategoria){
        categoriaDao.eliminar(unaCategoria);
    }
    public void modificarCategoria(Categoria unaCategoria){
        categoriaDao.modificar(unaCategoria);
    }
    public Categoria obtenerCategoria(String nombreCat){
        return categoriaDao.obtenerCategoria(nombreCat);
    }
    public List<Categoria> obtenerLista(){
        return categoriaDao.obtenerLista();
    }

    /**
     * @return the categoriaDao
     */
    public ICategoriaDAO getCategoriaDao() {
        return categoriaDao;
    }

    /**
     * @param categoriaDao the categoriaDao to set
     */
    public void setCategoriaDao(ICategoriaDAO categoriaDao) {
        this.categoriaDao = categoriaDao;
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
    
}
