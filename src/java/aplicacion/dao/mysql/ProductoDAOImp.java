/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IProductoDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Producto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Flia. Vilca
 */
public class ProductoDAOImp implements IProductoDAO{

    @Override
    public Producto obtenerProducto(int codProducto) {
        Producto u=null;
        Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
         Criteria criteria=session.createCriteria(Producto.class);
        criteria.add(Restrictions.like("codProducto", codProducto));
        if(!criteria.list().isEmpty())
            u=(Producto)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return u;
    }

    @Override
    public void agregar(Producto unProducto) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unProducto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Producto unProducto) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unProducto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificar(Producto unProducto) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unProducto);
        session.getTransaction().commit();
        session.close();
    }
    
}
