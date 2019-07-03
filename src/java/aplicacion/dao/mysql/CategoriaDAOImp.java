/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.ICategoriaDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Categoria;
import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Flia. Vilca
 */
public class CategoriaDAOImp implements ICategoriaDAO{

    @Override
    public Categoria obtenerCategoria(String nombreCategoria) {
        Categoria u=null;
        Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria=session.createCriteria(Categoria.class);
        criteria.add(Restrictions.like("nombre", nombreCategoria));
        if(!criteria.list().isEmpty())
            u=(Categoria)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return u;
    }

    @Override
    public void agregar(Categoria unaCategoria) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Categoria unaCategoria) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificar(Categoria unaCategoria) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaCategoria);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Categoria> obtenerLista() {
        List<Categoria> listado = new ArrayList();
                Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("estado", true));
         if(!criteria.list().isEmpty())
            listado=criteria.list();
        session.getTransaction().commit();
        session.close();
        return listado;
    }
    
}
