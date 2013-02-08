package com.sam.quest.dao.factory;

import com.sam.quest.dao.*;
import com.sam.quest.dao.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HiberDAOFactory implements DAOFactory{

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            //throw new Exception(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public MultiDAO getFactory() {
        return new HiberMultiDAO();
    }
    /*//stubs
    public MultiDAO getFormDAO() {
        return new HiberMultiDAO();
    }
    public MultiDAO getUserDAO() {
        return new HiberMultiDAO();
    } */

}
