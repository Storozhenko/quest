package com.sam.quest.dao.hibernate;


import com.sam.quest.dao.factory.HiberDAOFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PerformOperation {
    private boolean res;
    private Command command;
    private Transaction tr;
    private Session session;

    public PerformOperation(Command command) {
        this.command = command;
    }

    public boolean executeCommand() {
        res = true;
        try {
            session = HiberDAOFactory.getSessionFactory().openSession();
            tr = session.beginTransaction();
            command.execute(session);
            tr.commit();
        } catch (Exception e) {
            res = false;
        } finally {
            session.close();
        }
        return res;
    }


}
