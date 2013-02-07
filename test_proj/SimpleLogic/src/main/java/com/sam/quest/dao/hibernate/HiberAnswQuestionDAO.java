package com.sam.quest.dao.hibernate;

import com.sam.quest.dao.AnswQuestionDAO;
import com.sam.quest.dao.factory.HiberDAOFactory;
import com.sam.quest.entity.AnswQuestions;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HiberAnswQuestionDAO implements AnswQuestionDAO {

    private boolean res;
    private Transaction tr;
    private Session session;

    public boolean insertAnswQuestion(AnswQuestions answForm){
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
    public boolean deleteAnswQuestion(AnswQuestions answQuest){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.delete(answQuest);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
    public AnswQuestions findAnswQuestion(long answQuestId){
        res = true;
        AnswQuestions answQuest = new AnswQuestions();
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            answQuest = (AnswQuestions)session.get(AnswQuestions.class, answQuestId);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return answQuest;
    }
    public boolean updateAnswQuestion(AnswQuestions answQuest){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.update(answQuest);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
}
