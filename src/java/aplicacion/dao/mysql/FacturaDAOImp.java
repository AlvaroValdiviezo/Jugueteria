/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IFacturaDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Factura;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Flia. Vilca
 */
public class FacturaDAOImp implements IFacturaDAO{

    @Override
    public Factura obtenerFactura(int numFactura) {
        Factura u=null;
        Session session=NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
         Criteria criteria=session.createCriteria(Factura.class);
        criteria.add(Restrictions.like("numFactura", numFactura));
        if(!criteria.list().isEmpty())
            u=(Factura)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return u; 
    }

    @Override
    public void agregar(Factura unaFactura) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaFactura);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void eliminar(Factura unaFactura) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(unaFactura);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void modificar(Factura unaFactura) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaFactura);
        session.getTransaction().commit();
        session.close();
    }
    
}
