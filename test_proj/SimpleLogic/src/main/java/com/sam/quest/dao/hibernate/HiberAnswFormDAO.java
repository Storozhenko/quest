package com.sam.quest.dao.hibernate;

import com.sam.quest.dao.AnswFormDAO;
import com.sam.quest.dao.factory.HiberDAOFactory;
import com.sam.quest.entity.AnswForms;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HiberAnswFormDAO implements AnswFormDAO {

    private boolean res;
    private Transaction tr;
    private Session session;

    public boolean insertAnswForm(AnswForms answForm){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.save(answForm);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
    public boolean deleteAnswForm(AnswForms answForm){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.delete(answForm);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
    public AnswForms findAnswForm(long answFormId){
        res = true;
        AnswForms answForm = new AnswForms();
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            answForm = (AnswForms)session.get(AnswForms.class, answFormId);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return answForm;
    }
    public boolean updateAnswForm(AnswForms answForm){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.update(answForm);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
}
