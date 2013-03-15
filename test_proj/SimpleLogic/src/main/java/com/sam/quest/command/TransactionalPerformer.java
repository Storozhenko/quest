package com.sam.quest.command;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class TransactionalPerformer <E> {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
    this.hibernateTemplate = hibernateTemplate;
    }

    public E executeCommand(Command <E> command) throws Exception {
        E obj = command.execute(hibernateTemplate);
        return obj;
    }

}
