package com.sam.quest.dao.hibernate;

import com.sam.quest.dao.FormDAO;
import com.sam.quest.dao.factory.HiberDAOFactory;
import com.sam.quest.entity.Forms;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HiberFormDAO implements FormDAO {

    private boolean res;
    private Transaction tr;
    private Session session;

    public boolean insertForm(Forms form){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.save(form);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }

    public boolean deleteForm(Forms form){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.delete(form);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }

    public Forms findForm(long formId){
        res = true;
        Forms form = new Forms();
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            form = (Forms)session.get(Forms.class, formId);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return form;
    }

    public boolean updateForm(Forms form){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.update(form);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
}
