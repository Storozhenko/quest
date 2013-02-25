package com.sam.quest.command;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class TransactionalPerformer <E> {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public E executeCommand(Command <E> command) throws Exception {
        E obj = command.execute(sessionFactory.getCurrentSession());
        return obj;
    }

}
