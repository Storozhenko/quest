package com.sam.quest.dao.hibernate;


import com.sam.quest.dao.factory.HiberDAOFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionalPerformer <E> {
    private Transaction tr;
    private Session session;

    public E executeCommand(Command <E> command) throws Exception {
        E obj;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            obj = command.execute(session);
            tr.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return obj;
    }


}
