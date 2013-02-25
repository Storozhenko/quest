package com.sam.quest.command;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class TransactionalPerformer <E> {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public E executeCommand(Command <E> command) throws Exception {
        E obj = command.execute(sessionFactory.openSession());
        sessionFactory.close();
        return obj;
    }

}
