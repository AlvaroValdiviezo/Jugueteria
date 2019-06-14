/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IDetalleDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Detalle;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Flia. Vilca
 */
public class DetalleDAOImp implements IDetalleDAO{

    @Override
    public Detalle obtenerCategoria(int iddetalle) {
        Detalle u=null;
        Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
         Criteria criteria=session.createCriteria(Detalle.class);
        criteria.add(Restrictions.like("iddetalle", iddetalle));
        if(!criteria.list().isEmpty())
            u=(Detalle)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return u; 
    }

    @Override
    public void agregar(Detalle unDetalle) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unDetalle);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Detalle unDetalle) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unDetalle);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificar(Detalle unDetalle) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unDetalle);
        session.getTransaction().commit();
        session.close();
    }
    
}
