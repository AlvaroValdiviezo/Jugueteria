/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IClienteDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Cliente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Flia. Vilca
 */
public class ClienteDAOImp implements IClienteDAO{

    @Override
    public void agregar(Cliente unCliente) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unCliente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Cliente unCliente) {
      Session session=NewHibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(unCliente);
      session.getTransaction().commit();
      session.close();  
    }

    @Override
    public void modificar(Cliente unCliente) {
      Session session=NewHibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(unCliente);
      session.getTransaction().commit();
      session.close();  
    }

    @Override
    public Cliente obtenerCliente(int dni) {
        Cliente u=null;
        Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
         Criteria criteria=session.createCriteria(Cliente.class);
        criteria.add(Restrictions.like("dni", dni));
        if(!criteria.list().isEmpty())
            u=(Cliente)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return u;
    }
    
}
