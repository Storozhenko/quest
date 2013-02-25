package com.sam.quest.command;

import com.sam.quest.dao.factory.HiberDAOFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class TransactionalPerformer <E> {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public E executeCommand(Command <E> command) throws Exception {
        E obj = command.execute(HiberDAOFactory.getSessionFactory().openSession());
        HiberDAOFactory.getSessionFactory().close();
        return obj;
    }

}
