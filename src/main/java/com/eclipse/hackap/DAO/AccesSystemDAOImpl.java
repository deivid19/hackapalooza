/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eclipse.hackap.DAO;

import com.eclipse.hackap.Model.Perfil;
import com.eclipse.hackap.Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iCharly
 */
@Transactional
@Repository
public class AccesSystemDAOImpl implements AccesSystemDAO {

    static final Logger LOG = LogManager.getLogger(AccesSystemDAOImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    //@Transactional(readOnly=true)
    public List<Object[]> getCredenciales(String usuario, String pass) {
        LOG.debug("Entra a getCredenciales");

        List<Object[]> lista = new ArrayList();

        final String consulta = "SELECT id_usuario, nombre_usuario, password FROM usuarios "
                + " WHERE nombre_usuario='" + usuario + "' AND password='" + pass + "';";
        
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createSQLQuery(consulta);
            lista = query.list();
            System.out.println("Query: " + consulta);

        } catch (HibernateException e) {
            LOG.error("Error en getListaUsuarios: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Object[]> obtenerUsuario(String id_usuario) {
        LOG.debug("Entra a obtenerUsuario");

        final String consulta = "SELECT id_tipo, id_detalle "
                + "FROM detalle_usuarios "
                + " WHERE id_usuario='" + id_usuario + "';";
        List<Object[]> list = new ArrayList();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createSQLQuery(consulta);
            list = query.list();
            System.out.println(" query: " + consulta);

        } catch (HibernateException e) {
            LOG.error("Error en obtenerIncludeJsp: " + e.getMessage(), e);
        }

        return list;
    }

    private String getPerfilById(int idPerfil) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Perfil.class);
        criteria.add(Restrictions.eq("id", idPerfil));
        Perfil perfil = (Perfil) criteria.uniqueResult();
        return perfil.getAbreviacion();
    }

    /*
    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
     */
    @Override
    public List<Object[]> obtenerIncludeJsp(String id_tipo) {
        

        final String consulta = "SELECT mapeo, estilo FROM cat_usuarios WHERE id_tipo=" + id_tipo + " ;";

        List<Object[]> list = new ArrayList();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createSQLQuery(consulta);
            list = query.list();
            System.out.println(" query: " + consulta);

        } catch (HibernateException e) {
            LOG.error("Error en obtenerIncludeJsp: " + e.getMessage(), e);
        }

        return list;
    }

}
