/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IModoPagoDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.ModoPago;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Flia. Vilca
 */
public class ModoPagoDAOImp implements IModoPagoDAO{

    @Override
    public ModoPago obtenerModoPago(int idmodoPago) {
       ModoPago u=null;
        Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
         Criteria criteria=session.createCriteria(ModoPago.class);
        criteria.add(Restrictions.like("idmodoPago", idmodoPago));
        if(!criteria.list().isEmpty())
            u=(ModoPago)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return u; 
    }

    @Override
    public void agregar(ModoPago unModoPago) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unModoPago);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(ModoPago unModoPago) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unModoPago);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificar(ModoPago unModoPago) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unModoPago);
        session.getTransaction().commit();
        session.close();
    }
    
}
