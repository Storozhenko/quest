package com.sam.quest.dao.hibernate;

import com.sam.quest.dao.MultiDAO;
import com.sam.quest.dao.factory.HiberDAOFactory;
import com.sam.quest.entity.Forms;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HiberMultiDAO<E> implements MultiDAO<E> {

    private boolean res;
    private Transaction tr;
    private Session session;

    public boolean insertRecord(Object obj){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.save(obj);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }

    public boolean deleteRecord(Object obj){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.delete(obj);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }

    public E findRecord(long id, E obj){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            obj = (E)session.get(obj.getClass(), id);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return obj;
    }

    public boolean updateRecord(Object o){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.update(o);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
}
