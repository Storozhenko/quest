package com.sam.quest.command;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DeleteCommand<E> implements Command <Void> {
    E obj;
    public DeleteCommand(E obj) {
        this.obj = obj;
    }
    public Void execute(HibernateTemplate hibernateTemplate) throws Exception{
        hibernateTemplate.delete(obj);

        return null;
    }
}
