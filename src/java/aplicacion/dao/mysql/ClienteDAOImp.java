/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.mysql;

import aplicacion.dao.IClienteDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Cliente;
import org.hibernate.Session;

/**
 *
 * @author alvar
 */
public class ClienteDAOImp implements IClienteDAO {

    @Override
    public void agregarCliente(Cliente unCliente) {
       Session session= NewHibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       session.save(unCliente);
       session.getTransaction().commit();
       session.close();
    }

    @Override
    public void modificarCliente(Cliente unCliente) {
       Session session= NewHibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       session.update(unCliente);
       session.getTransaction().commit();
       session.close();
    }

    @Override
    public void eliminarCliente(Cliente unCliente) {
       Session session= NewHibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       session.delete(unCliente);
       session.getTransaction().commit();
       session.close();
    }
    
}
