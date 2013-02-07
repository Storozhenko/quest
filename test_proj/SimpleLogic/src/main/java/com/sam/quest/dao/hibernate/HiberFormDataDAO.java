package com.sam.quest.dao.hibernate;

import com.sam.quest.dao.FormDataDAO;
import com.sam.quest.dao.factory.HiberDAOFactory;
import com.sam.quest.entity.FormsData;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HiberFormDataDAO implements FormDataDAO {

    private boolean res;
    private Transaction tr;
    private Session session;

    public boolean insertFormData(FormsData formData){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.save(formData);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
    public boolean deleteFormData(FormsData formData){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.delete(formData);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
    public FormsData findFormData(long formDataId){
        res = true;
        FormsData formData = new FormsData();
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            formData = (FormsData)session.get(FormsData.class, formDataId);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return formData;
    }
    public boolean updateFormData(FormsData formData){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.update(formData);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
}
