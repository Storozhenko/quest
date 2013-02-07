package com.sam.quest.dao.hibernate;

import com.sam.quest.dao.QuestionDAO;
import com.sam.quest.dao.factory.HiberDAOFactory;
import com.sam.quest.entity.Questions;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HiberQuestionDAO implements QuestionDAO {

    private boolean res;
    private Transaction tr;
    private Session session;

    public boolean insertQuestion(Questions quest){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.save(quest);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }

    public boolean deleteQuestion(Questions quest){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.delete(quest);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }

    public Questions findQuestion(long questId){
        res = true;
        Questions quest = new Questions();
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            quest = (Questions)session.get(Questions.class, questId);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return quest;
    }

    public boolean updateQuestion(Questions quest){
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.update(quest);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }
}
